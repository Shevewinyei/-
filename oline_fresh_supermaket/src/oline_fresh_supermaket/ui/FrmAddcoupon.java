package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.Beancoupon;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddcoupon extends JFrame {

	private JPanel contentPane;
	private JTextField abl_price;
	private JTextField red_price;
	private JTextField month;
	private JTextPane content;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddcoupon frame = new FrmAddcoupon();
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
	public FrmAddcoupon() {
		setTitle("\u6DFB\u52A0\u4F18\u60E0\u5238");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u9002\u7528\u91D1\u989D\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u51CF\u514D\u91D1\u989D\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u6709\u6548\u671F\uFF08\u6708\uFF09\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u5177\u4F53\u63CF\u8FF0\u5185\u5BB9\uFF1A");
		
		abl_price = new JTextField();
		abl_price.setColumns(10);
		
		red_price = new JTextField();
		red_price.setColumns(10);
		
		month = new JTextField();
		month.setColumns(10);
		
		content = new JTextPane();
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确定添加
				addAction(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(54)
							.addComponent(btnNewButton_1)
							.addGap(76))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(content)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(month)
									.addComponent(red_price)
									.addComponent(abl_price)))
							.addContainerGap(105, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(abl_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(red_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(content, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void addAction(ActionEvent e) {
		// TODO Auto-generated method stub
		Beancoupon p = new Beancoupon();
		p.setCou_content(content.getText());
		p.setCou_abl_price(Double.parseDouble(abl_price.getText()));
		p.setCou_redu_price(Double.parseDouble(red_price.getText()));
		p.setCou_starttime(new java.sql.Date(System.currentTimeMillis()) );
		int months = Integer.parseInt(month.getText());
		p.setCou_enddate(new java.sql.Date(System.currentTimeMillis()+months*2592000000L+172800000L));
		try {
			oline_fresh_supermaketUtil.couponManager.add(p);
			this.setVisible(false);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
