package designchallenge1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IOEventReader extends EventReader{
	private final static String placeholderName = "Event Name";
	private CalendarEvent tmpEvent;
	private int month;
	private int day;
	private int year;
	
	public IOEventReader(int month, int day, int year) {
		super();
		this.month = month;
		this.day = day;
		this.year = year;
	}

	protected void getInput() {
		JOptionPane dialog = new JOptionPane();
		JTextField eventName = new JTextField();
		JComboBox<CalendarColor> colors = new JComboBox<CalendarColor>();
		JCheckBox repeatCheck = new JCheckBox("Repeating Event?");
		JPanel panePanel = new JPanel();

		eventName.setForeground(Color.GRAY);
		eventName.setText(placeholderName);

		eventName.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (eventName.getText().equals(placeholderName)) {
					eventName.setText("");
					eventName.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (eventName.getText().isEmpty()) {
					eventName.setForeground(Color.GRAY);
					eventName.setText(placeholderName);
				}

			}

		});

		eventName.setPreferredSize(new Dimension(200, 30));

		for (CalendarColor cc : CalendarColor.values()) {
			colors.addItem(cc);
		}

		panePanel.add(eventName);
		panePanel.add(colors);
		panePanel.add(repeatCheck);

		int result = dialog.showConfirmDialog(null, panePanel, "Add Event", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION && eventName.getText().equals(placeholderName)) {
			JOptionPane.showMessageDialog(null, "Please enter an event name.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			tmpEvent = new CalendarEvent();
			tmpEvent.setName(String.valueOf(eventName.getText()));
			tmpEvent.setColor((CalendarColor) colors.getSelectedItem()); // this part
			tmpEvent.setRepeating(repeatCheck.isSelected());
			tmpEvent.setMonth(this.month);
			tmpEvent.setDay(this.day);
			tmpEvent.setYear(this.year);
		}
	}
	
	protected void parseInput() {
		events.add(tmpEvent);
	}
}