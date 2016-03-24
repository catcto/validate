package com.catcto.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRule {

	public static Boolean isFilled(String s) {
		return (s != null && s.length() > 0);
	}

	public static Boolean isEmail(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("^(?:\\w[\\w\\-]*\\.?)*\\w+@(?:\\w[\\w\\-]*\\.{1})+\\w+$");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean isAlpha(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("^[0-9a-zA-Z\\_]+$");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean isAlphac(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("^[\\u4e00-\\u9fa5\\w\\d]+$");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean isChineseName(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("^\\s*[\\u4e00-\\u9fa5]{1,}[\\u4e00-\\u9fa5.·]{0,15}[\\u4e00-\\u9fa5]{1,}\\s*$");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean isCard(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|x)$)");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean isInt(String s) {
		if (!isFilled(s)) {
			return true;
		}
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static Boolean isNumber(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("^[0-9]*$");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static boolean isDouble(String s) {
		if (!isFilled(s)) {
			return true;
		}
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static Boolean regex(String s, String r) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile(r);
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean isPhone(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("^\\d{11}$");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean sbbh(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("(^\\d{15}$)|(^\\d{14}$)|(^\\d{18}$)|(^\\d{17}(\\d|x)$)");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean sbbh1(String s) {
		if (!isFilled(s)) {
			return true;
		}
		Pattern regex = Pattern.compile("(^\\d{14}$)");
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	public static Boolean maxLength(String s, String l) {
		if (!isFilled(s)) {
			return true;
		}
		int i = Integer.parseInt(l);
		return s.length() <= i;
	}

	public static Boolean minLength(String s, String l) {
		if (!isFilled(s)) {
			return true;
		}
		int i = Integer.parseInt(l);
		return s.length() >= i;
	}
}
