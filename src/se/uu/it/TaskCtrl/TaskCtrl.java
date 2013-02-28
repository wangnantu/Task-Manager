package se.uu.it.TaskCtrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import se.uu.it.TaskModel.TaskModel;
import se.uu.it.TaskUtil.DlgUtil;
import se.uu.it.TaskUtil.TimeUtil;
import se.uu.it.TaskView.AddTaskView;
import se.uu.it.TaskView.EditTaskView;
import se.uu.it.TaskView.TaskView;
import se.uu.it.TaskView.panel.TaskContainer;




public class TaskCtrl{

	private TaskModel model;
	private TaskView view;
	
	public TaskCtrl(){
//		 model = new TaskModel();
		 view = new TaskView();
		 DlgUtil.setProgramFrame(view);
		 //showTask(TimeUtil.getCurrDate());
		 addComponentListeners();
		
	}

	
	public void showTask(String date){
		
	}
	
	public void addComponentListeners(){
		addFileMenuListener();
		addHelpMenuListener();
		addEidtMenuListener();
		addAddButtonListener();
		addTaskContainerListenerToAll();
		addLastYearListener();
		addLastMonthListener();
		addNextMonthListener();
		addNextYearListener();
		
	}
	
	private void addFileMenuListener(){
	    view.getTMenuBar().getFileMenu().getExitItem().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (DlgUtil.popupConfirmDialog("Do you really want to Exit?") == true) {
							System.out.println("TaskManager Exit.");
							System.exit(0);
						}
					}
				});
	}
	
	private void addHelpMenuListener(){
		view.getTMenuBar().getHelpMenu().getAboutItem().addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						DlgUtil.popupMessageDialog("Task Manager\n\tVersion 1.0 \n\tAuthor: TaskTrackers");
					}
					
				}
				);
	}
	
	private void addEidtMenuListener(){
		view.getTMenuBar().getEditMenu().getViewMenu().getDayView().addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						view.getBasePanel().getTabbedPane().setSelectedIndex(0);
					}
				 }
				);
		view.getTMenuBar().getEditMenu().getViewMenu().getMonthView().addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						view.getBasePanel().getTabbedPane().setSelectedIndex(1);
					}
				 }
				);
	}
	
	private void addTaskContainerListener(final TaskContainer taskContainer){
	
		taskContainer.getRemove().addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
					
						if (DlgUtil.popupConfirmDialog("Do you really want to remove this Task?") == true){
							model = new TaskModel();

								model.DeleteTask(taskContainer.getStoredTask());
								view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().getTaskPort().getTaskPane().remove(taskContainer);
								view.update(view.getGraphics());
						}
					}
				});
		taskContainer.getEdit().addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						final EditTaskView editTaskView = new EditTaskView();
						editTaskView.getEditTaskPanel().getDone().addActionListener(
								new ActionListener(){
									public void actionPerformed(ActionEvent e) {										
										model = new TaskModel();
										model.DeleteTask(taskContainer.getStoredTask());
										model.SaveTask(editTaskView.getTask());
										taskContainer.refresh(editTaskView.getTask());										
										DlgUtil.popupMessageDialog("Edit Task Success");
										editTaskView.dispose();
										view.update(view.getGraphics());
										}
								}
								);
						
							editTaskView.getEditTaskPanel().getTitle().setText(taskContainer.getTitle().getText());
							String dateValue = taskContainer.getDate();
							Date date;
							try {
								date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
								editTaskView.getEditTaskPanel().getDate().setDate(date);
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							
							String timeValue = taskContainer.getTime().getText();
							Format timeForm = new SimpleDateFormat("HH:mm");
							try {
								Object time = timeForm.parseObject(timeValue);
								editTaskView.getEditTaskPanel().getTime().setValue(time);
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							
							editTaskView.getEditTaskPanel().getDuration().setText(taskContainer.getDuration());
							
							editTaskView.getEditTaskPanel().getCategory().setSelectedItem(taskContainer.getCategory().getText());
							
							editTaskView.getEditTaskPanel().getPriority().setSelectedItem(taskContainer.getPriority().getText());
							
							editTaskView.getEditTaskPanel().getLocates().setText(taskContainer.getLocates());
							
							editTaskView.getEditTaskPanel().getNotes().setText(taskContainer.getNotes());
						
					}
				});
	}
	private void addTaskContainerListenerToAll(){
		ArrayList<TaskContainer> taskContainers = view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().getTaskPort().getTaskContainers();
		
		for(final TaskContainer taskContainer:taskContainers)
		{
			addTaskContainerListener(taskContainer);
		}
	}
	
	private void addAddButtonListener(){
		view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getAddTaskButton().addActionListener(
				new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						final AddTaskView addTaskView = new AddTaskView();
						addTaskView.getAddTaskPanel().getDone().addActionListener(
								 new ActionListener(){
									 
									public void actionPerformed(ActionEvent e) {
										addTaskView.actionPerformed(e);
										view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().getTaskPort().add(addTaskView.getTask());
										addTaskContainerListener(view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().getTaskPort().getNewTaskContainer());
										view.update(view.getGraphics());
									}
									
								});
						
						
					}
			
				});
		

	}
	
	private void addLastYearListener(){
		view.getBasePanel().getTabbedPane().getCalendarPanel().getChangeMonthPanel().getLastYearBtn()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMonth(-12);
			}
		});
	}
	
	private void addLastMonthListener(){
		view.getBasePanel().getTabbedPane().getCalendarPanel().getChangeMonthPanel().getLastMonthBtn()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMonth(-1);
			}
		});
	}
	
	private void addNextMonthListener(){
		view.getBasePanel().getTabbedPane().getCalendarPanel().getChangeMonthPanel().getNextMonthBtn()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMonth(1);
			}
		});
	}
	
	private void addNextYearListener(){
		view.getBasePanel().getTabbedPane().getCalendarPanel().getChangeMonthPanel().getNextYearBtn()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMonth(12);
			}
		});
	}
	
	private void changeMonth(int monthCount) {
		JLabel currMonthLabel = view.getBasePanel().getTabbedPane().getCalendarPanel().getChangeMonthPanel()
				.getCurrMonthLbl();
		String currMonth = currMonthLabel.getText();
		String changedMonth = TimeUtil.getChangedDate(currMonth, monthCount);
		currMonthLabel.setText(changedMonth);
		view.getBasePanel().getTabbedPane().getCalendarPanel().getMonthPanel().showDaysInMonth(changedMonth);
		changeButtonsColor();
	}


	private void changeButtonsColor() {
		// TODO Auto-generated method stub
		
	}
}
