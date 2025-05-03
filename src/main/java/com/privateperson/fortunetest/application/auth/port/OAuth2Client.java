package com.privateperson.fortunetest.application.auth.port;

import org.springframework.stereotype.Component;

import com.privateperson.fortunetest.domain.user.model.OAuth2Provider;

@Component
public interface OAuth2Client {

	String getRedirectUrl();

	OAuth2UserInfo getUserInfo(String code);

	OAuth2Provider getProvider();

}
