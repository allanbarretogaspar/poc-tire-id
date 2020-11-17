package br.com.sascar.poc.tireid.resources;

import br.com.sascar.poc.tireid.dtos.RestResponseDTO;
import br.com.sascar.poc.tireid.enums.ResponseStatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class SystemResource {
private <T extends Object> ResponseEntity<RestResponseDTO<T>> retornarResponse(final T response) {
		
		RestResponseDTO<T> restResponse = new RestResponseDTO<>();
		if (response == null || (response instanceof List<?> && ((List<?>)response).isEmpty())) {
			restResponse.setStatus(ResponseStatusEnum.SEM_RESULTADOS);
		} else {
			restResponse.setStatus(ResponseStatusEnum.OK);
		}
		
		restResponse.setResultado(response);
		return ResponseEntity.status(HttpStatus.OK).body(restResponse);
	}

	/*
	 * HTTP 200
	 */
	public <T extends Object> ResponseEntity<RestResponseDTO<T>> retornarSucesso(final T response) {
		return retornarResponse(response);
	}
}
