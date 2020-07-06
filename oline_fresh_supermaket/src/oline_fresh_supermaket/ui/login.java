package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.BeanAdmin;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField Admin_Usr_nametext;
	private JPasswordField Admin_Usr_pwdtext;
	JButton LoginButton = new JButton("\u767B\u9646");
	JButton RegisterButton = new JButton("\u6CE8\u518C");
	JButton QuitButton = new JButton("\u9000\u51FA");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u751F\u9C9C\u8D85\u5E02");
		lblNewLabel_1.setFont(new Font("Songti TC", Font.BOLD, 20));
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/photo/\u8D85\u5E02logo.png")));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6   \u7801\uFF1A");
		
		Admin_Usr_nametext = new JTextField();
		Admin_Usr_nametext.setColumns(10);
		
		Admin_Usr_pwdtext = new JPasswordField();
		
		
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//登陆按钮定义
				ActionPerformed(e);
			}
		});
		
		
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//注册按钮定义
				ActionPerformed(e);
			}
		});
		
		
		QuitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出按钮定义
				ActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(668)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(LoginButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(RegisterButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(QuitButton)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(Admin_Usr_nametext, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(Admin_Usr_pwdtext, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
							.addGap(465))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(Admin_Usr_nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(Admin_Usr_pwdtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton)
						.addComponent(RegisterButton)
						.addComponent(QuitButton))
					.addGap(120))
		);
		panel.setLayout(gl_panel);
	}
	/**
	 * 对三个按钮进行重写
	 * @param e
	 */
	private void ActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.LoginButton) {
			String userid = this.Admin_Usr_nametext.getText();
			String pwd = new String(this.Admin_Usr_pwdtext.getPassword());
			try {
				BeanAdmin.currentLoginUser = oline_fresh_supermaketUtil.userManager.login(userid, pwd);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
			
		}else if(e.getSource() == this.QuitButton) {
			System.exit(0);
		} else if(e.getSource()==this.RegisterButton){
			FrmRegister dlg=new FrmRegister();
			dlg.setVisible(true);
		}
	}
}
