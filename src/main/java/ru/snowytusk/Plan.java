package ru.snowytusk;

import java.time.*;
import java.util.*;

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


		var startDatePlan = new CustomDate(startDate.date);
		var endDatePlan = new CustomDate(startDatePlan.date.plusHours(1));

		for (long counter = 0; counter < hours(); counter++) {
			var plan = new Plan(startDatePlan, endDatePlan);
			plans.add(plan);
			startDatePlan = endDatePlan;
			endDatePlan = new CustomDate(endDatePlan.date.plusHours(1));
		}

		return plans;
	}

	public long hours() {
		return Duration.between(startDate.date, endDate.date).toHours();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Plan)) return false;
		final Plan plan = (Plan) o;
		return getStartDate().equals(plan.getStartDate()) &&
		       getEndDate().equals(plan.getEndDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStartDate(), getEndDate());
	}

	//		if(todayDate.after(historyDate) && todayDate.before(futureDate)) {
	//			// In between
	//		}
}
