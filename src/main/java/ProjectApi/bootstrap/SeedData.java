package ProjectApi.bootstrap;

import ProjectApi.domain.Contribution;
import ProjectApi.domain.Project;
import ProjectApi.domain.User;
import ProjectApi.services.ContributionService;
import ProjectApi.services.ProjectService;
import ProjectApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ContributionService contributionService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // create 4 users
        generateUsers();

        // create 2 projects
        generateProjects();

        // create 6 contributions
        generateContributions();


    }

    public void generateUsers() {
        
        User user1 = new User("Jimmy", "jimmy@ledzep.com");
        userService.saveUser(user1);

        User user2 = new User("Robert", "robert@ledzep.com");
        userService.saveUser(user2);

        User user3 = new User("John", "john@ledzep.com");
        userService.saveUser(user3);

        User user4 = new User("J.J.", "jj@ledzep.com");
        userService.saveUser(user4);

    }

    public void generateProjects() {

        // fetch users
        User jimmy = userService.getUserById(1);
        User robert = userService.getUserById(2);
        User john = userService.getUserById(3);
        User jj = userService.getUserById(4);

        Project project1 = new Project("Kashmir");
        projectService.saveProject(project1);

        Project project2 = new Project("Black Dog");
        projectService.saveProject(project2);

        List<Project> list1 = new ArrayList<>();
        List<Project> list2 = new ArrayList<>();

        list1.add(project1);
        list2.add(project2);

        jimmy.setProjects(list1);
        robert.setProjects(list2);

    }

    public void generateContributions() {

        // fetch users
        User jimmy = userService.getUserById(1);
        User robert = userService.getUserById(2);
        User john = userService.getUserById(3);
        User jj = userService.getUserById(4);

        // fetch projects
        Project kashmir = projectService.getProjectById(1);
        Project blackDog = projectService.getProjectById(2);

        List<Contribution> kasmirContributions =  kashmir.getContributions();
        List<Contribution> blackDogContributions =  blackDog.getContributions();

        Contribution contribution1 = new Contribution(1, "djfkljfasjfk asdkf sdkfjdkf djsfkldj fkjsdak lsjfakj" +
                "fkldsjfkldjf ksdljf dkjfdklsjf k jk fjd kjdkf jdlksa;jfdk fkjsklfj asfsjf dlfsjalf dka kslj kdsfk faslj kdsa" +
                " kdjfklsd fkafjdks fksfjkdljf jf kdsajfkd fjksajf ;lkds fkjads kfdkjfa jf kdas fkjf kfaskjfakf dklfjkdlasj ff");
        contributionService.saveContribution(contribution1);

        kasmirContributions.add(contribution1);

        Contribution contribution2 = new Contribution(2, "djfkljfasjfk asdkf sdkfjdkf djsfkldj fkjsdak lsjfakj" +
                "fkldsjfkldjf ksdljf dkjfdklsjf k jk fjd kjdkf jdlksa;jfdk fkjsklfj asfsjf dlfsjalf dka kslj kdsfk faslj kdsa" +
                " kdjfklsd fkafjdks fksfjkdljf jf kdsajfkd fjksajf ;lkds fkjads kfdkjfa jf kdas fkjf kfaskjfakf dklfjkdlasj ff");
        contributionService.saveContribution(contribution2);

        kasmirContributions.add(contribution2);

        Contribution contribution3 = new Contribution(3, "djfkljfasjfk asdkf sdkfjdkf djsfkldj fkjsdak lsjfakj" +
                "fkldsjfkldjf ksdljf dkjfdklsjf k jk fjd kjdkf jdlksa;jfdk fkjsklfj asfsjf dlfsjalf dka kslj kdsfk faslj kdsa" +
                " kdjfklsd fkafjdks fksfjkdljf jf kdsajfkd fjksajf ;lkds fkjads kfdkjfa jf kdas fkjf kfaskjfakf dklfjkdlasj ff");
        contributionService.saveContribution(contribution3);

        kasmirContributions.add(contribution3);

        Contribution contribution4 = new Contribution(1, "djfkljfasjfk asdkf sdkfjdkf djsfkldj fkjsdak lsjfakj" +
                "fkldsjfkldjf ksdljf dkjfdklsjf k jk fjd kjdkf jdlksa;jfdk fkjsklfj asfsjf dlfsjalf dka kslj kdsfk faslj kdsa" +
                " kdjfklsd fkafjdks fksfjkdljf jf kdsajfkd fjksajf ;lkds fkjads kfdkjfa jf kdas fkjf kfaskjfakf dklfjkdlasj ff");
        contributionService.saveContribution(contribution4);

        blackDogContributions.add(contribution4);

        Contribution contribution5 = new Contribution(2, "djfkljfasjfk asdkf sdkfjdkf djsfkldj fkjsdak lsjfakj" +
                "fkldsjfkldjf ksdljf dkjfdklsjf k jk fjd kjdkf jdlksa;jfdk fkjsklfj asfsjf dlfsjalf dka kslj kdsfk faslj kdsa" +
                " kdjfklsd fkafjdks fksfjkdljf jf kdsajfkd fjksajf ;lkds fkjads kfdkjfa jf kdas fkjf kfaskjfakf dklfjkdlasj ff");
        contributionService.saveContribution(contribution5);

        blackDogContributions.add(contribution5);

        Contribution contribution6 = new Contribution(3, "djfkljfasjfk asdkf sdkfjdkf djsfkldj fkjsdak lsjfakj" +
                "fkldsjfkldjf ksdljf dkjfdklsjf k jk fjd kjdkf jdlksa;jfdk fkjsklfj asfsjf dlfsjalf dka kslj kdsfk faslj kdsa" +
                " kdjfklsd fkafjdks fksfjkdljf jf kdsajfkd fjksajf ;lkds fkjads kfdkjfa jf kdas fkjf kfaskjfakf dklfjkdlasj ff");
        contributionService.saveContribution(contribution6);

        blackDogContributions.add(contribution6);

        // save updated projects
        projectService.saveProject(kashmir);
        projectService.saveProject(blackDog);

    }

}
