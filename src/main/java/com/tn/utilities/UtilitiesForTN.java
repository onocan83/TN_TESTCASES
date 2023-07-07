package com.tn.utilities;

import java.util.Date;

public class UtilitiesForTN {

	public static String emailDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "cnonur" + timeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT_TIME = 100;
	public static final int PAGE_lOAD_TIMEOUT = 100;
	public static final int SCRIPT_TIMEOUT = 1000;

	
}
