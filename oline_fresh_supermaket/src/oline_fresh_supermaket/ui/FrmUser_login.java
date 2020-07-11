package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmUser_login extends JDialog implements ActionListener {
	private JPanel toolBar1 = new JPanel();
	private JPanel workPane1 = new JPanel();
	private JButton btnLogin1 = new JButton("µÇÂ½");
	private JButton btnCancel1 = new JButton("·µ»Ø");
	private JButton btnRegister1 = new JButton("×¢²á");
	
	private JLabel labelUser1 = new JLabel("ÓÃ»§Ãû£º");
	private JLabel labelPwd1 = new JLabel("ÃÜ  Âë£º");
	private JTextField edtUserId1 = new JTextField(20);
	private JPasswordField edtPwd1 = new JPasswordField(20);

	public FrmUser_login(Frame f, String s, boolean b) {
		super(f, s, b);
		acc();
	}
	public FrmUser_login() {
		super();
		acc();
	}
	private void acc(){
		toolBar1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar1.add(this.btnRegister1);
		toolBar1.add(btnLogin1);
		toolBar1.add(btnCancel1);
		this.getContentPane().add(toolBar1, BorderLayout.SOUTH);
		workPane1.add(labelUser1);
		workPane1.add(edtUserId1);
		workPane1.add(labelPwd1);
		workPane1.add(edtPwd1);
		this.getContentPane().add(workPane1, BorderLayout.CENTER);
		this.setSize(320, 140);
		// ÆÁÄ»¾ÓÖÐÏÔÊ¾
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		btnLogin1.addActionListener(this);
		btnCancel1.addActionListener(this);
		this.btnRegister1.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin1) {
			String userid=this.edtUserId1.getText();
			String pwd=new String(this.edtPwd1.getPassword());
			try {
				Beanuser.currentLoginUser= oline_fresh_supermaketUtil.userManager.login(userid, pwd);
				FrmMain_user dlg =  new FrmMain_user(userid);
				dlg.setVisible(true);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
			
		} else if (e.getSource() == this.btnCancel1) {
			this.setVisible(false);
			first_login dlgFirst_login = new first_login();
			dlgFirst_login.setVisible(true);
		} else if(e.getSource()==this.btnRegister1){
			FrmRegister_user dlg=new FrmRegister_user();
			dlg.setVisible(true);
		}
	}

}
