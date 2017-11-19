package com.transactions.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Class utility with methods related to time
 * @author csponchiado
 *
 */
public final class TimeUtil {

	/**
	 * Get current time in milliseconds
	 * @return
	 */
	public static Long nowInMillis() {
		return new DateTime(DateTimeZone.UTC).getMillis();
	}

	/**
	 * Check if the timestamp is older than the time frame
	 * @param timestamp timestamp 
	 * @param timeFrameinSeconds time frame in seconds
	 * @return
	 */
	public static Boolean isOlderThanTimeFrame(Long timestamp, Integer timeFrameinSeconds) {
		Long now = new DateTime(DateTimeZone.UTC).getMillis();
		if ((now - timestamp) > timeFrameinSeconds * 1000) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the current millisecounds, minus seconds utilized
	 * @param seconds secounds utilized
	 * @return
	 */
	public static Long getTimestampMinusSeconds(Integer seconds) {
		return new DateTime(DateTimeZone.UTC).minusSeconds(seconds).getMillis();
	}
}
