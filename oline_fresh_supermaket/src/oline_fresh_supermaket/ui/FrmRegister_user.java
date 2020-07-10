package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;
import java.awt.event.ActionEvent;

public class FrmRegister_user extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField userpwd;
	private JTextField user_email;
	private JTextField usercity;
	private JTextField telephone;
	private JPasswordField userpwd2;
	private JRadioButton man = new JRadioButton("\u7537");;
	private JRadioButton woman = new JRadioButton("\u5973");;
	private ButtonGroup group;
	private String gender;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegister_user frame = new FrmRegister_user();
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
	public FrmRegister_user() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u6027\u522B\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u8BBE\u7F6E\u5BC6\u7801\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		
		JLabel lblNewLabel_5 = new JLabel("\u6240\u5728\u57CE\u5E02\uFF1A");
		
		username = new JTextField();
		username.setColumns(10);
		
		userpwd = new JPasswordField();
		
		user_email = new JTextField();
		user_email.setColumns(10);
		
		usercity = new JTextField();
		usercity.setColumns(10);
		
		//定义按钮组
		group=new ButtonGroup();
		group.add(man);
		group.add(woman);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//注册
				registeractionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出
				cancelactionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("\u7535      \u8BDD\uFF1A");
		
		telephone = new JTextField();
		telephone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		
		userpwd2 = new JPasswordField();
		
		

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(88)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(telephone)
						.addComponent(usercity)
						.addComponent(user_email)
						.addComponent(userpwd2)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(username, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(userpwd)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(man)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(woman)))
							.addComponent(btnNewButton_1)))
					.addGap(54))
		);
		man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "男";
			}
		});
		woman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "女";
			}
		});
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(man)
							.addComponent(woman)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(userpwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userpwd2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(user_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(usercity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(telephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void cancelactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	private void registeractionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			String name = username.getText();
			//if(gender.isEmpty()) throw new BaseException("请选择性别！"); 
			char[] pwd = this.userpwd.getPassword();
			char[] pwd2 = this.userpwd2.getPassword();
			String telephoneString = this.telephone.getText();
			String email = this.user_email.getText();
			String city = this.usercity.getText();
			Beanuser pBeanuser = oline_fresh_supermaketUtil.userManager.reg(name,this.gender,pwd, pwd2,telephoneString, city, email);
			this.setVisible(false);
		}catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.setVisible(false);
		
		
		
		
	}
	
	
	
}
