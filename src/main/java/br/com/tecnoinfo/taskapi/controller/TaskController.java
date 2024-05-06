package br.com.tecnoinfo.taskapi.controller;

import br.com.tecnoinfo.taskapi.dto.ResponseDefaultDTO;
import br.com.tecnoinfo.taskapi.dto.TaskDTO;
import br.com.tecnoinfo.taskapi.dto.TaskFilterDTO;
import br.com.tecnoinfo.taskapi.dto.TaskSaveDTO;
import br.com.tecnoinfo.taskapi.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
@Tag(name = "Task", description = "Serviço de Task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TaskDTO> consultar(@PageableDefault(value = 50) Pageable pageable, TaskFilterDTO filter) {
        return taskService.consultar(filter, pageable);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDefaultDTO<TaskDTO> consultar(@PathVariable Long id) {
        return ResponseDefaultDTO.<TaskDTO>builder().content(taskService.consultar(id)).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDefaultDTO<TaskDTO> salvar(@Valid @RequestBody TaskSaveDTO payload) {
        return ResponseDefaultDTO.<TaskDTO>builder().content(taskService.salvar(payload)).build();
    }
}
