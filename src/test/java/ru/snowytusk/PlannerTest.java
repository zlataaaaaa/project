package ru.snowytusk;

import com.google.common.collect.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class PlannerTest {
	@Test
	@DisplayName("Создание корректного планировщика с корректной встречей")
	public void CreatePlanner() {
		var planner = new Planner();

		var plan = new Plan(
				new CustomDate(2021, 02, 15, 12, 0),
				new CustomDate(2021, 02, 15, 16, 0)
		);

		var member = new Member("Алексей");

		var meeting = new Meeting(plan, Arrays.asList(member));

		Assertions.assertDoesNotThrow(() -> planner.addMeeting(meeting));
	}

	@Test
	@DisplayName("Создание некорректного планировщика с пустой встречей")
	public void CreateNotCorrectPlannerWithAddEmptyPlan() {
		var planner = new Planner();

		Assertions.assertThrows(NullPointerException.class, () -> planner.addMeeting(null));
	}


}
