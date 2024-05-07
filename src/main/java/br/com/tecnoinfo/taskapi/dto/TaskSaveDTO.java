package br.com.tecnoinfo.taskapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskSaveDTO {
    @NotBlank(message = "Por favor, informe o nome da task")
    private String nome;
}
