package ru.snowytusk;

import org.junit.jupiter.api.*;
import ru.snowytusk.utils.*;

public class MemberTest {
	@Test
	@DisplayName("Создание корректного участника")
	public void CreateMember() {
		Assertions.assertDoesNotThrow(() -> TestValues.getTestMember());
	}

	@Test
	@DisplayName("Создание некорректного участника с пустым именем")
	public void CreateIncorrectMemberWithNull() {
		Assertions.assertThrows(NullPointerException.class, () -> new Member(null));
	}
}
