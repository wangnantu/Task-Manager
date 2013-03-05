package se.uu.it.TaskView.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LanguageMenu extends JMenu{

	private static final long serialVersionUID = 1L;
	
	private JMenuItem Ch;
	private JMenuItem En;
	private JMenuItem In;
	private JMenuItem Se;
	
	public LanguageMenu(String text){
		super(text);
		addItem();
	}
	private void addItem(){
		Ch = new JMenuItem("Chinese");
		En = new JMenuItem("English");
		In = new JMenuItem("Indonesian");
		Se = new JMenuItem("Swedish");
		add(Ch);
		add(En);
		add(In);
		add(Se);
	}
}
