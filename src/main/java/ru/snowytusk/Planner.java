package ru.snowytusk;

import java.util.*;

public class Planner {
	List<Meeting> meetings = new ArrayList<>();

	public void addMeeting(Meeting meeting) {
		CheckParametersForNull(meeting);

		meetings.add(meeting);
	}

	private void CheckParametersForNull(Meeting meeting) {
		if (meeting == null)
			throw new NullPointerException();
	}
}
