package br.com.tarefas.exception;

import org.springframework.http.HttpStatus;

public interface ApiExceptionContrato {
    String GetCode();
    String GetMessage();
    HttpStatus GetHttpStatus();
}
