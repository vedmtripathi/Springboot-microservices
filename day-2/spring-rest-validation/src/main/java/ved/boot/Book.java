package ved.boot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ved.boot.error.validator.Author;

import java.math.BigDecimal;

@Entity
public class Book {  // @Entity ==> Book Table

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty(message = "Please provide a name")
	
	// -- name char limit is 20, so will throw error
//    @Size(min=2,  max = 20, message="Name should have atleast 2 characters")
	@Size(min = 2, max = 50, message = "Name should have min 2 characters and max 50 characters")
	private String name;

	@Author // custom validation
	@NotEmpty(message = "Please provide a author")
	private String author;

	@NotNull(message = "Please provide a price")
	@DecimalMin("1.00")
	private BigDecimal price;

	// avoid this "No default constructor for entity"
	public Book() {
	}

	public Book(@NotNull @Min(1) Long id,
				@NotNull String name,
				@NotNull String author,
				@NotNull @DecimalMin("1.00") BigDecimal price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Book(@NotNull String name,
				@NotNull String author,
				@NotNull @DecimalMin("1.00") BigDecimal price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", name='" + name + '\'' + ", author='" + author + '\'' + ", price=" + price
				+ '}';
	}
}
