package br.com.sascar.poc.tireid.dtos;


import br.com.sascar.poc.tireid.enums.ResponseStatusEnum;

public class RestResponseDTO<T> {

	//TODO: Criar enum com os status ex: OK, SEM_RESULTADOS
	private ResponseStatusEnum status;
	private transient T resultado;

	public RestResponseDTO() {
		super();
	}
	
	public RestResponseDTO(final ResponseStatusEnum response, final T dados) {
		super();
		this.status = response;
		this.resultado = dados;
	}

	public ResponseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusEnum status) {
		this.status = status;
	}

	public T getResultado() {
		return resultado;
	}

	public void setResultado(T resultado) {
		this.resultado = resultado;
	}

	
}
