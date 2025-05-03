package com.privateperson.fortunetest.client.oauth2.OAuth2ClientImpl;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.privateperson.fortunetest.client.oauth2.OAuth2Client;
import com.privateperson.fortunetest.client.oauth2.OAuth2UserInfo;
import com.privateperson.fortunetest.common.type.OAuth2Provider;

@Component
public class OAuth2Naver implements OAuth2Client {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String getRedirectUrl() {
		return "";
	}

	@Override
	public OAuth2UserInfo getUserInfo(String code) {
		return null;
	}

	@Override
	public OAuth2Provider getProvider() {
		return OAuth2Provider.NAVER;
	}
}
