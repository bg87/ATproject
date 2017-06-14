package services;

import api.Application;
import ProjectApi.domain.Contribution;
import ProjectApi.domain.Project;
import ProjectApi.domain.User;
import ProjectApi.services.ContributionService;
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
public class ContributionServiceTest {

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Test
    public void testCrudContribution() {

        // create user
        User user = new User("John", "john@LedZep.com");
        User savedUser = userService.saveUser(user);

        // create project
        Project project = new Project("Story");
        Project savedProject = projectService.saveProject(project);

        Contribution contribution = new Contribution(1, "Some text");

        // save
        assertNull(contribution.getId());
        Contribution savedContribution = contributionService.saveContribution(contribution);
        assertNotNull(contribution.getId());

        // get
        Contribution fetchedContribution = contributionService.saveContribution(savedContribution);
        assertNotNull(fetchedContribution);
        assertEquals(savedContribution.getId(), fetchedContribution.getId());

        // update
        fetchedContribution.setContent("Some different text");
        contributionService.saveContribution(fetchedContribution);

        Contribution updatedContribution = contributionService.saveContribution(fetchedContribution);
        assertEquals(updatedContribution.getContent(), "Some different text");

    }

}
