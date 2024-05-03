package br.com.tecnoinfo.taskapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskFilterDTO {

    private Long id;
    private String nome;
}
