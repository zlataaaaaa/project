package ru.snowytusk;

import java.lang.reflect.*;
import java.util.*;

public class CustomDate {

	Date date;

	public Date getDate() {
		return date;
	}

	public CustomDate(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
		CheckParametersForCorrectness(year, month, dayOfMonth, hourOfDay, minute);
		// TODO: Проверку на время.
		date = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute).getTime();
	}

	private void CheckParametersForCorrectness(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
		if (year < 0)
			throw new IllegalArgumentException("Год не может быть отрицательным!");
		if (month <= 0 || month > 12)
			throw new IllegalArgumentException("Месяц должен быть в диапазоне от 1 до 12 включительно!");
		if (dayOfMonth <= 0 || dayOfMonth > 31)
			throw new IllegalArgumentException("День месяца должен быть в диапазоне от 1 до 31 включительно!");
		if (hourOfDay < 0 || hourOfDay > 24)
			throw new IllegalArgumentException("Час дня должен быть в диапазоне от 0 до 24 включительно!");
		if (minute != 0)
			throw new IllegalArgumentException("По условию задачи количество минут должно быть равно 0!");


	}
}
