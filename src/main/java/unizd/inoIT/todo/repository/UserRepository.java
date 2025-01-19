package unizd.inoIT.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unizd.inoIT.todo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}