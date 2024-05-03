package br.com.tecnoinfo.taskapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ResponseDefaultDTO<T> implements Serializable {
    private T content;
    private List<String> erros;
}
