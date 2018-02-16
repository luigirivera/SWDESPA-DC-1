package designchallenge1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarEvent {
	private String name;
	private CalendarColor color;
	private Calendar date;
	private boolean repeating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CalendarColor getColor() {
		return color;
	}

	public void setColor(CalendarColor color) {
		this.color = color;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public void setDate(int year, int month, int dayOfMonth) {
		this.date = new GregorianCalendar.Builder().setLenient(false)
				.setDate(year, month-1, dayOfMonth).build();
	}

	public boolean isRepeating() {
		return repeating;
	}

	public void setRepeating(boolean repeating) {
		this.repeating = repeating;
	}

	@Override
	public String toString() {
		return name + " " + color.toString() + " " + (date.get(Calendar.MONTH)+1) 
		+ "/" + date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.YEAR) + " " + repeating;
	}

}
