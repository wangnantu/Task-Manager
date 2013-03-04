package se.uu.it.TaskView.menu;

import javax.swing.JMenuBar;

import se.uu.it.TaskUtil.LanguageUtil;

public class TMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private FileMenu fileMenu;
	private EditMenu editMenu;
	private LanguageMenu languageMenu;
	private HelpMenu helpMenu;
	
	public TMenuBar(){
		super();
		fileMenu = new FileMenu(LanguageUtil.getString("MenuBar_File_Menu"));
	    editMenu = new EditMenu(LanguageUtil.getString("MenuBar_Edit_Menu"));
		languageMenu = new LanguageMenu(LanguageUtil.getString("MenuBar_Language_Menu"));
		helpMenu = new HelpMenu(LanguageUtil.getString("MenuBar_Help_Menu"));
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
