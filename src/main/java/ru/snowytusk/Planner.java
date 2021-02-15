package ru.snowytusk;

import java.util.*;

public class Planner {
	List<Request> requests = new ArrayList<>();

	public void addRequest(Request request) {
		CheckParametersForNull(request);

		requests.add(request);
	}

	private void CheckParametersForNull(Request request) {
		if (request == null)
			throw new NullPointerException();
	}


	public Set<Meeting> RequestsToMeetings() {
		Set<Meeting> meetings = new LinkedHashSet<>();
		for (Request request : requests) {
			final ArrayList<Plan> plans = request.getPlan().SplitByHourPlan();
			for (Plan plan : plans) {
				meetings.add(new Meeting(plan, Arrays.asList(request.getMember())));
			}

		}
		return meetings;
	}
}
