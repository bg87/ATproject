package services;

import ProjectApi.Application;
import ProjectApi.domain.Project;
import ProjectApi.domain.User;
import ProjectApi.services.ProjectService;
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
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Test
    public void testCrudProject() {

        // create user
        User user = new User("Jimmy", "jimmy@ledzep.com");
        User savedUser = userService.saveUser(user);

        Project project = new Project("Essay");

        // save
        assertNull(project.getId());
        Project savedProject = projectService.saveProject(project);
        assertNotNull(project.getId());

        // get
        Project fetchedProject = projectService.getProjectById(project.getId());
        assertNotNull(fetchedProject);
        assertEquals(savedUser.getId(), fetchedProject.getId());

        // update
        fetchedProject.setDescription("It's an essay!");
        projectService.saveProject(fetchedProject);

        Project project2 = projectService.getProjectById(fetchedProject.getId());
        assertEquals(project2.getDescription(), "It's an essay!");

    }

}
