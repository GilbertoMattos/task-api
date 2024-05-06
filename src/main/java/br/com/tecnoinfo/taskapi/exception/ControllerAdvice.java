package br.com.tecnoinfo.taskapi.exception;

import br.com.tecnoinfo.taskapi.dto.ResponseDefaultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestControllerAdvice
@ConditionalOnProperty(name = "controller.advice.enabled", havingValue = "true", matchIfMissing = true)
public class ControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(RegistryNotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseDefaultDTO<Void> handleRegistryNotFoundException() {
        logger.warn("handleRegistryNotFoundException");
        return ResponseDefaultDTO
                .<Void>builder()
                .erros(List.of("Registro não encontrado"))
                .build();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDefaultDTO<Void> businessException(BusinessException ex) {
        logger.warn("businessException");
        return ResponseDefaultDTO
                .<Void>builder()
                .erros(List.of(ex.getMessage()))
                .build();
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ResponseDefaultDTO<Void> validationException(ValidationException ex) {
        logger.warn("validationException");
        return ResponseDefaultDTO
                .<Void>builder()
                .erros(List.of(ex.getMessage()))
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ResponseDefaultDTO<Void> tratarErro400(MethodArgumentNotValidException ex) {
        return ResponseDefaultDTO
                .<Void>builder()
                .erros(handleValidationException(ex))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDefaultDTO<Void> erroNaoTratado(Exception ex) {
        return ResponseDefaultDTO
                .<Void>builder()
                .erros(List.of("Ocorreu um erro não tratado, favor entrar em contato com o suporte"))
                .build();
    }

    private List<String> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // var fildName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        });
        return errors;
    }
}
