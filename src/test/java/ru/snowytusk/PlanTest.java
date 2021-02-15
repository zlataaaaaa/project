package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.snowytusk.utils.TestValues.*;

public class PlanTest {


	@Test
	@DisplayName("Создание корректного плана")
	public void CreateCorrectPlan() {
		Assertions.assertDoesNotThrow(() -> getTestPlan());
	}

	@Test
	@DisplayName("Создание некорректного плана с пустой начальной датой")
	public void CreateNotCorrectPlanWithEmptyStartDate() {
		Assertions.assertThrows(NullPointerException.class, () -> new Plan(null, getTestEndDate()));
	}

	@Test
	@DisplayName("Создание некорректного плана с пустой конечной датой")
	public void CreateNotCorrectPlanWithEmptyEndDate() {
		Assertions.assertThrows(NullPointerException.class, () -> new Plan(getTestStartDate(), null));
	}

	@Test
	@DisplayName("Создание некорректного плана с неправильным диапазоном дат")
	public void CreatePlanWithNotCorrectRangeDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Plan(getTestEndDate(), getTestStartDate()));
	}

	@Test
	@DisplayName("Создание некорректного плана с совпадающими датами начала и конца")
	public void CreateNotCorrectPlanWithMatchingStartAndEndDates() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Plan(getTestStartDate(), getTestStartDate()));
	}

	@Test
	void SplitIntoPlans() {
		var plan = getTestPlan();

		List<Plan> expectedPlans = Arrays.asList(
				new Plan(
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 0, MINUTE),
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE)
				),
				new Plan(
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE),
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE)
				),
				new Plan(
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE),
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE)
				),
				new Plan(
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE),
						new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 4, MINUTE)
				)
		                                        );

		ArrayList<Plan> actualPlans = plan.SplitByHourPlan();

		for (int counter = 0; counter < 4; counter++) {
			Assertions.assertEquals(expectedPlans.get(counter).getStartDate().date, actualPlans.get(counter).getStartDate().date);
			Assertions.assertEquals(expectedPlans.get(counter).getEndDate().date, actualPlans.get(counter).getEndDate().date);
		}

		// TODO: Нужно получить список всех планов без повторений
		// TODO: Затем создать встречи по этому списку, заново пройтись по всем встречам и проверить принадлежность каждого участника календаря на конкретную встречу, если он может,
		// то добавляем его в эту встречу.
		// TODO: Затем удаляем встречи без участников (надо будет поправить тесты на пустой список встречи)
		// TODO: Сортируем встречи по количеству участников, а затем по датам.
	}
}
