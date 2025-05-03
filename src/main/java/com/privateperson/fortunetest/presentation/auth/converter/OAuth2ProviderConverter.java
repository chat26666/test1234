package com.privateperson.fortunetest.presentation.auth.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.privateperson.fortunetest.domain.user.model.OAuth2Provider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OAuth2ProviderConverter implements Converter<String, OAuth2Provider> {

	@Override
	public OAuth2Provider convert(@NonNull String source) {
		try {
			return OAuth2Provider.valueOf(source.toUpperCase());
		} catch (Exception e) {
			log.info("{}", e.getMessage());
			return null;
		}
	}
}
