package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.snowytusk.utils.TestValues.*;

public class PlannerTest {
	@Test
	@DisplayName("Создание корректного планировщика с корректной встречей")
	public void CreatePlanner() {
		var planner = new Planner();

		Plan plan = getTestPlanFor1Hour();
		Member member = getTestMember();

		var meeting = new Meeting(plan, Arrays.asList(member));

		Assertions.assertDoesNotThrow(() -> planner.addMeeting(meeting));
	}


	@Test
	@DisplayName("Создание некорректного планировщика с пустой встречей")
	public void CreateIncorrectPlannerWithAddEmptyPlan() {
		var planner = new Planner();

		Assertions.assertThrows(NullPointerException.class, () -> planner.addMeeting(null));
	}


}
