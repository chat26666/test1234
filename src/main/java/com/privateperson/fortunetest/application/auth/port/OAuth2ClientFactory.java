package com.privateperson.fortunetest.application.auth.port;

import com.privateperson.fortunetest.domain.user.model.OAuth2Provider;

public interface OAuth2ClientFactory {

	OAuth2Client getOAuth2Client(OAuth2Provider provider);

}