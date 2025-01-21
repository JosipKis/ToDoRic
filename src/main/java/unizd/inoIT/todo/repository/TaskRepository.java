package unizd.inoIT.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unizd.inoIT.todo.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserName(String userName);
}