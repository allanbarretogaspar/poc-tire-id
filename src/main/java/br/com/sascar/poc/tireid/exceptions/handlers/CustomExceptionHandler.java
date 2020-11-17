package br.com.sascar.poc.tireid.exceptions.handlers;

import br.com.sascar.poc.tireid.exceptions.BusinessException;
import br.com.sascar.poc.tireid.exceptions.RecursoNaoEncontradoException;
import br.com.sascar.poc.tireid.exceptions.handlers.dto.EntityErrorResponse;
import br.com.sascar.poc.tireid.exceptions.handlers.dto.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    public static final String ERRO_NA_REQUISICAO = "Erro na requisição";

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<EntityErrorResponse> handleBusinessException(BusinessException exception) {
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                ERRO_NA_REQUISICAO, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<EntityErrorResponse> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException exception) {
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                ERRO_NA_REQUISICAO, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), errors);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


    @ExceptionHandler(IOException.class)
    public ResponseEntity<EntityErrorResponse> handleIOException(IOException exception) {
        List<StandardError> errors = new ArrayList<>();
        errors.add(new StandardError(exception.getLocalizedMessage()));
        EntityErrorResponse response = new EntityErrorResponse(
                "Erro de I/O", HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), errors);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }


}
