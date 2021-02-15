package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.snowytusk.utils.TestValues.*;

public class MeetingTest {

	// TODO: Повторяющиеся или пересекающиеся планы одного участника?

	Plan plan = new Plan(getTestStartDate(),
	                     new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE)
	);

	Member member1 = new Member("Алексей");
	Member member2 = new Member("Роман");
	Member member3 = new Member("Ирина");

	@Test
	@DisplayName("Создание корректной встречи")
	void CreateCorrectMeeting() {
		Assertions.assertDoesNotThrow(() -> new Meeting(plan, member1, member2, member3));
	}

	@Test
	@DisplayName("Создание некорректной встречи с пустым планом")
	void CreateIncorrectMeetingWithEmptyPlan() {
		Assertions.assertThrows(NullPointerException.class, () -> new Meeting(null));
	}

	@Test
	@DisplayName("Создание некорректной встречи с пустым списком участников")
	void CreateIncorrectMeetingWithEmptyMembers() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(plan));
	}

	@Test
	@DisplayName("Создание некорректной встречи с планом, превыщающим один час")
	void CreateIncorrectMeeting() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(getTestPlanFor4Hours(), member1, member2, member3));
	}

}
