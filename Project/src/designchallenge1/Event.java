package designchallenge1;

public class Event {
	private String name;
	private CalendarColor color;
	private boolean isRepeating;
	
	public Event(String name, CalendarColor color, boolean isRepeating) {
		this.name = name;
		this.color = color;
		this.isRepeating = isRepeating;
	}
}
