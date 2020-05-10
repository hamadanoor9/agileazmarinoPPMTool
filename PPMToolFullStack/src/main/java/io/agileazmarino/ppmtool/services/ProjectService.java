package io.agileazmarino.ppmtool.services;

import io.agileazmarino.ppmtool.domain.Project;
import io.agileazmarino.ppmtool.exceptions.ProjectIdException;
import io.agileazmarino.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw  new ProjectIdException("Project ID '"+ project.getProjectIdentifier().toUpperCase() +"' already exists!");
        }

    }
}
