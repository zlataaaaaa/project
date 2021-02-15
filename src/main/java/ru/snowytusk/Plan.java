package ru.snowytusk;

import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.util.concurrent.*;

public class Plan {
	private final CustomDate startDate;
	private final CustomDate endDate;

	public CustomDate getStartDate() {
		return startDate;
	}

	public CustomDate getEndDate() {
		return endDate;
	}

	public Plan(CustomDate startDate, CustomDate endDate) {

		CheckParametersForNull(startDate, endDate);
		CheckDateRangeForCorrectness(startDate, endDate);

		this.startDate = startDate;
		this.endDate = endDate;
	}

	private void CheckDateRangeForCorrectness(CustomDate startDate, CustomDate endDate) {
		if (startDate.getDate().isAfter(endDate.getDate()))
		{
			throw new IllegalArgumentException("Начальная дата не может быть позднее конечной.");
		}

		if (startDate.getDate().isEqual(endDate.getDate()))
		{
			throw new IllegalArgumentException("Начальная дата не может равна поздней. Разница должна составлять хотя бы 1 час.");
		}
	}

	private void CheckParametersForNull(CustomDate startDate, CustomDate endDate) {
		if (startDate == null)
			throw new NullPointerException();
		if (endDate == null)
			throw new NullPointerException();
	}

	public ArrayList<Plan> SplitByHourPlan() {
		var planList = new ArrayList<Plan>();

		long diffInHours = java.time.Duration.between(startDate.date, endDate.date).toHours();
		System.out.println(diffInHours);

		return planList;
	}

	//		if(todayDate.after(historyDate) && todayDate.before(futureDate)) {
	//			// In between
	//		}
}
