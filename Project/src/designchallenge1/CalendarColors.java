package designchallenge1;

public enum CalendarColors {
	RED, GREEN, BLUE;
	public String toString() {
		switch(this) {
		case RED: return "Red";
		case GREEN: return "Green";
		case BLUE: return "Blue";
		default: return "invalid";
		}
	}
}
