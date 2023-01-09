package com.demo.car.rental.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import com.demo.car.rental.exception.DateFormatNotValidException;


public class Utility {

	private Utility() {
	}

	
	public static LocalDateTime toLocalDateTime(String dateHours) throws DateFormatNotValidException {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		try {
			return LocalDateTime.parse(dateHours.replace("%3A", ":"), formatter).truncatedTo(ChronoUnit.HOURS);
		} catch (DateTimeParseException e) {
			throw new DateFormatNotValidException("Provided date formt is not valid use yyyy-MM-ddTHH:00");
		}
	}

	/**
	 * Check if date from less than date to and both dates are greater than now and
	 * date from less than date to
	 * 
	 */
	public static boolean isValidDates(LocalDateTime dateFrom, LocalDateTime dateTo) {
		return dateFrom.isBefore(dateTo) && dateFrom.isAfter(LocalDateTime.now())
				&& dateTo.isAfter(LocalDateTime.now());
	}
}
