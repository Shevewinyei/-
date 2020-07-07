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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmModifyPwd_admin extends JFrame {

	private JPanel contentPane;
	private JTextField Admin_name;
	private JPasswordField oldpwd;
	private JPasswordField newpwd;
	private JPasswordField newpwd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmModifyPwd_admin frame = new FrmModifyPwd_admin();
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
	public FrmModifyPwd_admin() {
		setTitle("\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u65E7  \u5BC6  \u7801\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0  \u5BC6  \u7801\uFF1A");
		
		Admin_name = new JTextField();
		Admin_name.setColumns(10);
		
		oldpwd = new JPasswordField();
		
		newpwd = new JPasswordField();
		
		JButton ModifyButton = new JButton("\u4FEE\u6539");
		ModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ÐÞ¸ÄÃÜÂë
				Modify_adminpwd_actionPerformed(e);
			}
		});
		
		JButton CancelButton = new JButton("\u9000\u51FA");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ÍË³ö
				Cancel_actionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("\u65B0  \u5BC6  \u7801\uFF1A");
		
		newpwd2 = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_3)
									.addComponent(lblNewLabel_2)))
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(newpwd2)
								.addComponent(newpwd)
								.addComponent(oldpwd)
								.addComponent(Admin_name)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addComponent(ModifyButton)
							.addGap(56)
							.addComponent(CancelButton)))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Admin_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(oldpwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(newpwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(newpwd2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ModifyButton)
						.addComponent(CancelButton))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void Cancel_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	private void Modify_adminpwd_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			oline_fresh_supermaketUtil.adminManager.changePwd(BeanAdmin.currentLoginAdmin,new String(oldpwd.getPassword()),new String(newpwd.getPassword()),new String(newpwd2.getPassword()));
			this.setVisible(false);
		} catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
