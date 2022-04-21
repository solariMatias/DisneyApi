package com.alkemy.DisneyApi.dtos;

public class JWTAuthResponseDto {

	private String accessToken;
	private String tokenType = "Bearer";
	
	public JWTAuthResponseDto(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	

	public JWTAuthResponseDto(String accessToken, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
}
