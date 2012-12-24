package me.goonjja.gwt.scrim.client.mvp4g.navigation;

import java.util.HashMap;
import java.util.Map;


import com.google.gwt.core.client.GWT;

public class AppTokenGenerator implements TokenGenerator {

	public String getTokenValue(String token) {
		String[] result = token.split("=");
		if (result.length > 1)
			return result[1];
		return "";
	}

	public String getTokenName(String token) {
		String[] result = token.split("=");
		if (result.length > 0)
			return result[0];
		GWT.log("token has no '=' sign");
		return "";
	}

	@Override
	public Map<String, String> getTokenMap(String[] tokenNames, String token) {
		Map<String, String> result = new HashMap<String, String>();
		// fill in token names map for result
		if (tokenNames != null) {
			for (String tokenName : tokenNames)
				result.put(tokenName, "");
		}
		// parse input token
		if (token != null && token.length() > 0) {
			String[] tokens = token.split("&");
			for (int i = 0; i < tokens.length; i++) {
				String tokenName = getTokenName(tokens[i]);
				String tokenValue = getTokenValue(tokens[i]);
				if (result.containsKey(tokenName))
					result.put(tokenName, tokenValue);
			}
		}

		return result;
	}

	public String convertToToken(String name, String value) {
		return name + "=" + value;
	}

	@Override
	public String convertToToken(String[] tokenNames, String[] paramValue) {

		String result = "";
		for (int i = 0; i < tokenNames.length; i++) {
			String name = tokenNames[i];
			String value = "";
			// если количество значений аргументов недостаточно, просто добавим
			// пустые
			// значения для последних аргументов
			if (i < paramValue.length)
				value = paramValue[i];
			if (value == null || "null".equals(value))
				value = "";
			result += name;
			result += "=";
			result += value;
			if (i < tokenNames.length - 1)
				result += "&";
		}
		return result;
	}

}
