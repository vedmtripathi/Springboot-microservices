package ved.boot.db.transaction.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ved.boot.db.transaction.model.User;
import ved.boot.db.transaction.service.UserService;

import java.util.Arrays;

/**
 * 
 * @author Ved
 *
 */

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

        try {
            User user1 = new User("IOT", "DElhi", 12000L);
            User user2 = new User("AI", "DElhi", 22000L);
            
            userService.insert(Arrays.asList(
                    user1, user2
            ));
        }
        catch (RuntimeException exception) {
            System.out.println("Exception in batch 1...!" + exception.getMessage());
        }

        try {
            User user3 = new User("Java", "Punjab", 32000L);
            User user4 = new User(".NET", "UP", 18000L);
            
            userService.insert(Arrays.asList(
                    user3, user4
            ));
        }
        catch (RuntimeException exception) {
            System.out.println("Exception in batch 2...!" + exception.getMessage());
        }
        
        // getting all users back from DB
        System.out.println(userService.getUsers());
    }
}
