package se.uu.it.TaskView;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import se.uu.it.TaskModel.TaskModel;
import se.uu.it.TaskModel.domain.Task;
import se.uu.it.TaskUtil.DlgUtil;
import se.uu.it.TaskView.panel.TaskInputPanel;




public class AddTaskView extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private Task task;
	private TaskInputPanel addTaskPanel = new TaskInputPanel() ;
	private TaskModel taskModel;
	
	public AddTaskView() {
		super("Add a new Task");
		this.setLayout(new GridBagLayout());
		this.add(addTaskPanel);
		this.pack();
		this.setSizeAndCentralizeMe(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	
		
	}
	
	
	
	private void setSizeAndCentralizeMe(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(width, height);
		this.setLocation(screenSize.width / 2 - width / 2, screenSize.height/ 2 - height / 2);
	}

	public TaskInputPanel getAddTaskPanel(){
		return addTaskPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.getAddTaskPanel().getDone()) {
			saveTask();
			DlgUtil.popupMessageDialog("Add Task Success");
			dispose();
		}
		
	}
	private void saveTask(){
		taskModel = new TaskModel();
		task = new Task();


		Format dateForm = new SimpleDateFormat("yyyy-MM-dd");
		Format timeForm = new SimpleDateFormat("HH:mm");


		
		task.setTitle(getAddTaskPanel().getTitle().getText());
		
		Date date = getAddTaskPanel().getDate().getCalendar().getTime();
		task.setDate(dateForm.format(date));
		
		task.setTime(timeForm.format(getAddTaskPanel().getTime().getValue()));
		
		task.setDuration(getAddTaskPanel().getDuration().getText());
		
		JComboBox<String> category = getAddTaskPanel().getCategory();
		task.setCategory(category.getItemAt(category.getSelectedIndex()).toString());
		
		JComboBox<String> priority = getAddTaskPanel().getPriority();
		task.setPriority(priority.getItemAt(priority.getSelectedIndex()).toString());
		
		task.setLocation(getAddTaskPanel().getLocates().getText());
		
		task.setNotes(getAddTaskPanel().getNotes().getText());
		
		taskModel.SaveTask(task);
		
	}
	public Task getTask() {
		
		task = new Task();

		Format dateForm = new SimpleDateFormat("yyyy-MM-dd");
		Format timeForm = new SimpleDateFormat("HH:mm");


		
		task.setTitle(getAddTaskPanel().getTitle().getText());
		
		Date date = getAddTaskPanel().getDate().getCalendar().getTime();
		task.setDate(dateForm.format(date));
		
		task.setTime(timeForm.format(getAddTaskPanel().getTime().getValue()));
		
		task.setDuration(getAddTaskPanel().getDuration().getText());
		
		JComboBox<String> category = getAddTaskPanel().getCategory();
		task.setCategory(category.getItemAt(category.getSelectedIndex()).toString());
		
		JComboBox<String> priority = getAddTaskPanel().getPriority();
		task.setPriority(priority.getItemAt(priority.getSelectedIndex()).toString());
		
		task.setLocation(getAddTaskPanel().getLocates().getText());
		
		task.setNotes(getAddTaskPanel().getNotes().getText());
		return task;
	}
	
}
