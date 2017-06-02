package ProjectApi.rest;

import ProjectApi.domain.User;
import ProjectApi.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRest {

    private Logger log = Logger.getLogger(UserRest.class);

    @Autowired
    private UserService userService;

    // get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<User> getAll() {
        return userService.getAllUsers();
    }

    // get one
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // save
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable int id) {
        boolean result = false;

        try {
            userService.deleteUser(id);
            result = true;
        } catch(Exception ex) {
            log.info(ex);
        }

        return result;
    }

}
