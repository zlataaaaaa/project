package ru.snowytusk;

import org.junit.jupiter.api.*;

import static ru.snowytusk.utils.TestValues.*;

public class CustomDateTest {

	@Test
	@DisplayName("Создание корректной даты")
	void CreateCorrectCustomDate() {
		Assertions.assertDoesNotThrow(()-> getTestStartDate());
		Assertions.assertDoesNotThrow(()-> getTestEndDate());
	}

	@Test
	@DisplayName("Создание даты с некорректным годом")
	void CreateNotCorrectCustomDateWithNegativeYear() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(-YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректным месяцем")
	void CreateNotCorrectCustomDateWithNegativeMonth() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, -MONTH, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, 0, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, 13, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректным днем месяца")
	void CreateNotCorrectCustomDateWithNegativeDayOfMonth() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, -DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, 0, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, 32, HOUR_OF_DAY, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректным часом дня")
	void CreateNotCorrectCustomDateWithNegativeHourOfDay() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, -HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, 25, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректными минутами")
	void CreateNotCorrectCustomDateWithNegativeMinute() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, -10));
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, 61));
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, 1));
	}

}
