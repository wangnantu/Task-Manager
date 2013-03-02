package se.uu.it.TaskView;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import se.uu.it.TaskView.panel.BriefTaskPanel;
import java.awt.FlowLayout;

public class BriefTaskView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private BriefTaskPanel briefTaskPanel;
	private JPanel bottomButtonPanel;
	private JButton detail;
	private JButton close;
	
	public BriefTaskView(String date){
		super(date);
		setLayout(new GridLayout());
		initComponents(date);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSizeAndCentralizeMe(320, 240);
		setVisible(true);
	}

	private void initComponents(String date) {
		briefTaskPanel = new BriefTaskPanel(date);
		bottomButtonPanel = new JPanel();
		detail = new JButton("Detail");
		close = new JButton("Close");
		bottomButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		bottomButtonPanel.add(detail);
		bottomButtonPanel.add(close);
		bottomButtonPanel.setMaximumSize(new Dimension(300,40));
		
		
		int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
		double weightx, weighty;
		GridBagConstraints c;
		Insets inset;
		GridBagLayout gridbag = new GridBagLayout();
		getContentPane().setLayout(gridbag);
		
		gridx = 0;// 1
		gridy = 0;// 1
		gridwidth = 1;
		gridheight = 1;
		weightx = 1.00;// 2
		weighty = 1.00;// 2
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.BOTH;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(briefTaskPanel, c);// 3
		getContentPane().add(briefTaskPanel);
		
		
		gridx = 0;
		gridy = 1;
		gridwidth = 1;
		gridheight = 1;
		weightx = 1.00;
		weighty = 0.00;
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.BOTH;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(bottomButtonPanel, c);
		getContentPane().add(bottomButtonPanel);
		
		
		
	}
	private void setSizeAndCentralizeMe(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(width, height);
		this.setLocation(screenSize.width / 2 - width / 2, screenSize.height/ 2 - height / 2);
	}

	public JButton getDetail() {
		return detail;
	}

	public JButton getClose() {
		return close;
	}
}
