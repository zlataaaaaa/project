package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.snowytusk.utils.TestValues.*;

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
	void RequestsToMeetings() {
		var planner = new Planner();


		planner.addRequest(getTestRequest());
		planner.addRequest(getTestRequest());

		var actualMeetings = planner.RequestsToMeetings();

		var expectedMeetings = new LinkedHashSet<Meeting>(Arrays.asList(
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 0, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE)
						),
						Arrays.asList(getTestMember())
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE)
						),
						Arrays.asList(getTestMember())
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE)
						),
						Arrays.asList(getTestMember())
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 4, MINUTE)
						),
						Arrays.asList(getTestMember())
				)
		                                                               ));

		Assertions.assertEquals(expectedMeetings, actualMeetings);
	}
}
