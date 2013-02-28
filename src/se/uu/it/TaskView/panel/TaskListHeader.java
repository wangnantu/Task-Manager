package se.uu.it.TaskView.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	
	overdue = new JLabel("Overdue");
	//overdue.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	title = new JLabel("Title");
	//title.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	category = new JLabel("Category");
	//category.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	priority = new JLabel("Priority");
	//priority.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	time = new JLabel("Time");
	//time.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
	
	edit = new JLabel("");
	
	remove = new JLabel("");
	add(overdue);add(title); add(category); add(priority); add(time); add(edit); add(remove);
}

}
