package com.privateperson.fortunetest.client.oauth2;

import com.privateperson.fortunetest.common.type.OAuth2Provider;

public record OAuth2UserInfo(
	String email,
	String name,
	OAuth2Provider oAuth2Provider
) {
}
