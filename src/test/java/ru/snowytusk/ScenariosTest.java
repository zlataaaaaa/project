package ru.snowytusk;

import org.junit.jupiter.api.*;

import java.util.*;

import static ru.snowytusk.utils.TestValues.*;

public class ScenariosTest {
	@Test
	void Scenario1() {
		var planner = new Planner();

		Member member1 = new Member("Алексей");
		Member member2 = new Member("Роман");
		Member member3 = new Member("Ирина");

		planner.addRequest(new Request(member1,
		                               new Plan(
				                               new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE),
				                               new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 4, MINUTE)
		                               )
		));
		planner.addRequest(new Request(member2,
		                               new Plan(
				                               new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY - 1, MINUTE),
				                               new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE)
		                               )
		));
		planner.addRequest(new Request(member3,
		                               new Plan(
				                               new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE),
				                               new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE)
		                               )
		));

		var actualMeetings = planner.RequestsToMeetings();

		var expectedMeetings = new LinkedHashSet<Meeting>(Arrays.asList(
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY - 1, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 0, MINUTE)
						),
						member2
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 0, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE)
						),
						member1, member2
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 1, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE)
						),
						member1, member2, member3
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 2, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE)
						),
						member1, member3
				),
				new Meeting(
						new Plan(
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 3, MINUTE),
								new CustomDate(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY + 4, MINUTE)
						),
						member1
				)
		                                                               ));

		Assertions.assertEquals(expectedMeetings, actualMeetings);

		Planner.PrintMeetings(actualMeetings);
	}

}
