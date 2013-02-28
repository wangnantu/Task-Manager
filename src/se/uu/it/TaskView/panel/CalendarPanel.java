package se.uu.it.TaskView.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;


public class CalendarPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ChangeMonthPanel changeMonthPanel;
	private MonthPanel monthPanel;	
	public CalendarPanel(){
		super();
		//setLayout(new GridBagLayout());
		initComponents();
	}
	
	public void initComponents(){
		changeMonthPanel=new ChangeMonthPanel();
		monthPanel=new MonthPanel();
		
		
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
		gridbag.setConstraints(changeMonthPanel, c);// 3
		add(changeMonthPanel);// 3

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
		gridbag.setConstraints(monthPanel, c);
		add(monthPanel);
	}

	public ChangeMonthPanel getChangeMonthPanel(){
		return changeMonthPanel;
	}
	
	public MonthPanel getMonthPanel(){
		return monthPanel;
	}


	

}
