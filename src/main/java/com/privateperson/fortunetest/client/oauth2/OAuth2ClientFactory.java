package com.privateperson.fortunetest.client.oauth2;

import com.privateperson.fortunetest.common.type.OAuth2Provider;

public interface OAuth2ClientFactory {

	OAuth2Client getOAuth2Client(OAuth2Provider provider);

}