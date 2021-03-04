package ru.zlata;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.zlata.utils.TestValues.*;

public class PlannerTest {
	@Test
	@DisplayName("Создание корректного планировщика с корректным запросом")
	public void CreatePlanner() {
		var planner = new Planner();

		var request = getTestRequest();

		Assertions.assertDoesNotThrow(() -> planner.addRequest(request));
	}


	@Test
	@DisplayName("Создание некорректного планировщика с пустой встречей")
	public void CreateIncorrectPlannerWithAddEmptyPlan() {
		var planner = new Planner();

		Assertions.assertThrows(NullPointerException.class, () -> planner.addRequest(null));
	}

	@Test
	@DisplayName("Конвертация запросов во встречи")
	void RequestsToMeetings() {
		var planner = new Planner();

		var member1 = getTestMember();
		var member2 = getTestMember();
		var member3 = getTestMember();

		planner.addRequest(new Request(member1, getTestPlanFor4Hours()));
		planner.addRequest(new Request(member2,getTestPlanFor4Hours()));
		planner.addRequest(new Request(member3,getTestPlanFor4Hours()));

		var actualMeetings = planner.RequestsToMeetings();

		var expectedMeetings = new HashSet<>(Arrays.asList(
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 0, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE)
						),
						member1, member2, member3
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE)
						),
						member1, member2, member3
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE)
						),
						member1, member2, member3
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 4, MINUTE)
						),
						member1, member2, member3
				)
		                                                  ));

		Assertions.assertEquals(expectedMeetings, actualMeetings);

		Planner.PrintMeetings(actualMeetings);
	}
}
