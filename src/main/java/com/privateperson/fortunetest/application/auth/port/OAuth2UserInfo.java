package com.privateperson.fortunetest.application.auth.port;

import com.privateperson.fortunetest.domain.user.model.OAuth2Provider;

public record OAuth2UserInfo(
	String email,
	String name,
	OAuth2Provider oAuth2Provider
) {
}
