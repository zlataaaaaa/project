package ru.snowytusk;

import java.util.*;

public class Meeting {
	private Plan plan;
	private Set<Member> members;

	public Meeting(Plan plan, List<Member> members) {
		CheckParametersForNull(plan, members);
		CheckPlanMustBe1HourLong(plan);

		this.plan = plan;
		this.members = new HashSet<>(members);
	}

	public Plan getPlan() {
		return plan;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public Meeting(Plan plan, Member... members) {
		this(plan, Arrays.asList(members));
	}

	private void CheckParametersForNull(Plan plan, List<Member> members) {
		if (plan == null)
			throw new NullPointerException();
		if (members == null)
			throw new NullPointerException();
		if (members.isEmpty())
			throw new IllegalArgumentException();
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
		return getPlan().equals(meeting.getPlan()) &&
		       getMembers().equals(meeting.getMembers());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPlan(), getMembers());
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("Встреча с количеством участников: " + getMembers().size() + System.lineSeparator());
		stringBuilder.append("Участники: " + getMembers() + System.lineSeparator());
		stringBuilder.append("Время встречи: " + getPlan() + System.lineSeparator());

		return stringBuilder.toString();
	}
}
