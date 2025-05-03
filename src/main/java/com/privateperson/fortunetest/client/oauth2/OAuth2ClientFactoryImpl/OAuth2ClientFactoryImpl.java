package com.privateperson.fortunetest.client.oauth2.OAuth2ClientFactoryImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.privateperson.fortunetest.client.oauth2.OAuth2Client;
import com.privateperson.fortunetest.client.oauth2.OAuth2ClientFactory;
import com.privateperson.fortunetest.common.type.OAuth2Provider;

@Component
public class OAuth2ClientFactoryImpl implements OAuth2ClientFactory {

	private final Map<OAuth2Provider, OAuth2Client> oAuth2ClientMap;

	public OAuth2ClientFactoryImpl(List<OAuth2Client> oAuth2Clients) {
		oAuth2ClientMap = oAuth2Clients.stream().collect(Collectors.toMap(OAuth2Client::getProvider, client -> client));
	}

	@Override
	public OAuth2Client getOAuth2Client(OAuth2Provider provider) {
		return oAuth2ClientMap.get(provider);
	}
}
