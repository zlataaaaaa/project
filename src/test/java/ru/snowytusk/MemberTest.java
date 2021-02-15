package ru.snowytusk;

import org.junit.jupiter.api.*;

public class MemberTest {
	@Test
	@DisplayName("Создание корректного участника")
	public void CreateMember() {
		Assertions.assertDoesNotThrow(() -> new Member("Алексей"));
	}

	@Test
	@DisplayName("Создание некорректного участника с пустым именем")
	public void CreateNotCorrectMemberWithNull() {
		Assertions.assertThrows(NullPointerException.class, () -> new Member(null));
	}
}
