package ru.snowytusk;

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

	@Test
	void SplitIntoPlans() {
		// TODO: Нужно получить список всех планов без повторений
		// TODO: Затем создать встречи по этому списку, заново пройтись по всем встречам и проверить принадлежность каждого участника календаря на конкретную встречу, если он может,
		// то добавляем его в эту встречу.
		// TODO: Затем удаляем встречи без участников (надо будет поправить тесты на пустой список встречи)
		// TODO: Сортируем встречи по количеству участников, а затем по датам.
	}
}
