package se.uu.it.TaskView.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import se.uu.it.TaskUtil.LanguageUtil;

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
		JMenuItem dayView = new JMenuItem(LanguageUtil.getString("Edit_View_Day_Item"));
		JMenuItem monthView = new JMenuItem(LanguageUtil.getString("Edit_View_Month_Item"));
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
		ViewMenu = new ViewMenu(LanguageUtil.getString("EditMenu_View_SubMenu"));
		add(ViewMenu);
	}
	public ViewMenu getViewMenu(){
		return ViewMenu;
	}
}
