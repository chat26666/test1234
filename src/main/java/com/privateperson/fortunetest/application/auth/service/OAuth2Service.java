package com.privateperson.fortunetest.application.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.privateperson.fortunetest.application.auth.dto.response.TokenResponse;
import com.privateperson.fortunetest.application.auth.port.OAuth2Client;
import com.privateperson.fortunetest.application.auth.port.OAuth2ClientFactory;
import com.privateperson.fortunetest.application.auth.port.OAuth2UserInfo;
import com.privateperson.fortunetest.infrastructure.security.jwt.core.JwtServiceImpl;
import com.privateperson.fortunetest.domain.user.model.OAuth2Provider;
import com.privateperson.fortunetest.domain.user.model.User;
import com.privateperson.fortunetest.domain.user.repository.UserRepository;
import com.privateperson.fortunetest.domain.user.service.UserDomainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuth2Service {

	private final UserDomainService userDomainService;
	private final OAuth2ClientFactory oAuth2ClientFactory;
	private final UserRepository userRepository;
	private final JwtServiceImpl jwtService;

	public String getRedirectUrl(OAuth2Provider provider) {
		OAuth2Client client = oAuth2ClientFactory.getOAuth2Client(provider);
		return client.getRedirectUrl();
	}

	@Transactional
	public TokenResponse generateToken(OAuth2Provider provider, String code) {
		OAuth2Client client = oAuth2ClientFactory.getOAuth2Client(provider);
		OAuth2UserInfo oAuth2UserInfo = client.getUserInfo(code);
		User user = userDomainService.getOrCreateUser(oAuth2UserInfo.email(), oAuth2UserInfo.name(),
			oAuth2UserInfo.oAuth2Provider());
		if (user.getId() == null)
			userRepository.save(user);
		return jwtService.generateToken(user.getId(), user.getEmail());
	}
}
