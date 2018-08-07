package jp.snowday.tutorial.demo.repository;

import jp.snowday.tutorial.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
