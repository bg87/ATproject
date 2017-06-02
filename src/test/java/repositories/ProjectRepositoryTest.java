package repositories;

import ProjectApi.configuration.RepositoryConfiguration;
import ProjectApi.domain.Project;
import ProjectApi.domain.User;
import ProjectApi.repositories.ProjectRepository;
import ProjectApi.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCrudProject() {

        // create user
        User user = new User("Jimmy", "jimmy@ledzep.com");
        User savedUser = userRepository.save(user);

        Project project = new Project("Essay");

        // save
        assertNull(project.getId());
        Project savedProject = projectRepository.save(project);
        assertNotNull(project.getId());

        // get
        Project fetchedProject = projectRepository.findOne(project.getId());
        assertNotNull(fetchedProject);
        assertEquals(savedUser.getId(), fetchedProject.getId());

        // update
        fetchedProject.setDescription("It's an essay!");
        projectRepository.save(fetchedProject);

        Project project2 = projectRepository.findOne(fetchedProject.getId());
        assertEquals(project2.getDescription(), "It's an essay!");

    }

}
