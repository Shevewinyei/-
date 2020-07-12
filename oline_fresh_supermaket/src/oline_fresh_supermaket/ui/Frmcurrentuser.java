package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frmcurrentuser extends JFrame {

	private JPanel contentPane;
	private JLabel name;
	private JLabel gender;
	private JLabel telephone ;
	private JLabel vip_ddl;
	private JLabel isvip;
	private JLabel reg_time ;
	private JLabel city ;
	private JLabel email ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmcurrentuser frame = new Frmcurrentuser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws BaseException 
	 */
	public Frmcurrentuser() throws BaseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u6027  \u522B\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u7535  \u8BDD\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u6240\u5728\u57CE\u5E02\uFF1A");
		
		JLabel lblNewLabel_5 = new JLabel("\u6CE8\u518C\u65F6\u95F4\uFF1A");
		
		JLabel lblNewLabel_6 = new JLabel("\u662F\u5426\u662FVIP\uFF1A");
		
		JLabel lblNewLabel_7 = new JLabel("VIP\u622A\u6B62\u65E5\u671F\uFF1A");
		
		Beanuser p = new Beanuser();
		p = oline_fresh_supermaketUtil.userManager.searchUser(Beanuser.currentLoginUser.getUsr_id());
		
		name = new JLabel(p.getUsr_name());
		gender = new JLabel(p.getUsr_gender());
		telephone = new JLabel(p.getUsr_phonenumber());
		vip_ddl = new JLabel(p.getUsr_vip_ddl()+"");
		isvip = new JLabel(p.isUsr_isvip()+"");
		reg_time = new JLabel(p.getUsr_registration_time()+"");
		city = new JLabel(p.getUsr_city());	
		email = new JLabel(p.getUsr_email());
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改用户信息
				setVisible(false);
				FrmchangeUserMessage dlg = new FrmchangeUserMessage();
				dlg.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(89))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_2)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel))
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(name)
										.addComponent(telephone)
										.addComponent(email)
										.addComponent(city)
										.addComponent(reg_time)
										.addComponent(isvip)
										.addComponent(vip_ddl)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addComponent(gender))))
								.addComponent(lblNewLabel_1))
							.addContainerGap(287, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(name))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(gender))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(telephone))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(city))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(reg_time))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(isvip))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(vip_ddl))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
