package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanlimit_discount;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddLD extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	private JTextField count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddLD frame = new FrmAddLD();
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
	public FrmAddLD() {
		setTitle("\u6DFB\u52A0\u4FC3\u9500\u5546\u54C1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u4FC3\u9500\u4EF7\u683C\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u4FC3\u9500\u6570\u91CF\uFF1A");
		
		name = new JTextField();
		name.setColumns(10);
		
		price = new JTextField();
		price.setColumns(10);
		
		count = new JTextField();
		count.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认添加
				addAction(e);
				setVisible(false);
				FrmLDManage dlg = new FrmLDManage();
				dlg.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消
				setVisible(false);
				FrmLDManage dlg = new FrmLDManage();
				dlg.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(39))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void addAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameString = name.getText();
		double LDprice = Double.parseDouble(price.getText());
		int LDcount = Integer.parseInt(count.getText());
		try {
			Beancommodity p = oline_fresh_supermaketUtil.comManager.add(nameString, LDprice, LDcount);
			oline_fresh_supermaketUtil.LDManager.add(p);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
