package com.privateperson.fortunetest.domain.user.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.privateperson.fortunetest.common.type.OAuth2Provider;
import com.privateperson.fortunetest.domain.user.model.User;
import com.privateperson.fortunetest.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDomainService {

	private final UserRepository userRepository;

	public User getOrCreateUser(String email, String name, OAuth2Provider oAuth2Provider) {
		return userRepository.findByEmail(email)
			.orElseGet(() -> User.builder()
				.email(email)
				.name(name)
				.password(UUID.randomUUID().toString())
				.oAuth2Provider(oAuth2Provider)
				.build()
			);
	}
}
