package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

public class CustomDateTest {
	@Test
	@DisplayName("Создание корректной даты")
	void CreateCorrectCustomDate() {
		Assertions.assertDoesNotThrow(()->new CustomDate(2021, 02, 15, 12, 0));
	}

	@Test
	@DisplayName("Создание даты с некорректным годом")
	void CreateNotCorrectCustomDateWithNegativeYear() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(-2021,2, 15, 12, 10));
	}

	@Test
	@DisplayName("Создание даты с некорректным месяцем")
	void CreateNotCorrectCustomDateWithNegativeMonth() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, -2, 15, 12, 10));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, 0, 15, 12, 10));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, 13, 15, 12, 10));
	}

	@Test
	@DisplayName("Создание даты с некорректным днем месяца")
	void CreateNotCorrectCustomDateWithNegativeDayOfMonth() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, 2, -15, 12, 10));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, 2, 0, 12, 10));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, 2, 32, 12, 10));
	}

	@Test
	@DisplayName("Создание даты с некорректным часом дня")
	void CreateNotCorrectCustomDateWithNegativeHourOfDay() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, 2, 15, -12, 10));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(2021, 2, 15, 25, 10));
	}

	@Test
	@DisplayName("Создание даты с некорректными минутами")
	void CreateNotCorrectCustomDateWithNegativeMinute() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(2021, 2, 15, 12, -10));
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(2021, 2, 15, 12, 61));
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(2021, 2, 15, 12, 1));
	}

}
