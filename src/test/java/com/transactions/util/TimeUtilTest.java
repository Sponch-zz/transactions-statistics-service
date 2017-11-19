package com.transactions.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

public class TimeUtilTest {

	@Test
	public void shouldReturnTrue_whenTimestampIsInRangeTiemFrame() {
		Long now = DateTime.now(DateTimeZone.UTC).getMillis();
		Assert.assertTrue(TimeUtil.isOlderThanTimeFrame(now - (61 * 1000), 60));
	}

	@Test
	public void shouldReturnFalse_whenTimestampIsOutRangeTiemFrame() {
		Long now = DateTime.now(DateTimeZone.UTC).getMillis();
		Assert.assertFalse(TimeUtil.isOlderThanTimeFrame(now - (59 * 1000), 60));
	}

	@Test
	public void shouldReduceSeconds_whenAddSeconds() {
		Long now = DateTime.now(DateTimeZone.UTC).getMillis();
		Assert.assertTrue(TimeUtil.getTimestampMinusSeconds(1) < now);
	}
}
