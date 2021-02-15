package ru.snowytusk;

import java.util.*;

public class Meeting {
	private Plan plan;
	private final List<Member> members;

	public Plan getPlan() {
		return plan;
	}

	public List<Member> getMembers() {
		return members;
	}

	public Meeting(Plan plan, List<Member> members) {
		CheckParametersForNull(plan, members);
		CheckPlanMustBe1HourLong(plan);

		this.plan = plan;
		this.members = members;
	}

	private void CheckParametersForNull(Plan plan, List<Member> member) {
		if (plan == null)
			throw new NullPointerException();
		if (member == null)
			throw new NullPointerException();
	}

	private void CheckPlanMustBe1HourLong(Plan plan) {
		if (plan.hours() > 1)
			throw new IllegalArgumentException("Время встречи не может быть больше 1 часа.");
	}


	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Meeting)) return false;
		final Meeting meeting = (Meeting) o;
		return getPlan().equals(meeting.getPlan());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPlan());
	}
}
