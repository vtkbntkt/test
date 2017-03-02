package ua.gudkov.acceptic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public final class Extractor {

	public static String extractByRegex(String txt, String regex) {
		Matcher matcher = Pattern.compile(regex).matcher(txt);
		if (matcher.find()) {
			return matcher.group(1);
		}

		return null;
	}

	public static int stringToInt(String value) {
		if (StringUtils.isNumeric(value)) {
			return Integer.valueOf(value);
		}

		return 0;
	}

}
