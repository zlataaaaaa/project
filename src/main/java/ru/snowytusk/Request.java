package ru.snowytusk;

public class Request {
	private final Member member;
	private final Plan plan;

	public Member getMember() {
		return member;
	}

	public Plan getPlan() {
		return plan;
	}

	public Request(Member member, Plan plan) {
		CheckParametersForNull(member, plan);

		this.plan = plan;
		this.member = member;
	}

	private void CheckParametersForNull(Member member, Plan plan) {
		if (member ==null)
			throw new NullPointerException();
		if (plan ==null)
			throw new NullPointerException();
	}
}
