package ved.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ved.boot.error.BookNotFoundException;
import ved.boot.error.BookUnSupportedFieldPatchException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;

@RestController
@Validated
public class BookController {

    @Autowired
    private BookRepository repository;
    // CRUD 
    // C - Create  -- POST/PATCH  - Insert -- save()
    // R - Retrieve - GET  -  SELECT - findByxx() , find+abc()  ==> findBystudent()  -- select 
    // U - update -- PUT/PATCH
    // D - delete - DELETE  - drop/delete -- deleteByxx()  - deleteById()

    // Find
    @GetMapping("/books/student")
    List<Book> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED) //201
    Book newBook(@Valid @RequestBody Book newBook) {
        return repository.save(newBook);
    }

    // Find
    @GetMapping("/books/{id}")
    // -- will throw error if pass less than 2 length id, just for demo
//    Book findOne(@PathVariable @Min(2) Long id) { 
      Book findOne(@PathVariable @NotNull @Min(1) Long id) {
        return repository
        		.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    // Save or update
    @PutMapping("/books/{id}")
    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) { // VEd - 

        return repository.findById(id)
                .map(x -> {
                    x.setName(newBook.getName());
                    x.setAuthor(newBook.getAuthor());
                    x.setPrice(newBook.getPrice());
                    
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    // update author only
    @PatchMapping("/books/{id}")
//    -- will throw error if pass less than 5 length id, just for demo
//    Book patch(@RequestBody Map<String, String> update, @PathVariable @Size(min = 5, max = 200) @NotNull Long id) {
    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    
                    if (!StringUtils.isEmpty(author)) {
                    	
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                        
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });

    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
