package se.uu.it.TaskView;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import se.uu.it.TaskModel.domain.Task;
import se.uu.it.TaskView.panel.TaskInputPanel;





public class EditTaskView extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private TaskInputPanel editTaskPanel = new TaskInputPanel() ;

	private Task task;
	
	public EditTaskView(){
		this("Edit Task");
	}
	
	public EditTaskView(String title) {
		super(title);
		this.setLayout(new GridBagLayout());
		this.add(editTaskPanel);
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

	public TaskInputPanel getEditTaskPanel(){
		return editTaskPanel;
	}

//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == this.getEditTaskPanel().getDone()) {
//			updateTask();
//			
//		}
//		
//	}
	
	public Task getTask() {
		
		task = new Task();

		Format dateForm = new SimpleDateFormat("yyyy-MM-dd");
		Format timeForm = new SimpleDateFormat("HH:mm");
		
		task.setTitle(getEditTaskPanel().getTitle().getText());
		
		Date date = getEditTaskPanel().getDate().getCalendar().getTime();
		task.setDate(dateForm.format(date));
		
		task.setTime(timeForm.format(getEditTaskPanel().getTime().getValue()));
		
		task.setDuration(getEditTaskPanel().getDuration().getText());
		
		JComboBox<String> category = getEditTaskPanel().getCategory();
		task.setCategory(category.getItemAt(category.getSelectedIndex()).toString());
		
		JComboBox<String> priority = getEditTaskPanel().getPriority();
		task.setPriority(priority.getItemAt(priority.getSelectedIndex()).toString());
		
		task.setLocation(getEditTaskPanel().getLocates().getText());
		
		task.setNotes(getEditTaskPanel().getNotes().getText());
		
		return task;
	}
	
}