package com.yu.common.annotation.regexConstant;

public class RegexConstants {
	
	public static final  String TEL_CH  = "^(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{8}$";
	
	public static final String PHONE_CH = "^1[3|4|5|7|8][0-9]{9}$";
	
	public static final String EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
	
	public static final String IDENTITY_CH = "^\\d{14}\\d{3}?\\w$";
	
	public static final String POSTCODE_CH = "[1-9]\\d{5}(?!\\d)";
	
}
