package se.uu.it.TaskView.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import se.uu.it.TaskModel.domain.Task;
import se.uu.it.TaskView.EditTaskView;

public class TaskContainer extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel title;
	private JLabel time;
	private JLabel priority;
	private JLabel category;
	//unused Labels
	private String date;
	private String duration;
	private String notes;
	private String locates;
	
	private JButton edit;
	private JButton remove;
	private JCheckBox checkOverdue;
	public TaskContainer(Task task){
		super();
		setBorder(new LineBorder(new Color(175,234,245), 1));
		setLayout(new GridLayout(1,7));
		setBackground(new Color(237,245,243));
		
		checkOverdue = new JCheckBox("",task.isOverdue());
		checkOverdue.setBackground(new Color(237,245,243));
		edit = new JButton(new ImageIcon("Icons/editButton.png"));
		edit.setBackground(Color.WHITE);
		remove = new JButton(new ImageIcon("Icons/deleteButton.png"));
		remove.setBackground(Color.WHITE);
		
		title = new JLabel(task.getTitle());
		title.setHorizontalAlignment(JLabel.LEFT);
		
		time = new JLabel(task.getTime());
		time.setHorizontalAlignment(JLabel.LEFT);
		
		priority = new JLabel(task.getPriority());
		priority.setHorizontalAlignment(JLabel.LEFT);
		
		category = new JLabel(task.getCategory());
		category.setHorizontalAlignment(JLabel.LEFT);
		
		date = task.getDate();
		duration = task.getDuration();
		notes = task.getNotes();
		locates = task.getLocation();
		
		
		add(checkOverdue);add(title);add(category);add(priority);add(time);add(edit);add(remove);
		setPreferredSize(new Dimension(540, 40));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setMaximumSize(new Dimension(screenSize.width, 40));
		
	}
	
	public JButton getEdit() {
		return edit;
	}

	public JButton getRemove() {
		return remove;
	}
	
	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JLabel getTime() {
		return time;
	}

	public void setTime(JLabel time) {
		this.time = time;
	}

	public JLabel getPriority() {
		return priority;
	}

	public void setPriority(JLabel priority) {
		this.priority = priority;
	}

	public JLabel getCategory() {
		return category;
	}

	public void setCategory(JLabel category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLocates() {
		return locates;
	}

	public void setLocates(String location) {
		this.locates = location;
	}

	public JCheckBox getCheckOverdue() {
		return checkOverdue;
	}

	public void setCheckOverdue(JCheckBox checkOverdue) {
		this.checkOverdue = checkOverdue;
	}

	public void setEdit(JButton edit) {
		this.edit = edit;
	}

	public void setRemove(JButton remove) {
		this.remove = remove;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.getEdit()){
			final EditTaskView editTaskView = new EditTaskView();

				Task task = this.getStoredTask();
				
				editTaskView.getEditTaskPanel().getTitle().setText(task.getTitle());
				
				String dateValue = task.getDate();
				Date d;
				try {
					d = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
					editTaskView.getEditTaskPanel().getDate().setDate(d);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String timeValue = task.getTime();
				Format timeForm = new SimpleDateFormat("HH:mm");
				try {
					Object t = timeForm.parseObject(timeValue);
					editTaskView.getEditTaskPanel().getTime().setValue(t);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				editTaskView.getEditTaskPanel().getDuration().setText(task.getDuration());
				
				editTaskView.getEditTaskPanel().getCategory().setSelectedItem(task.getCategory());
				
				editTaskView.getEditTaskPanel().getPriority().setSelectedItem(task.getPriority());
				
				editTaskView.getEditTaskPanel().getLocates().setText(task.getLocation());
				
				editTaskView.getEditTaskPanel().getNotes().setText(task.getNotes());
				
		}
	}
	public void refresh(Task task){
		title.setText(task.getTitle());
		time.setText(task.getTime());
		priority.setText(task.getPriority());
		category.setText(task.getCategory());
		date = task.getDate();
		duration = task.getDuration();
		notes = task.getNotes();
		locates = task.getLocation();
	}
	
	public Task getStoredTask(){
		Task task = new Task();
		task.setTitle(getTitle().getText());
		task.setDate(getDate());
		task.setTime(getTime().getText());
		task.setCategory(getCategory().getText());
		task.setPriority(getPriority().getText());
		task.setDuration(getDuration());
		task.setLocation(getLocates());
		task.setNotes(getNotes());
		return task;
	}

}
