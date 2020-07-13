package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddCommodity extends JFrame {

	private JPanel contentPane;
	private JTextField com_id;
	private JTextField com_name;
	private JTextField com_price;
	private JTextField com_vip_price;
	private JTextField com_count;
	private JTextField com_spec;
	private JTextPane com_describle = new JTextPane();
	private JTextField FF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddCommodity frame = new FrmAddCommodity();
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
	public FrmAddCommodity() {
		setTitle("\u6DFB\u52A0\u5546\u54C1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		
		com_id = new JTextField();
		com_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		
		com_name = new JTextField();
		com_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u4EF7\u683C\uFF1A");
		
		com_price = new JTextField();
		com_price.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1vip\u4EF7\u683C\uFF1A");
		
		com_vip_price = new JTextField();
		com_vip_price.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5546\u54C1\u6570\u91CF\uFF1A");
		
		com_count = new JTextField();
		com_count.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u5546\u54C1\u89C4\u683C\uFF1A");
		
		com_spec = new JTextField();
		com_spec.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5546\u54C1\u63CF\u8FF0\uFF1A");
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加商品
				add_actionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消
				cancel_actionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("\u5546\u54C1\u7C7B\u522B\uFF1A");
		
		FF = new JTextField();
		FF.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_7, Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4))
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(com_spec)
									.addComponent(com_count)
									.addComponent(com_vip_price)
									.addComponent(com_name)
									.addComponent(com_id)
									.addComponent(com_price)
									.addComponent(FF))
								.addComponent(com_describle, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
							.addGap(122))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addComponent(btnNewButton)
					.addGap(98)
					.addComponent(btnNewButton_1)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(com_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(com_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(FF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(com_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(com_vip_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(com_count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(com_spec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6)
						.addComponent(com_describle, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void add_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Beancommodity p = new Beancommodity();
		p.setCom_id(Integer.parseInt(com_id.getText()));
		p.setFF_id(Integer.parseInt(this.FF.getText()));
		p.setCom_name(com_name.getText());
		p.setCom_price(Double.parseDouble(com_price.getText()));
		p.setCom_vip_price(Double.parseDouble(com_vip_price.getText()));
		p.setCom_count(Integer.parseInt(com_count.getText()));
		p.setCom_specification(com_spec.getText());
		p.setCom_describle(this.com_describle.getText());
		try {
			Beancommodity.currentCom = oline_fresh_supermaketUtil.comManager.addcommodity(p);
			this.setVisible(false);
		}catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}

	private void cancel_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
