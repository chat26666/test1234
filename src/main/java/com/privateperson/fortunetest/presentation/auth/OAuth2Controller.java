package com.privateperson.fortunetest.presentation.auth;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.privateperson.fortunetest.application.auth.dto.response.TokenResponse;
import com.privateperson.fortunetest.application.auth.service.OAuth2Service;
import com.privateperson.fortunetest.common.type.OAuth2Provider;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class OAuth2Controller {

	private final OAuth2Service oAuth2Service;

	@GetMapping("/oauth2/login/{provider}")
	public void loginOAuth2(@PathVariable OAuth2Provider provider,
		HttpServletResponse response) throws IOException {
		String redirectUrl = oAuth2Service.getRedirectUrl(provider);
		response.sendRedirect(redirectUrl);
	}

	@GetMapping("/oauth2/callback/{provider}")
	public ResponseEntity<TokenResponse> callbackOAuth2(@PathVariable OAuth2Provider provider,
		@RequestParam String code) {
		return ResponseEntity.ok(oAuth2Service.generateToken(provider, code));
	}
}
