package unizd.inoIT.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unizd.inoIT.todo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    @Query("SELECT u.lowUrgency FROM User u WHERE u.userName = :userName")
    String lowUrgency(@Param("userName") String userName);

    @Query("SELECT u.midUrgency FROM User u WHERE u.userName = :userName")
    String midUrgency(@Param("userName") String userName);

    @Query("SELECT u.highUrgency FROM User u WHERE u.userName = :userName")
    String highUrgency(@Param("userName") String userName);

    @Query("SELECT u.criticalUrgency FROM User u WHERE u.userName = :userName")
    String criticalUrgency(@Param("userName") String userName);
}