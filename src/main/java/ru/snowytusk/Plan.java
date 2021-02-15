package ru.snowytusk;

import java.util.*;

public class Plan {
	private final CustomDate startDate;
	private final CustomDate endDate;

	public Plan(CustomDate startDate, CustomDate endDate) {

		CheckParametersForNull(startDate, endDate);
		CheckDateRangeForCorrectness(startDate, endDate);

		this.startDate = startDate;
		this.endDate = endDate;
	}

	private void CheckDateRangeForCorrectness(CustomDate startDate, CustomDate endDate) {
//		if(todayDate.after(historyDate) && todayDate.before(futureDate)) {
//			// In between
//		}
		if (startDate.getDate().after(endDate.getDate()))
		{
			throw new IllegalArgumentException("Начальная дата не может быть позднее конечной.");
		}
	}

	private void CheckParametersForNull(CustomDate startDate, CustomDate endDate) {
		if (startDate == null)
			throw new NullPointerException();
		if (endDate == null)
			throw new NullPointerException();
	}
}
