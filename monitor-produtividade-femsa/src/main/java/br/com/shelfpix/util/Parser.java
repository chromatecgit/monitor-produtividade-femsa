package br.com.shelfpix.util;

import java.time.Duration;
import java.time.LocalTime;

public class Parser {
	public static Duration parseLocalTime(final LocalTime localTime) {
		Duration hourDuration = Duration.ofHours(localTime.getHour());
		Duration minuteDuration = Duration.ofMinutes(localTime.getMinute());
		Duration secondDuration = Duration.ofSeconds(localTime.getSecond());
		Duration totalAmount = hourDuration.plus(minuteDuration).plus(secondDuration);

		return totalAmount;
	}
}
