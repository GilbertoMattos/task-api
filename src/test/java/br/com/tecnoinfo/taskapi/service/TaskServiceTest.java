package br.com.tecnoinfo.taskapi.service;

import br.com.tecnoinfo.taskapi.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;
    @Mock
    private ModelMapper modelMapper;

    @Test
    @DisplayName("Deve consultar pelo id e nome e retornar apenas um resultado")
    void deveConsultarPorIdENomeRetornandoApenasUmResultado() {
//        var filter = new TaskFilterDTO(1L, "Daily");
//        var pageableRequest = Pageable.ofSize(1);
//
//        Page<Task> resultRepo = new PageImpl<>(List.of(new Task(1L, "Daily")));
//        Page<TaskDTO> result = new PageImpl<>(List.of(new TaskDTO(1L, "Daily")));
//
//        when(modelMapper.map(filter, Task.class)).thenReturn(new Task(1L, "Daily"));
//        var example = Example.of(modelMapper.map(filter, Task.class));
//        when(taskRepository.findAll(example, pageableRequest)).thenReturn(resultRepo);
//        when(taskService.consultar(filter, pageableRequest)).thenReturn(result);
//        verify(taskRepository).findAll(example, pageableRequest); // Verifica se metodo foi invocado
//        verifyNoMoreInteractions(taskRepository); // Verifica se foi chamado apenas uma vez
    }

    @Test
    void testConsultar() {
    }

    @Test
    void salvar() {
    }
}