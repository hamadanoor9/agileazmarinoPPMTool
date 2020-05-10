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

    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project==null){
            throw  new ProjectIdException("Project ID '"+ projectId.toUpperCase() +"' doesn't exists!");
        }
        return projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void DeleteProjectByProjectId(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
//        projectRepository.deleteById(project.getId());
        if(project==null){
            throw  new ProjectIdException("Project ID '"+ projectId.toUpperCase() +"' doesn't exists!");
        }
        projectRepository.delete(project);
    }
}
