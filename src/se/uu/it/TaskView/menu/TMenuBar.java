package se.uu.it.TaskView.menu;

import javax.swing.JMenuBar;

public class TMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private FileMenu fileMenu;
	private EditMenu editMenu;
	private LanguageMenu languageMenu;
	private HelpMenu helpMenu;
	
	public TMenuBar(){
		super();
		fileMenu = new FileMenu("File");
	    editMenu = new EditMenu("Edit");
		languageMenu = new LanguageMenu("Language");
		helpMenu = new HelpMenu("Help");
		add(fileMenu);
		add(editMenu);
		add(languageMenu);
		add(helpMenu);
	}
	public FileMenu getFileMenu(){
		return fileMenu;
	}
	public EditMenu getEditMenu(){
		return editMenu;
	}
	public LanguageMenu getLanguageMenu(){
		return languageMenu;
	}
	public HelpMenu getHelpMenu(){
		return helpMenu;
	}
}
