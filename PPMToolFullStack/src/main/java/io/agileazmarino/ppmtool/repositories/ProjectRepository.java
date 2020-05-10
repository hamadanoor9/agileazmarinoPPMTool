package io.agileazmarino.ppmtool.repositories;

import io.agileazmarino.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String projectId);
    Project deleteByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();

}
