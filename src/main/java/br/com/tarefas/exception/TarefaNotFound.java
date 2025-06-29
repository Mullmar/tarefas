package br.com.tarefas.exception;

import org.springframework.http.HttpStatus;

public class TarefaNotFound extends RuntimeException implements ApiExceptionContrato{
    private final String code = "TAREFA_NOT_FOUND";
    private String mensagem;

    public TarefaNotFound(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String GetCode() {
        return this.code;
    }

    @Override
    public String GetMessage() {
        return this.mensagem;
    }

    @Override
    public HttpStatus GetHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
