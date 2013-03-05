package se.uu.it.TaskView.panel;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;

public class BasePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TabbedPane tabbedPane;
	
	public class TabbedPane extends JTabbedPane {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private DayPanel dayPanel;
		private CalendarPanel calendarPanel;
		public TabbedPane(){ 
		dayPanel = new DayPanel();
	    calendarPanel = new CalendarPanel();
	    addTab("Day", null, dayPanel, null);
	    addTab("Month", null, calendarPanel, null);
		}
		public DayPanel getDayPanel(){
			return dayPanel;
		}
		
		public CalendarPanel getCalendarPanel(){
			return calendarPanel;
		}
	}
	
	public BasePanel(){
		super();
		setLayout(new GridBagLayout());
		initComponent();
	}
	public void initComponent(){
        
       
        
		  tabbedPane = new TabbedPane();
          GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
          gbc_tabbedPane.weighty = 0.5;
          gbc_tabbedPane.weightx = 0.5;
          gbc_tabbedPane.gridwidth = 0;
          gbc_tabbedPane.gridheight = 0;
          gbc_tabbedPane.gridx = 0;
          gbc_tabbedPane.gridy = 0;
          gbc_tabbedPane.fill = GridBagConstraints.BOTH;
          add(tabbedPane, gbc_tabbedPane);
		
		
	
	}
	

	public TabbedPane getTabbedPane() {
		return tabbedPane;
	}


}
