package se.uu.it.TaskView.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HelpMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem aboutItem;
	
	public HelpMenu(String text){
		super(text);
		addItem();
	}
	private void addItem(){
		aboutItem = new JMenuItem("About");
		add(aboutItem);
	}
	public JMenuItem getAboutItem(){
		return aboutItem;
	}

}
