package com.jiajun.configure;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurer {

	public static PropertyPlaceholderConfigurer encryptablePropertyPlaceholderConfigurer() {
		return new PropertyPlaceholderConfigurer() {

			@Override
			protected String convertProperty(String propertyName, String propertyValue) {
				return super.convertProperty(propertyName, propertyValue);
			}
		};
	}
}
