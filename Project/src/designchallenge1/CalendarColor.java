package designchallenge1;

import java.awt.Color;

public enum CalendarColor {
	RED, GREEN, BLUE;
	public String toString() {
		switch(this) {
		case RED: return "Red";
		case GREEN: return "Green";
		case BLUE: return "Blue";
		default: return "invalid";
		}
	}
	public Color toColor() {
		switch(this) {
		case RED: return Color.RED;
		case GREEN: return Color.GREEN;
		case BLUE: return Color.BLUE;
		default: return Color.WHITE;
		}
	}
}
