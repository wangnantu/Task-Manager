package se.uu.it.TaskCtrl;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import se.uu.it.TaskModel.TaskModel;
import se.uu.it.TaskModel.domain.Task;
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
		 view = new TaskView();
		 DlgUtil.setProgramFrame(view);
		 changeButtonsColor();
		 addComponentListeners();
		
	}
	
	public void addComponentListeners(){
		addFileMenuListener();
		addHelpMenuListener();
		addEidtMenuListener();
		addAddButtonListener();
		addTodayButtonListener();
		addTaskContainerListenerToAll();
		addLastYearListener();
		addLastMonthListener();
		addNextMonthListener();
		addNextYearListener();
		addDayButtonListenerToall();
		
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
										if(editTaskView.getTask().getDate().equals(taskContainer.getDate()))
										{
											taskContainer.refresh(editTaskView.getTask());										
										}else{
											view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().getTaskPort().getTaskPane().remove(taskContainer);
										}
										DlgUtil.popupMessageDialog("Edit Task Success");
										editTaskView.dispose();
										view.update(view.getGraphics());
										changeButtonsColor();
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
		
		for( TaskContainer taskContainer:taskContainers)
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
										if(addTaskView.getTask().getDate().equals(view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getDate().getText()))
										{
										view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().getTaskPort().add(addTaskView.getTask());
										addTaskContainerListener(view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().getTaskPort().geTaskContainer());
										}
										view.update(view.getGraphics());
										changeButtonsColor();
									}
									
								});
						String dateValue = view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getDate().getText();
						Date date;
						try {
							date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
							addTaskView.getAddTaskPanel().getDate().setDate(date);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
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
		JButton[] buttons = view.getBasePanel().getTabbedPane().getCalendarPanel().getMonthPanel().getButtons();
		for (int i = 0; i < buttons.length; i++) {
			final JButton button = buttons[i];
			String month = view.getBasePanel().getTabbedPane().getCalendarPanel().getChangeMonthPanel().getCurrMonthLbl().getText();
			String date;
			if(button.getText().length() == 1){
				date = month + "-"+ "0"+button.getText();
			}else{
				date = month + "-"+ button.getText();
			}
			model = new TaskModel();
			List<Task> taskList = model.getXmlPersistence().fetchOneDayTaskFromXmlFile(date);
			if(!taskList.isEmpty()){
				button.setForeground(Color.red);
			}else{
				button.setForeground(Color.black);
			}
		}
	}
	
	private void addDayButtonListenerToall(){
		JButton[] buttons = view.getBasePanel().getTabbedPane().getCalendarPanel().getMonthPanel().getButtons();
		for (int i = 0; i < buttons.length; i++) {
			final JButton button = buttons[i];
			button.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							DlgUtil.popupMessageDialog("try");
							view.getBasePanel().getTabbedPane().setSelectedIndex(0);
							String month = view.getBasePanel().getTabbedPane().getCalendarPanel().getChangeMonthPanel().getCurrMonthLbl().getText();
							String date;
							if(button.getText().length() == 1){
								date = month + "-"+ "0"+button.getText();
							}else{
								date = month + "-"+ button.getText();
							}
							
							view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().initComponents(date);
							addTaskContainerListenerToAll();
							view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getDate().setText(date);
							if(!date.equals(TimeUtil.getCurrDate())){
								view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getToday().setText("Back to Today");
								view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getToday().setEnabled(true);
							}else{
								view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getToday().setText("Today");
								view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getToday().setEnabled(false);
							}
						}
						
					});
		}
	}
	private void addTodayButtonListener(){
		view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getToday().addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						view.getBasePanel().getTabbedPane().getDayPanel().getTaskListPanel().initComponents(TimeUtil.getCurrDate());
						addTaskContainerListenerToAll();
						view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getDate().setText(TimeUtil.getCurrDate());
						view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getToday().setText("Today");
						view.getBasePanel().getTabbedPane().getDayPanel().getDateTitlePanel().getToday().setEnabled(false);
					}
					
				});
	}
}
