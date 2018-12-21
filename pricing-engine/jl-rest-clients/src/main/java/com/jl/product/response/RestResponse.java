package com.jl.product.response;

import com.jl.product.response.ResponseStatus.ClientResponseStatus;

public class RestResponse<T> {
	
	

	private T response;
	private Boolean isSuccessfull;
	private ClientResponseStatus responseCode;

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public Boolean getIsSuccessfull() {
		return isSuccessfull;
	}

	public void setIsSuccessfull(Boolean isSuccessfull) {
		this.isSuccessfull = isSuccessfull;
	}

	public ClientResponseStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ClientResponseStatus responseCode) {
		this.responseCode = responseCode;
	}
	
	

}
