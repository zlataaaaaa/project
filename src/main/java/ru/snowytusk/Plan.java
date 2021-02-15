package ru.snowytusk;

import lombok.*;

import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.util.concurrent.*;

public class Plan {
	private CustomDate startDate;
	private CustomDate endDate;

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
		var plans = new ArrayList<Plan>();

		long differenceInHours = java.time.Duration.between(startDate.date, endDate.date).toHours();

		var startDatePlan = new CustomDate(startDate.date);
		var endDatePlan = new CustomDate(startDatePlan.date.plusHours(1));

		for (long counter = 0; counter < differenceInHours; counter++) {
			var plan = new Plan(startDatePlan, endDatePlan);
			plans.add(plan);
			startDatePlan = endDatePlan;
			endDatePlan = new CustomDate(endDatePlan.date.plusHours(1));
		}

		return plans;
	}

	//		if(todayDate.after(historyDate) && todayDate.before(futureDate)) {
	//			// In between
	//		}
}
