package unizd.inoIT.todo.service;

import org.springframework.stereotype.Service;
import unizd.inoIT.todo.model.Task;
import unizd.inoIT.todo.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository TASK_REPOSITORY;

    public TaskService(TaskRepository taskRepository) {
        TASK_REPOSITORY = taskRepository;
    }

    public List<Task> findAll() {
        return TASK_REPOSITORY.findAll();
    }

    public List<Task> getOpenTasksByUserName(String username) {
        return TASK_REPOSITORY.findByUserNameAndStatus(username, "open");
    }

    public Task save(Task task) {
        return TASK_REPOSITORY.save(task);
    }

    public void deleteTask(Task task) {
        TASK_REPOSITORY.delete(task);
    }

    public void updateStatus(long id, String status) {
        Task task = TASK_REPOSITORY.findById(id).get();
        task.setStatus(status);
        TASK_REPOSITORY.save(task);
    }

    public List<Task> getTasksByUserName(String userName) {
        return TASK_REPOSITORY.findByUserName(userName);
    }

    public Optional<Task> findById(Long taskId) {
        return TASK_REPOSITORY.findById(taskId);
    }
}