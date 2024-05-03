package br.com.tecnoinfo.taskapi.repository;

import br.com.tecnoinfo.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
