package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.time.*;
import java.util.*;

public class PlanTest {


	@Test
	@DisplayName("Создание корректного плана")
	public void CreateCorrectPlan() {
		System.out.println(new GregorianCalendar(2021, 02, 15, 24, 0).getTime());

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
//
		Assertions.assertThrows(IllegalArgumentException.class,
		                        () -> new Plan(new CustomDate(2021, 02, 15, 12, 1),
		                                       new CustomDate(2021, 02, 15, 12, 0)
		                        )
		                       );
	}

}
