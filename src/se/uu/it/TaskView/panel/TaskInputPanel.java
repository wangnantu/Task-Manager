package se.uu.it.TaskView.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import com.toedter.calendar.JDateChooser;

public class TaskInputPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField title = new JTextField(15);

	

	private JDateChooser date = new JDateChooser();
	
	SpinnerModel model = new SpinnerDateModel();
	JSpinner time = new JSpinner(model);
	JSpinner.DateEditor editor = new JSpinner.DateEditor(time, "HH:mm");


	private JTextField duration = new JTextField(15);
	
	private JComboBox<String> category = new JComboBox<String>();
	private JComboBox<String> priority = new JComboBox<String>();
	
	private JTextField locates = new JTextField(15);
	private JTextArea notes = new JTextArea(5,15);
	
	private JLabel titleL = new JLabel("Title: ");
	//private JLabel dateL = new JLabel("Date: ");
	private JLabel timeL = new JLabel("Time: ");
	private JLabel durationL = new JLabel("Duration: ");
	private JLabel categoryL = new JLabel("Category: ");
	private JLabel priorityL = new JLabel("Priority: ");
	private JLabel locationL = new JLabel("Location: ");
	private JLabel notesL = new JLabel("Notes: ");
	
	private JButton done = new JButton("Done");
	
	public TaskInputPanel(){
		super();
		setLayout(new GridBagLayout());
		initComponent();
	}

	public void initComponent(){

		category.addItem("Work");
		category.addItem("School");
		category.addItem("Entertainment");
		category.setSelectedIndex(0);
		priority.addItem("Low"); 
		priority.addItem("Medium");
		priority.addItem("High");
		priority.setSelectedIndex(0);
		
		setLayout(new GridBagLayout());
		//setBackground(Color.gray);
		GridBagConstraints con = new GridBagConstraints();
		con.anchor = GridBagConstraints.WEST;
		
		// Add title
		con.gridy = 0; con.gridx = 0;
		con.insets = new Insets(10,0,10,30);
		add(titleL,con);
		con.gridy = 0; con.gridx = 1;
		con.insets = new Insets(10,0,10,30);
		add(title,con);
		
		// Add date and time
		con.gridy = 1; con.gridx = 0;
		con.insets = new Insets(0,0,10,30);
		add(timeL,con);
		
		con.gridy =1; con.gridx = 1;
		con.insets = new Insets(0,0,10,10);
		Locale locale = new Locale("en", "US");
		date.setLocale(locale);
		date.setCalendar(Calendar.getInstance());
		date.setPreferredSize(new Dimension(120,30));
		add(date, con);
		
		time.setEditor(editor);
		con.gridy =1; con.gridx = 2;
		con.insets = new Insets(0,0,10,30);
		add(time,con);
	
		//Add duration
		con.gridy = 2; con.gridx = 0;
		con.insets = new Insets(10,0,10,30);
		add(durationL,con);
		con.gridy = 2; con.gridx = 1;
		con.insets = new Insets(10,0,10,30);
		add(duration,con);
		
		//Add category
		con.gridy = 3; con.gridx = 0;
		con.insets = new Insets(0,0,10,30);
		add(categoryL, con);
		con.gridy = 3; con.gridx = 1;
		con.insets = new Insets(0,0,10,30);
		add(category, con);
		
		//Add priority
		con.gridy = 4; con.gridx = 0;
		con.insets = new Insets(0,0,10,30);
		add(priorityL, con);
		con.gridy = 4; con.gridx = 1;
		con.insets = new Insets(0,0,10,30);
		add(priority, con);
		
		//Add location
		con.gridy = 5; con.gridx = 0;
		con.insets = new Insets(10,0,10,30);
		add(locationL,con);
		con.gridy = 5; con.gridx = 1;
		con.insets = new Insets(10,0,10,30);
		add(locates,con);
		
		// Add notes
		con.gridy = 6; con.gridx = 0;
		con.insets = new Insets(0,0,0,30);
		add(notesL, con);
		con.gridy = 6; con.gridx = 1;
		con.anchor=GridBagConstraints.NORTHWEST;
		con.insets = new Insets(0,0,0,30);
		notes.setLineWrap(true);
		add(notes, con);
		
		con.gridy = 7; con.gridx = 3;
		con.insets = new Insets(0,0,20,20);
		add(done, con);
		
	}
	
	public JButton getDone(){
		return done;
	}
	public JTextField getTitle() {
		return title;
	}
	
	public JDateChooser getDate(){
		return date;
	}
	
	public JSpinner getTime(){
		return time;
	}

	public JTextField getDuration() {
		return duration;
	}
	public JTextField getLocates() {
		return locates;
	}

	public JComboBox<String> getCategory() {
		return category;
	}

	public JComboBox<String> getPriority() {
		return priority;
	}

	

	public JTextArea getNotes() {
		return notes;
	}
}
