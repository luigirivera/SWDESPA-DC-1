package designchallenge1;

public class CalendarEvent {
	private String name;
	private CalendarColor color;
	private int month;
	private int day;
	private int year;
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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isRepeating() {
		return repeating;
	}

	public void setRepeating(boolean repeating) {
		this.repeating = repeating;
	}

}
