package ru.snowytusk;

import java.util.*;
import java.util.Map.*;

public class Planner {
	List<Request> requests = new ArrayList<>();

	static void PrintMeetings(Set<Meeting> actualMeetings) {
		var meetings = new ArrayList<>(actualMeetings);
		meetings.sort(Comparator.comparing((Meeting meeting) -> meeting.getMembers().size()).reversed().thenComparing(meeting -> meeting.getPlan().getStartDate().getDate()));

		for (Meeting meeting : meetings) {
			System.out.println(meeting);
		}
	}

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

		var meetings = new HashSet<Meeting>();
		for (Entry<Plan, HashSet<Member>> planWithMembers : plansWithMembers.entrySet()) {
			meetings.add(new Meeting(planWithMembers.getKey(), new ArrayList<>(planWithMembers.getValue())));
		}

		return meetings;
	}
}
