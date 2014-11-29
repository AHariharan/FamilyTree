package com.umapus.common.domain.entity;

public class UMapUsError {

	private String Type;
	private String[] errorDetail;
	
	public String[] getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(String[] errorDetail) {
		this.errorDetail = errorDetail;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	private String errorMessage;
	
}
