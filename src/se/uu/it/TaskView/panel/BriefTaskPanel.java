package se.uu.it.TaskView.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import se.uu.it.TaskModel.TaskModel;
import se.uu.it.TaskModel.domain.Task;

public class BriefTaskPanel extends JScrollPane {

	private static final long serialVersionUID = 1L;
	public class BriefTaskContainer extends JPanel {

		private static final long serialVersionUID = 1L;
		private JLabel time;
		private JLabel title;
		public BriefTaskContainer(Task task){
			super();
			time = new JLabel(task.getTime());
			time.setHorizontalAlignment(SwingConstants.LEFT);
			title = new JLabel(task.getTitle());
			title.setHorizontalAlignment(SwingConstants.LEFT);
			setLayout(new GridLayout(0, 2, 0, 0));
			add(time);add(title);
			setMaximumSize(new Dimension(310, 40));
			setPreferredSize(new Dimension(310, 20));
		}
	}
	private  JPanel briefTaskHeader;
	private  JPanel briefTaskList;
	
	
	public BriefTaskPanel(String date){
		super();
		setPreferredSize(new Dimension(400, 300));
		initComponents(date);
	}

	private void initComponents(String date) {
		briefTaskHeader = new JPanel();
		briefTaskHeader.setLayout(new GridLayout(0, 2, 0, 0));
		briefTaskHeader.setBorder(new LineBorder(new Color(100,100,100), 1));
		JLabel time = new JLabel("Time");
		time.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel title = new JLabel("Title");
		title.setHorizontalAlignment(SwingConstants.LEFT);
		briefTaskHeader.add(time);
		briefTaskHeader.add(title);
		
		briefTaskList = new JPanel();
		briefTaskList.setLayout(new BoxLayout(briefTaskList, BoxLayout.Y_AXIS));
		TaskModel model = new TaskModel();
		List<Task> taskList = model.getXmlPersistence().fetchOneDayTaskFromXmlFile(date);
		for(Task task:taskList){
			briefTaskList.add(new BriefTaskContainer(task));
		}
		
		setColumnHeaderView(briefTaskHeader);
		setViewportView(briefTaskList);
	}
	

}
