package se.uu.it.TaskView.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import se.uu.it.TaskUtil.TimeUtil;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.SwingConstants;


public class DateTitlePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public DateTitlePanel(){
		super();
		initComponents();
	}
	private JLabel today;
	private JLabel date;
	private JButton addTaskButton;
	
	
	public void initComponents(){
		setLayout(new GridLayout(0, 3, 0, 0));
		
		today = new JLabel("TODAY");
		add(today);
		date = new JLabel(TimeUtil.getCurrDate());
		add(date);
		addTaskButton = new JButton("Add a new Task");
		addTaskButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(addTaskButton);
		setPreferredSize(new Dimension(540, 40));
		
	}
	public JButton getAddTaskButton(){
		return addTaskButton;
	}
	
	public JLabel getDate() {
		return date;
	}
}
