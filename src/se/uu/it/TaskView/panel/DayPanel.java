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
		taskListPanel = new TaskListPanel(dateTitlePanel.getDate().getText());
		
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

	}

	public DateTitlePanel getDateTitlePanel(){
		return dateTitlePanel;
	}
	public TaskListPanel getTaskListPanel() {
		return taskListPanel;
	}
}

