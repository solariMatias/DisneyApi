package com.alkemy.DisneyApi.dtos;

public class JWTAuthResonseDto {

	private String accessToken;
	private String tokenType = "Bearer";
	
	public JWTAuthResonseDto(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	

	public JWTAuthResonseDto(String accessToken, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}

	public String getTokenDeAcceso() {
		return accessToken;
	}

	public void setTokenDeAcceso(String tokenDeAcceso) {
		this.accessToken = tokenDeAcceso;
	}

	public String getTipoDeToken() {
		return tokenType;
	}

	public void setTipoDeToken(String tipoDeToken) {
		this.tokenType = tipoDeToken;
	}
}
