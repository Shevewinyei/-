package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class FrmAddFD extends JFrame {

	private JPanel contentPane;
	private JTextField count;
	private JTextField discount;
	private JTextField month;
	private JTextPane content;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddFD frame = new FrmAddFD();
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
	public FrmAddFD() {
		setTitle("\u6DFB\u52A0\u65B0\u7684\u6EE1\u6298\u4F18\u60E0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u8FBE\u5230\u6EE1\u51CF\u6761\u4EF6\u7684\u5546\u54C1\u6570\u91CF\uFF1A");
		
		JLabel label_1 = new JLabel("\u4F18\u60E0\u540E\u4EF7\u683C/\u4F18\u60E0\u524D\u4EF7\u683C\uFF1A");
		
		JLabel label_2 = new JLabel("\u6D3B\u52A8\u65F6\u95F4\uFF08\u6708\u4E3A\u5355\u4F4D\uFF09\uFF1A");
		
		count = new JTextField();
		count.setColumns(10);
		
		discount = new JTextField();
		discount.setColumns(10);
		
		month = new JTextField();
		month.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认添加
				addAction(e);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u4F18\u60E0\u63CF\u8FF0\uFF1A");
		
		content = new JTextPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(label_2)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addComponent(btnNewButton)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(content, Alignment.LEADING)
								.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(discount, Alignment.LEADING)
									.addComponent(count, Alignment.LEADING)
									.addComponent(month, Alignment.LEADING)))
							.addContainerGap(42, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(btnNewButton_1)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(discount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(content, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(45)))
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(312, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(45))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void addAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String FD_content = content.getText();
		int FD_com_count = Integer.parseInt(count.getText());
		double FD_discount = Double.parseDouble(discount.getText());
		int FD_month = Integer.parseInt(month.getText());
		try {
			oline_fresh_supermaketUtil.FDManager.add_FD(FD_content,FD_com_count,FD_discount,FD_month);
			this.setVisible(false);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
