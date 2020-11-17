package br.com.sascar.poc.tireid.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1263764518987640476L;

	public RecursoNaoEncontradoException(String message) {
        super(message);
    }

    public RecursoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

}
