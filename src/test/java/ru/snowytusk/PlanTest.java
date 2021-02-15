package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.time.*;
import java.util.*;

public class PlanTest {


	@Test
	@DisplayName("Создание корректного плана")
	public void CreateCorrectPlan() {
		var plan = new Plan(
				new CustomDate(2021, 02, 15, 12, 0),
				new CustomDate(2021, 02, 15, 16, 0)
		);
	}

	@Test
	@DisplayName("Создание некорректного плана с пустой начальной датой")
	public void CreateNotCorrectPlanWithEmptyStartDate() {
		Assertions.assertThrows(NullPointerException.class,
		                        () -> new Plan(null, null)
		                       );
	}

	@Test
	@DisplayName("Создание некорректного плана с пустой конечной датой")
	public void CreateNotCorrectPlanWithEmptyEndDate() {
		Assertions.assertThrows(NullPointerException.class,
		                        () -> new Plan(new CustomDate(2021, 02, 15, 12, 0), null)
		                       );
	}

	@Test
	@DisplayName("Создание некорректного плана с неправильным диапазоном дат")
	public void CreatePlanWithNotCorrectRangeDate() {
		Assertions.assertThrows(IllegalArgumentException.class,
		                        () -> new Plan(new CustomDate(2021, 02, 15, 12, 0),
		                                       new CustomDate(2020, 02, 15, 12, 0)
		                        )
		                       );
	}

	@Test
	@DisplayName("Создание некорректного плана с ненулевыми минутами для стартового времени")
	public void CreatePlanWithNotCorrectStartDateWithNonZeroMinutes() {
		Assertions.assertThrows(IllegalArgumentException.class,
		                        () -> new Plan(new CustomDate(2021, 02, 15, 12, 1),
		                                       new CustomDate(2021, 02, 15, 12, 0)
		                        )
		                       );
	}

	@Test
	@DisplayName("Создание некорректного плана с ненулевыми минутами для конечного времени")
	public void CreatePlanWithNotCorrectEndDateWithNonZeroMinutes() {
		Assertions.assertThrows(IllegalArgumentException.class,
		                        () -> new Plan(new CustomDate(2021, 02, 15, 12, 0),
		                                       new CustomDate(2021, 02, 15, 12, 1)
		                        )
		                       );
	}

	@Test
	@DisplayName("Создание некорректного плана с совпадающими датами начала и конца")
	public void CreateNotCorrectPlanWithMatchingStartAndEndDates() {
		Assertions.assertThrows(IllegalArgumentException.class,
		                        () -> new Plan(new CustomDate(2021, 02, 15, 12, 0),
		                                       new CustomDate(2021, 02, 15, 12, 0)
		                        )
		                       );
	}


	@Test
	void DELETE_THIS() {
		System.out.println(new GregorianCalendar(2021, 02, 15, 24, 0).getTime());
	}

	@Test
	void SplitIntoPlans() {
		var plan = new Plan(
				new CustomDate(2021, 02, 15, 12, 0),
				new CustomDate(2021, 02, 15, 16, 0)
		);

		ArrayList<Plan> hourPlans = plan.SplitByHourPlan();
		// TODO: Нужно получить список всех планов без повторений
		// TODO: Затем создать встречи по этому списку, заново пройтись по всем встречам и проверить принадлежность каждого участника календаря на конкретную встречу, если он может,
		// то добавляем его в эту встречу.
		// TODO: Затем удаляем встречи без участников (надо будет поправить тесты на пустой список встречи)
		// TODO: Сортируем встречи по количеству участников, а затем по датам.
	}
}
