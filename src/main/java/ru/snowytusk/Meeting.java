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
		CheckMembersOnEmpty(members);

		this.plan = plan;
		this.members = members;
	}

	private void CheckParametersForNull(Plan plan, List<Member> member) {
		if (plan == null)
			throw new NullPointerException();
		if (member == null)
			throw new NullPointerException();
	}

	// TODO: delete this
	private void CheckMembersOnEmpty(List<Member> members) {
		if (members.isEmpty())
			throw new IllegalArgumentException("Отсутствуют участники.");
	}
}