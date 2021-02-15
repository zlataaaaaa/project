package ru.snowytusk;

public class Member {
	private String name;

	public Member(String name) {
		CheckParametersForNull(name);
		this.name = name;
	}

	private void CheckParametersForNull(String name) {
		if (name ==null )
			throw new NullPointerException();
	}
}
