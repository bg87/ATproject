package services;

import api.Application;
import ProjectApi.domain.User;
import ProjectApi.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCrudUser() {

        User user = new User("Jimmy", "jimmy@LedZep.com");

        // save
        assertNull(user.getId());
        User savedUser = userService.saveUser(user);
        assertNotNull(user.getId());

        // get
        User fetchedUser = userService.getUserById(user.getId());
        assertNotNull(fetchedUser);
        assertEquals(savedUser.getId(), fetchedUser.getId());

        // update
        fetchedUser.setName("Robert");
        fetchedUser.setEmail("robert@LedZep.com");
        userService.saveUser(fetchedUser);

        User user2 = userService.getUserById(fetchedUser.getId());
        assertEquals(user2.getName(), "Robert");

    }

}
