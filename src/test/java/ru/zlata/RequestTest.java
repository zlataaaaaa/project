package ru.zlata;

import org.junit.jupiter.api.*;

import static ru.zlata.utils.TestValues.*;

public class RequestTest {
	Member member = getTestMember();

	@Test
	@DisplayName("Создание корректного запроса")
	void CreateCorrectRequest() {
		Assertions.assertDoesNotThrow(() -> new Request(member, getTestPlanFor4Hours()));
	}

	@Test
	@DisplayName("Создание некорректного запроса с пустым участником")
	void CreateIncorrectRequestWithEmptyMember() {
		Assertions.assertThrows(NullPointerException.class, () -> new Request(null, getTestPlanFor4Hours()));
	}


	@Test
	@DisplayName("Создание некорректного запроса с пустым планом")
	void CreateIncorrectRequestWithEmptyPlan() {
		Assertions.assertThrows(NullPointerException.class, () -> new Request(member, null));
	}
}
