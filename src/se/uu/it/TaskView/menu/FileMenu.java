package se.uu.it.TaskView.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import se.uu.it.TaskUtil.LanguageUtil;

public class FileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem exitItem;
	
	public FileMenu(String text) {
		super(text);
		addItems();
	}
	
	private void addItems(){
		exitItem = new JMenuItem(LanguageUtil.getString("FileMenu_Exit_Item"));
		add(exitItem);
	}
	
	public JMenuItem getExitItem() {
		return exitItem;
	}
	


}
