package se.uu.it.TaskView.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import se.uu.it.TaskUtil.LanguageUtil;

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
		Ch = new JMenuItem(LanguageUtil.getString("Language_Chinese_Item"));
		En = new JMenuItem(LanguageUtil.getString("Language_English_Item"));
		In = new JMenuItem(LanguageUtil.getString("Language_Indonesian_Item"));
		Se = new JMenuItem(LanguageUtil.getString("Language_Swedish_Item"));
		add(Ch);
		add(En);
		add(In);
		add(Se);
	}
}
