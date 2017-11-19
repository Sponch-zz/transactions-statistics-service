package com.transactions.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public final class TimeUtil {

	public static Long nowInMillis() {
		return new DateTime(DateTimeZone.UTC).getMillis();
	}

	public static Boolean isOlderThanTimeFrame(Long timestamp, Integer timeFrameinSeconds) {
		Long now = new DateTime(DateTimeZone.UTC).getMillis();
		if ((now - timestamp) > timeFrameinSeconds * 1000) {
			return true;
		} else {
			return false;
		}
	}

	public static Long getTimestampMinusSeconds(Integer seconds) {
		return new DateTime(DateTimeZone.UTC).minusSeconds(seconds).getMillis();
	}
}
