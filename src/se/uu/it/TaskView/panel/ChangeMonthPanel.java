package se.uu.it.TaskView.panel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.uu.it.TaskUtil.TimeUtil;



public class ChangeMonthPanel extends JPanel {


	private static final long serialVersionUID = 1L;

	public ChangeMonthPanel() {
		super();
		setLayout(new GridBagLayout());
		initComponents();
	}
	
    JButton lastYearBtn;
	
	JButton lastMonthBtn;
	
	JLabel  currMonthLbl;
	
	JButton nextMonthBtn;

	JButton nextYearBtn;
	
	public void initComponents(){
		lastYearBtn=new JButton("<<");
		lastMonthBtn=new JButton("<");
		currMonthLbl=new JLabel(TimeUtil.getCurrMonth());
		nextMonthBtn=new JButton(">");
		nextYearBtn=new JButton(">>");
		
		add(lastYearBtn);
		add(lastMonthBtn);
		add(currMonthLbl);
		add(nextMonthBtn);
		add(nextYearBtn);
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
	}
	
	
	public JButton getLastYearBtn() {
		return lastYearBtn;
	}

	public JButton getLastMonthBtn() {
		return lastMonthBtn;
	}

	public JLabel getCurrMonthLbl() {
		return currMonthLbl;
	}

	public JButton getNextMonthBtn() {
		return nextMonthBtn;
	}

	public JButton getNextYearBtn() {
		return nextYearBtn;
	}
}
	