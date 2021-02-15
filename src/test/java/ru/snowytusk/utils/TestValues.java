package ru.snowytusk.utils;

import ru.snowytusk.*;

public class TestValues {

	public static final int YEAR = 2021;
	public static final int MONTH = 2;
	public static final int DAY_OF_MONTH = 15;
	public static final int HOUR_OF_DAY = 12;
	public static final int MINUTE = 0;

	public static Plan getTestPlanFor4Hours() {
		return new Plan(
				getTestStartDate(),
				getTestEndDate()
		);
	}

	public static Plan getTestPlanFor1Hour() {
		return new Plan(
				getTestStartDate(),
				new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE)
		);
	}

	public static CustomDate getTestStartDate() {
		return new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE);
	}

	public static CustomDate getTestEndDate() {
		return new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 4, MINUTE);
	}

	public static Member getTestMember() {
		var member = new Member("Алексей");
		return member;
	}
}
