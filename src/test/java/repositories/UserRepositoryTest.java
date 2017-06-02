package repositories;

import ProjectApi.configuration.RepositoryConfiguration;
import ProjectApi.domain.User;
import ProjectApi.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCrudUser() {

        User user = new User("Jimmy", "jimmy@LedZep.com");

        // save
        assertNull(user.getId());
        User savedUser = userRepository.save(user);
        assertNotNull(user.getId());

        // get
        User fetchedUser = userRepository.findOne(user.getId());
        assertNotNull(fetchedUser);
        assertEquals(savedUser.getId(), fetchedUser.getId());

        // update
        fetchedUser.setName("Robert");
        fetchedUser.setEmail("robert@LedZep.com");
        userRepository.save(fetchedUser);

        User user2 = userRepository.findOne(fetchedUser.getId());
        assertEquals(user2.getName(), "Robert");

    }

}
