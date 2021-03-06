package ru.zlata;

public class Member {
	private String name;

	public Member(String name) {
		CheckParametersForNull(name);
		this.name = name;
	}

	private void CheckParametersForNull(String name) {
		if (name == null)
			throw new NullPointerException();
	}

	@Override
	public String toString() {
		return "'" + name + "'";
	}
}
