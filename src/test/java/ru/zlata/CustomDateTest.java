package ru.zlata;

import org.junit.jupiter.api.*;

import static ru.zlata.utils.TestValues.*;

public class CustomDateTest {

	@Test
	@DisplayName("Создание корректной даты")
	void CreateCorrectCustomDate() {
		Assertions.assertDoesNotThrow(()-> getTestStartDate());
		Assertions.assertDoesNotThrow(()-> getTestEndDate());
	}

	@Test
	@DisplayName("Создание даты с некорректным годом")
	void CreateIncorrectCustomDateWithNegativeYear() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(-YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректным месяцем")
	void CreateIncorrectCustomDateWithNegativeMonth() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, -MONTH, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, 0, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, 13, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректным днем месяца")
	void CreateIncorrectCustomDateWithNegativeDayOfMonth() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, -DAY_OF_MONTH, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, 0, HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, 32, HOUR_OF_DAY, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректным часом дня")
	void CreateIncorrectCustomDateWithNegativeHourOfDay() {
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, -HOUR_OF_DAY, MINUTE));
		Assertions.assertThrows(IllegalArgumentException.class,()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, 25, MINUTE));
	}

	@Test
	@DisplayName("Создание даты с некорректными минутами")
	void CreateIncorrectCustomDateWithNegativeMinute() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, -10));
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, 61));
		Assertions.assertThrows(IllegalArgumentException.class, ()->new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, 1));
	}

	@Test
	@DisplayName("Проверка equals")
	void EqualsCustomDates() {
		Assertions.assertEquals(getTestStartDate(), getTestStartDate());
	}
}
