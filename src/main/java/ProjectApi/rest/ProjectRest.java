package ProjectApi.rest;

import ProjectApi.domain.Project;
import ProjectApi.services.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectRest {

    private Logger log = Logger.getLogger(ProjectRest.class);

    @Autowired
    private ProjectService projectService;

    // get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Project> getAll() {
        return projectService.getAllProjects();
    }

    // get one
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project getProject(@PathVariable int id) {
        return projectService.getProjectById(id);
    }

    // save
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Project save(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    // delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable int id) {
        boolean result = false;

        try {
            projectService.deleteProject(id);
            result = true;
        } catch(Exception ex) {
            log.info(ex);
        }

        return result;
    }


}
