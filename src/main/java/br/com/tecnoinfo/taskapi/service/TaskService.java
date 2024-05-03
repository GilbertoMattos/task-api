package br.com.tecnoinfo.taskapi.service;

import br.com.tecnoinfo.taskapi.dto.TaskDTO;
import br.com.tecnoinfo.taskapi.dto.TaskFilterDTO;
import br.com.tecnoinfo.taskapi.dto.TaskSaveDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final ModelMapper modelMapper;

    public TaskService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TaskDTO consultar(TaskFilterDTO payload) {
        return modelMapper.map(payload, TaskDTO.class);
    }

    public TaskDTO salvar(TaskSaveDTO payload) {
        return modelMapper.map(payload, TaskDTO.class);
    }
}
