package se.uu.it.TaskView.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	private ViewMenu ViewMenu;
	public EditMenu(String text){
		super(text);
		addItems();
	}
	public class ViewMenu extends JMenu {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JMenuItem dayView = new JMenuItem("Day");
		JMenuItem monthView = new JMenuItem("Month");
		public ViewMenu(String text){
			super(text);
			add(dayView);
			add(monthView);
		}
		public JMenuItem getDayView() {
			return dayView;
		}
		public JMenuItem getMonthView() {
			return monthView;
		}
		
	}
	private void addItems(){
		ViewMenu = new ViewMenu("View");
		add(ViewMenu);
	}
	public ViewMenu getViewMenu(){
		return ViewMenu;
	}
}
