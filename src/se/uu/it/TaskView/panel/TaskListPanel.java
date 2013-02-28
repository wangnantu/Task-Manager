package se.uu.it.TaskView.panel;

import javax.swing.JScrollPane;

public class TaskListPanel extends JScrollPane  {

	private static final long serialVersionUID = 1L;

	private TaskListHeader taskHeader;
	private  TaskListPort taskPort;
	
	public TaskListPanel(){
		super();
	
		initComponents();
	}
	public void initComponents(){
		taskHeader = new TaskListHeader();
		taskPort = new TaskListPort();
		setColumnHeaderView(taskHeader);
		setViewportView(taskPort);
	}
	public TaskListPort getTaskPort() {
		return taskPort;
	}
}
