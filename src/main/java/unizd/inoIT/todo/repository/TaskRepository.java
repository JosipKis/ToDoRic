package unizd.inoIT.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unizd.inoIT.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}