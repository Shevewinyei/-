package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.BeanAdmin;
import oline_fresh_supermaket.model.Beancom_purchase;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmAddpurchase extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField count;
	private JTextField hour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddpurchase frame = new FrmAddpurchase();
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
	public FrmAddpurchase() {
		setTitle("\u6DFB\u52A0\u8BA2\u8D2D\u5355");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BA2\u8D2D\u5355\u5546\u54C1\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u8BA2\u8D2D\u5355\u5546\u54C1\u6570\u91CF\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u8BA2\u8D2D\u5355\u914D\u9001\u65F6\u95F4(\u5C0F\u65F6)\uFF1A");
		
		id = new JTextField();
		id.setColumns(10);
		
		count = new JTextField();
		count.setColumns(10);
		
		hour = new JTextField();
		hour.setColumns(10);
		
		JButton btnok = new JButton("\u786E\u5B9A");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确定
				AddAction(e);
			}
		});
		
		JButton btncancel = new JButton("\u8FD4\u56DE");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(92)
							.addComponent(btnok)))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btncancel)
						.addComponent(hour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(hour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnok)
						.addComponent(btncancel))
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void AddAction(ActionEvent e) {
		// TODO Auto-generated method stub
		Beancom_purchase t = new Beancom_purchase();
		t.setPurchase_id(Integer.parseInt(id.getText()));
		t.setAdmin_id(BeanAdmin.currentLoginAdmin.getAdmin_id());
		t.setPurchase_count(Integer.parseInt(count.getText()));
		t.setPurchase_time(new java.sql.Date(System.currentTimeMillis()));
		t.setArrive_time(new java.sql.Date(System.currentTimeMillis()+Integer.parseInt(hour.getText())*3600000L));
		t.setPurchase_state("入库");
		try {
			oline_fresh_supermaketUtil.com_purchaseManager.add(t);
			this.setVisible(false);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
