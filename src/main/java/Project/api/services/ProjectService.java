package api.services;

import api.domain.Project;

public interface ProjectService {

    Iterable<Project> getAllProjects();

    Project getProjectById(Integer id);

    Project saveProject(Project project);

    void deleteProject(Integer id);

}
