package br.com.sascar.poc.tireid.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -713357701930935310L;
	
	public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
