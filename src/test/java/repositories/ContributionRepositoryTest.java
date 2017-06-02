package repositories;

import ProjectApi.configuration.RepositoryConfiguration;
import ProjectApi.domain.Contribution;
import ProjectApi.domain.Project;
import ProjectApi.domain.User;
import ProjectApi.repositories.ContributionRepository;
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
public class ContributionRepositoryTest {

    @Autowired
    private ContributionRepository contributionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void testCrudContribution() {

        // create user
        User user = new User("John", "john@LedZep.com");
        User savedUser = userRepository.save(user);

        // create project
        Project project = new Project("Story");
        Project savedProject = projectRepository.save(project);

        Contribution contribution = new Contribution(1, "Some text");

        // save
        assertNull(contribution.getId());
        Contribution savedContribution = contributionRepository.save(contribution);
        assertNotNull(contribution.getId());

        // get
        Contribution fetchedContribution = contributionRepository.findOne(savedContribution.getId());
        assertNotNull(fetchedContribution);
        assertEquals(savedContribution.getId(), fetchedContribution.getId());

        // update
        fetchedContribution.setContent("Some different text");
        contributionRepository.save(fetchedContribution);

        Contribution updatedContribution = contributionRepository.findOne(fetchedContribution.getId());
        assertEquals(updatedContribution.getContent(), "Some different text");

    }

}
