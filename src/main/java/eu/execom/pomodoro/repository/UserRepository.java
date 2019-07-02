package eu.execom.pomodoro.repository;

import eu.execom.pomodoro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
