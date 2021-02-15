package ru.snowytusk;

import java.util.*;
import java.util.Map.*;

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
		Map<Plan, HashSet<Member>> plansWithMembers = new LinkedHashMap<>();
		for (Request request : requests) {
			final ArrayList<Plan> plans = request.getPlan().SplitByHourPlan();
			for (Plan plan : plans) {
				var members = plansWithMembers.get(plan);
				if(members == null)
				{
					plansWithMembers.put(plan, new HashSet<>(Arrays.asList(request.getMember())));
				}
				else members.add(request.getMember());
			}

		}

		var meetings = new LinkedHashSet<Meeting>();
		for (Entry<Plan, HashSet<Member>> planWithMembers : plansWithMembers.entrySet()) {
			meetings.add(new Meeting(planWithMembers.getKey(), new ArrayList<>(planWithMembers.getValue())));
		}

		return meetings;
	}
}
