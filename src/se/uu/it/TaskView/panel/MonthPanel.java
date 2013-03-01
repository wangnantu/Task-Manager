package se.uu.it.TaskView.panel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.uu.it.TaskUtil.TimeUtil;



public class MonthPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6151283265325759762L;

	public MonthPanel() {
		super();
		setLayout(new GridBagLayout());
		initComponents();
	}
	
	/**
	 * 
	 */
	// 每月按钮组,共42个
	private JButton[] buttons;
	//private String month;


	public void initComponents(){
		setBackground(Color.lightGray);
		
		setLayout(new GridLayout(7,7,2,2));
		
		JLabel sunday=new JLabel("SUN",JLabel.CENTER);
		sunday.setForeground(Color.RED);
		add(sunday);
		
		add(new JLabel("MON",JLabel.CENTER));
		add(new JLabel("TUE",JLabel.CENTER));
		add(new JLabel("WED",JLabel.CENTER));
		add(new JLabel("THU",JLabel.CENTER));
		add(new JLabel("FRI",JLabel.CENTER));
		
		JLabel saterday=new JLabel("SAT",JLabel.CENTER);
		saterday.setForeground(Color.RED);
		add(saterday);
		
		buttons=new JButton[42];
		
		for(int i=0;i<buttons.length;i++){
			buttons[i]=new JButton(String.valueOf(i));
			add(buttons[i]);
		}
	
		showDaysInMonth(TimeUtil.getCurrMonth());
	}
	
	/**
	 * 通过隐藏按钮组中按钮和改变文字来表现一个月的日期表
	 * @param strMonth
	 */
	public void showDaysInMonth(String strMonth){
		int daysCount=TimeUtil.getDaysInAMonth(strMonth);
		int weekOfFirstDay=TimeUtil.getWeekOfFirstDay(strMonth);
		
		for(int i=0;i<buttons.length;i++){		
			if(weekOfFirstDay<=i && i<daysCount+weekOfFirstDay){
				buttons[i].setVisible(true);
				String text=String.valueOf(i-weekOfFirstDay+1);
				buttons[i].setText(text);
			}
			else{
				buttons[i].setVisible(false);
			}
		}
	}

	public JButton[] getButtons() {
		return buttons;
	}
	
	
	
}
