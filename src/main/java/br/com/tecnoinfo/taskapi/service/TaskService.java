package br.com.tecnoinfo.taskapi.service;

import br.com.tecnoinfo.taskapi.dto.TaskDTO;
import br.com.tecnoinfo.taskapi.dto.TaskFilterDTO;
import br.com.tecnoinfo.taskapi.dto.TaskSaveDTO;
import br.com.tecnoinfo.taskapi.exception.RegistryNotFoundException;
import br.com.tecnoinfo.taskapi.model.Task;
import br.com.tecnoinfo.taskapi.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    public TaskDTO consultar(Long id) {
        return modelMapper.map(taskRepository.findById(id).orElseThrow(RegistryNotFoundException::new), TaskDTO.class);
    }

    public Page<TaskDTO> consultar(TaskFilterDTO filter, Pageable pageable) {
        var matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnorePaths("inclusaoData", "alteracaoData")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(modelMapper.map(filter, Task.class), matcher);
        var produtos = taskRepository.findAll(example, pageable);
        return produtos.map(p -> modelMapper.map(p, TaskDTO.class));
    }

    public TaskDTO salvar(TaskSaveDTO payload) {
        var produto = taskRepository.save(modelMapper.map(payload, Task.class));
        return modelMapper.map(produto, TaskDTO.class);
    }
}
