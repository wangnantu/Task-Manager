package se.uu.it.TaskView;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import se.uu.it.TaskUtil.DlgUtil;
import se.uu.it.TaskView.menu.TMenuBar;
import se.uu.it.TaskView.panel.BasePanel;

public class TaskView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private BasePanel basePanel;
	
	private TMenuBar menuBar;
	
	
	public TaskView(){
		this("TaskManager");
	}
	public TaskView(String title){
		super(title);
		basePanel = new BasePanel();
		menuBar = new TMenuBar();
		this.setJMenuBar(menuBar);
		this.getContentPane().add(basePanel);
        this.setSizeAndCentralizeMe(560, 420);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (DlgUtil.popupConfirmDialog("Do you really want to Exit?") == true) {
					System.out.println("TaskManager Exit.");
					System.exit(0);
				}
			}
		});
        this.setVisible(true); 							// Show the window.
	}
	
	private void setSizeAndCentralizeMe(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(width, height);
		this.setLocation(screenSize.width / 2 - width / 2, screenSize.height/ 2 - height / 2);
	}
	


	public BasePanel getBasePanel(){
		return basePanel;
	}
	public TMenuBar getTMenuBar() {
		return menuBar;
	}

}
