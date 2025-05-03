package com.privateperson.fortunetest.client.oauth2;

import org.springframework.stereotype.Component;

import com.privateperson.fortunetest.common.type.OAuth2Provider;

@Component
public interface OAuth2Client {

	String getRedirectUrl();

	OAuth2UserInfo getUserInfo(String code);

	OAuth2Provider getProvider();

}
