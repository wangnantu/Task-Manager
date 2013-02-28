package se.uu.it.TaskView.panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DayPanel extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*	private JLabel currDate;
	private JTable taskList;
	private JButton addButton;*/
	//private JTable table;
	private DateTitlePanel dateTitlePanel;
	private TaskListPanel taskListPanel;

	public DayPanel() {
		super();
		setLayout(new GridBagLayout());
		initComponents();
	}
	public void initComponents(){
		
		dateTitlePanel = new DateTitlePanel();
		taskListPanel = new TaskListPanel();
		
		int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
		double weightx, weighty;
		GridBagConstraints c;
		Insets inset;
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);

		gridx = 0;// 1
		gridy = 0;// 1
		gridwidth = 1;
		gridheight = 1;
		weightx = 1.00;// 2
		weighty = 0.00;// 2
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.BOTH;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(dateTitlePanel, c);// 3
		add(dateTitlePanel);// 3

		gridx = 0;
		gridy = 1;
		gridwidth = 1;
		gridheight = 1;
		weightx = 1.00;
		weighty = 1.00;
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.BOTH;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(taskListPanel, c);
		add(taskListPanel);
		/*JLabel lblNewLabel = new JLabel("TODAY");
			lblNewLabel.setBounds(184, 11, 70, 15);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.weightx = 0.5;
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 3;
			gbc_lblNewLabel.gridy = 0;
			add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnAddTask = new JButton("Add Task");
		GridBagConstraints gbc_btnAddTask = new GridBagConstraints();
		gbc_btnAddTask.weightx = 0.5;
		gbc_btnAddTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddTask.gridx = 6;
		gbc_btnAddTask.gridy = 0;
		add(btnAddTask, gbc_btnAddTask);
		
		JLabel lblNewLabel_1 = new JLabel("Do lundry");
		lblNewLabel_1.setBounds(53, 60, 100, 15);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton button = new JButton("Edit");
		button.setBounds(222, 92, 61, 25);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.weightx = 0.5;
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 5;
		gbc_button.gridy = 2;
		add(button, gbc_button);
		
		JButton button_1 = new JButton("Delete");
		button_1.setBounds(295, 92, 81, 25);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.weightx = 0.5;
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 6;
		gbc_button_1.gridy = 2;
		add(button_1, gbc_button_1);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBackground(UIManager.getColor("DesktopIcon.background"));
		table.setBounds(27, 38, 349, 109);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridx = 7;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		
		JLabel lblDoHomework = new JLabel("Do homework");
		lblDoHomework.setBounds(53, 97, 106, 15);
		GridBagConstraints gbc_lblDoHomework = new GridBagConstraints();
		gbc_lblDoHomework.weightx = 0.5;
		gbc_lblDoHomework.fill = GridBagConstraints.BOTH;
		gbc_lblDoHomework.anchor = GridBagConstraints.WEST;
		gbc_lblDoHomework.insets = new Insets(0, 0, 0, 5);
		gbc_lblDoHomework.gridx = 1;
		gbc_lblDoHomework.gridy = 4;
		add(lblDoHomework, gbc_lblDoHomework);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(222, 55, 61, 25);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.weightx = 0.5;
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 5;
		gbc_btnEdit.gridy = 4;
		add(btnEdit, gbc_btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(295, 55, 81, 25);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.weightx = 0.5;
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 6;
		gbc_btnDelete.gridy = 4;
		add(btnDelete, gbc_btnDelete);*/
	}

	public DateTitlePanel getDateTitlePanel(){
		return dateTitlePanel;
	}
	public TaskListPanel getTaskListPanel() {
		return taskListPanel;
	}
}

