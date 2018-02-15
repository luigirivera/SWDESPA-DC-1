package designchallenge1;

public abstract class EventReader {
	protected Event event;
	
	public Event readEvent() {
		getInput();
		parseInput();
		return event;
	}
	
	public abstract void getInput();
	public abstract void parseInput();
}