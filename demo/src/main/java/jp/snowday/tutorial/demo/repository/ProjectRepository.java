package jp.snowday.tutorial.demo.repository;

import jp.snowday.tutorial.demo.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
