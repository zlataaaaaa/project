package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.snowytusk.utils.TestValues.*;

public class PlanTest {


	@Test
	@DisplayName("Создание корректного плана")
	public void CreateCorrectPlan() {
		Assertions.assertDoesNotThrow(() -> getTestPlanFor4Hours());
	}

	@Test
	@DisplayName("Создание некорректного плана с пустой начальной датой")
	public void CreateIncorrectPlanWithEmptyStartDate() {
		Assertions.assertThrows(NullPointerException.class, () -> new Plan(null, getTestEndDate()));
	}

	@Test
	@DisplayName("Создание некорректного плана с пустой конечной датой")
	public void CreateIncorrectPlanWithEmptyEndDate() {
		Assertions.assertThrows(NullPointerException.class, () -> new Plan(getTestStartDate(), null));
	}

	@Test
	@DisplayName("Создание некорректного плана с неправильным диапазоном дат")
	public void CreatePlanWithIncorrectRangeDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Plan(getTestEndDate(), getTestStartDate()));
	}

	@Test
	@DisplayName("Создание некорректного плана с совпадающими датами начала и конца")
	public void CreateIncorrectPlanWithMatchingStartAndEndDates() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Plan(getTestStartDate(), getTestStartDate()));
	}

	@Test
	@DisplayName("Проверка equals")
	void EqualsPlans() {
		Assertions.assertEquals(getTestPlanFor4Hours(), getTestPlanFor4Hours());
	}

	@Test
	@DisplayName("Разделение одного большого плана на планы по 1 часу")
	void PlanSplitToHourLongPlans() {
		var plan = getTestPlanFor4Hours();

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

		Assertions.assertEquals(expectedPlans, actualPlans);
	}


}
