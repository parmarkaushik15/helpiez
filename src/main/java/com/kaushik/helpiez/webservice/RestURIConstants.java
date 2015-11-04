package com.kaushik.helpiez.webservice;

public class RestURIConstants {
	public static final String CREATE_NGO = "/rest/ngoregister";
	public static final String CREATE_USER = "/rest/userregister";
	public static final String CREATE_EVENT = "/rest/ngoeventregister";
	public static final String LOGIN = "/rest/login";
	public static final String ALL_NGO = "/rest/allngolist";
	public static final String ALL_CATEGORY = "/rest/ngocategory";
	public static final String ALL_NEAR_NGO = "/rest/nearngolist";
	public static final String ALL_NEAR_EVENT = "/rest/nearngoevent";
	public static final String CHECK_EMAIL = "/rest/ngoemailvalidation";
	public static final String EVENT_LIST = "/rest/ngoeventdetail/{ngoId}";
	public static final String EMAIL_VARIFICATION = "/rest/ngosignupvarification";
	public static final String NGO_INFO = "/rest/ngoinformation/{loginId}";
	public static final String USER_INFO = "/rest/userinformation/{loginId}";
}
