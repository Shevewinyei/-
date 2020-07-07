package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class first_login extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel toolBar = new JPanel();
	private JButton UserLogin = new JButton("用户登陆");
	private JButton AdminLogin = new JButton("管理员登陆");
	private JButton Cancel = new JButton("退出");
	
	
	public first_login() {
		// TODO Auto-generated constructor stub
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.UserLogin);
		toolBar.add(this.AdminLogin);
		toolBar.add(Cancel);
		this.getContentPane().add(toolBar, BorderLayout.CENTER);
		this.setSize(320, 140);
		toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		this.validate();
		this.AdminLogin.addActionListener(this);
		this.Cancel.addActionListener(this);
		this.UserLogin.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

	private void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.AdminLogin) {
			this.setVisible(false);
			FrmAdmin_login dlg = new FrmAdmin_login();
			dlg.setVisible(true);	
		} 
		else if (e.getSource() == this.Cancel) {
			System.exit(0);
		} else if(e.getSource()==this.UserLogin){
			this.setVisible(false);
			FrmUser_login dlg=new FrmUser_login();
			dlg.setVisible(true);
		}
	}

}
