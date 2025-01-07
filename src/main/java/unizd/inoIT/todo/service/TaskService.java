package unizd.inoIT.todo.service;

import org.springframework.stereotype.Service;
import unizd.inoIT.todo.model.Task;
import unizd.inoIT.todo.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository TASKREPOSITORY;

    public TaskService(TaskRepository taskRepository) {
        TASKREPOSITORY = taskRepository;
    }

    public List<Task> findAll() {
        return TASKREPOSITORY.findAll();
    }

    public Task save(Task task) {
        return TASKREPOSITORY.save(task);
    }
}