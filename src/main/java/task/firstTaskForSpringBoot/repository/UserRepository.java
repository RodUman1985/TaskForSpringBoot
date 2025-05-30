package task.firstTaskForSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.firstTaskForSpringBoot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
