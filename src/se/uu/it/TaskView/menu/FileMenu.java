package se.uu.it.TaskView.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem exitItem;
	
	public FileMenu(String text) {
		super(text);
		//loadTasksFromFile();
		addItems();
	}
	
	private void addItems(){
		exitItem = new JMenuItem("Exit");
		add(exitItem);
	}
	
	public JMenuItem getExitItem() {
		return exitItem;
	}
	


}
