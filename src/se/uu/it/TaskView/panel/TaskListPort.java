package se.uu.it.TaskView.panel;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import se.uu.it.TaskModel.TaskModel;
import se.uu.it.TaskModel.domain.Task;

public class TaskListPort extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JPanel taskPane = new JPanel();
	private ArrayList<TaskContainer> taskContainers;
	private static List<Task> taskList;
	private TaskContainer newTaskContainer;	
	private TaskModel model;
	
	public TaskListPort(){
		super();
		setLayout(new GridLayout(0,1,0,1));
		initComponents();
		setMaximumSize(new Dimension(540,40));
	}
	public void initComponents(){
		taskPane.setLayout(new BoxLayout(taskPane, BoxLayout.Y_AXIS));
		taskPane.setBackground(new Color(175,234,245));
	
		model = new TaskModel();
		taskList = model.getList();
		taskContainers = new ArrayList<TaskContainer>();
		Iterator<Task> taskIterator = taskList.iterator();
		while(taskIterator.hasNext())
			 taskContainers.add(new TaskContainer(taskIterator.next()));
		Iterator<TaskContainer> taskContainerIterator = taskContainers.iterator();
		while(taskContainerIterator.hasNext())
			taskPane.add(taskContainerIterator.next());
		add(taskPane);
			
	}
	public void add(Task task) {
		
		newTaskContainer = new TaskContainer(task);
		taskPane.add(newTaskContainer);
	}
	
	public JPanel getTaskPane() {
		return taskPane;
	}
	
	public ArrayList<TaskContainer> getTaskContainers() {
		return taskContainers;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	
	public TaskContainer getNewTaskContainer() {
		return newTaskContainer;
	}

	

}
