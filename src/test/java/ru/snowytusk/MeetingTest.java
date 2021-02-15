package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.snowytusk.utils.TestValues.*;

public class MeetingTest {

	// TODO: Повторяющиеся или пересекающиеся планы одного участника?

	Plan plan = getTestPlan();

	Member member1 = new Member("Алексей");
	Member member2 = new Member("Роман");
	Member member3 = new Member("Ирина");

	@Test
	@DisplayName("Создание корректной встречи")
	void CreateCorrectMeeting() {
		Assertions.assertDoesNotThrow(() -> new Meeting(plan,
		                          Arrays.asList(member1, member2, member3)
		));
	}

	@Test
	@DisplayName("Создание некорректной встречи с пустым планом")
	void CreateNotCorrectMeetingWithEmptyPlan() {
		Assertions.assertThrows(NullPointerException.class,() -> new Meeting(null, null));
	}

	@Test
	@DisplayName("Создание некорректной встречи с пустым списком участников")
	void CreateNotCorrectMeetingWithEmptyMembers() {
		Assertions.assertThrows(NullPointerException.class,() -> new Meeting(plan, null));
	}

	@Test
	@DisplayName("Создание некорректной встречи со списком без участников")
	void CreateNotCorrectMeetingWithMembersSize0() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> new Meeting(plan, Arrays.asList()));
	}

}
