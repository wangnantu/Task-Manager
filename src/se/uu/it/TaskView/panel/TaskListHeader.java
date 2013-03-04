package se.uu.it.TaskView.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import se.uu.it.TaskUtil.LanguageUtil;

public class TaskListHeader extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JLabel time;
	private JLabel priority;
	private JLabel category;
	private JLabel overdue;
	private JLabel edit;
	private JLabel remove;
	
	public TaskListHeader(){
	setLayout(new GridLayout(0, 7, 0, 0));
	setBorder(new LineBorder(new Color(100,100,100), 1));
	setBackground(new Color(175,234,245));
	
	overdue = new JLabel(LanguageUtil.getString("TaskListHeader_Overdue_Label"));
	//overdue.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	title = new JLabel(LanguageUtil.getString("TaskListHeader_Title_Label"));
	//title.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	category = new JLabel(LanguageUtil.getString("TaskListHeader_Category_Label"));
	//category.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	priority = new JLabel(LanguageUtil.getString("TaskListHeader_Priority_Label"));
	//priority.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	time = new JLabel(LanguageUtil.getString("TaskListHeader_Time_Label"));
	//time.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	edit = new JLabel("");
	
	remove = new JLabel("");
	add(overdue);add(title); add(category); add(priority); add(time); add(edit); add(remove);
}

}
