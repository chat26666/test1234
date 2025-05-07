package com.privateperson.fortunetest.infrastructure.security.jwt.core;

import org.springframework.stereotype.Component;

import com.privateperson.fortunetest.application.auth.dto.response.TokenResponse;

@Component
public class JwtServiceImpl {
	public TokenResponse generateToken(Long id, String email) {

		// TODO 토큰 생성기 내부구현 필요(박경오)
		return null;
	}
}
