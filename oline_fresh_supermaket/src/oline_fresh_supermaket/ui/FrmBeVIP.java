package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.BusinessException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class FrmBeVIP extends JFrame {
	private String name;
	private JPanel contentPane;
	private int index = 0;
	private int index1 = 0;
	private ButtonGroup group;
	private ButtonGroup group_1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmBeVIP frame = new FrmBeVIP();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrmBeVIP(String Username) {
		name = Username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JRadioButton Cyear = new JRadioButton("\u8FDE\u7EED\u5305\u5E74\uFF1A\u00A588");
		Cyear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//连续包年
				index = 1;
			}
		});
		
		JRadioButton year = new JRadioButton("\u5E74\u5361\u4F1A\u5458\uFF1A\u00A5108");
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//年卡会员
				index = 2;
			}
		});
		
		JRadioButton Cquarter = new JRadioButton("\u8FDE\u7EED\u5305\u5B63\uFF1A\u00A530");
		Cquarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//连续包季
				index = 3;
			}
		});
		
		JRadioButton quarter = new JRadioButton("\u5B63\u5361\u4F1A\u5458\uFF1A\u00A545");
		quarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//季卡会员
				index = 4;
			}
		});
		
		JRadioButton Alipay = new JRadioButton("\u652F\u4ED8\u5B9D\u652F\u4ED8");
		Alipay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//支付宝支付
				index1 = 1;
			}
		});
		
		JRadioButton WeChat = new JRadioButton("\u5FAE\u4FE1\u652F\u4ED8");
		WeChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//微信支付
				index1 = 2;
			}
		});
		
		JButton yes = new JButton("\u786E\u8BA4\u5F00\u901A");
		
		group=new ButtonGroup();
		group.add(Cyear);
		group.add(Cquarter);
		group.add(year);
		group.add(quarter);
		
		group_1 = new ButtonGroup();
		group_1.add(WeChat);
		group_1.add(Alipay);
		
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认充值
				try {
					YesAction(e);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton cancel = new JButton("\u8FD4\u56DE");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回
				CancelAction(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u60A8\u8981\u5145\u503C\u7684\u4F1A\u5458\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u652F\u4ED8\u65B9\u5F0F\uFF1A");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(quarter)
								.addComponent(year)
								.addComponent(Cyear)
								.addComponent(Cquarter)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(Alipay)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(11)
											.addComponent(yes)))
									.addGap(42)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cancel)
										.addComponent(WeChat)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Cyear)
					.addGap(18)
					.addComponent(year)
					.addGap(18)
					.addComponent(Cquarter)
					.addGap(18)
					.addComponent(quarter)
					.addGap(25)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Alipay)
						.addComponent(WeChat))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(yes)
						.addComponent(cancel))
					.addGap(43))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void YesAction(ActionEvent e) throws BaseException {
		// TODO Auto-generated method stub
		if(index == 0 || index1 == 0) JOptionPane.showMessageDialog(null, "请同时选择套餐和支付方式。");
		if(index == 1 ||index == 2) {
			//ddl+1年
			java.sql.Date addDate =  new Date(31536000000L);
			oline_fresh_supermaketUtil.userManager.setDDLDate(name, addDate);
		}else {
			//ddl + 3个月
			java.sql.Date addDate =  new Date(7776000000L);
			oline_fresh_supermaketUtil.userManager.setDDLDate(name, addDate);
		}
		oline_fresh_supermaketUtil.userManager.bevip(name);
		this.setVisible(false);
		FrmMain_user dlg = new FrmMain_user(name);
		dlg.setVisible(true);
	}

	private void CancelAction(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		FrmMain_user dlg = new FrmMain_user(name);
		dlg.setVisible(true);
	}
}
