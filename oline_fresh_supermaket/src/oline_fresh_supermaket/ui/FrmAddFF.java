package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddFF extends JFrame {

	private JPanel contentPane;
	private JTextField FF_id;
	private JTextField FF_name;
	JTextPane FF_describle = new JTextPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddFF frame = new FrmAddFF();
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
	public FrmAddFF() {
		setTitle("\u6DFB\u52A0\u751F\u9C9C\u7C7B\u522B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u751F\u9C9C\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u751F\u9C9C\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u751F\u9C9C\u63CF\u8FF0\uFF1A");
		
		FF_id = new JTextField();
		FF_id.setColumns(10);
		
		FF_name = new JTextField();
		FF_name.setColumns(10);
		
		
		
		JButton AddFFButton = new JButton("\u6DFB\u52A0");
		AddFFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加生鲜类别
				Add_FF_actionPerformed(e);
			}
		});
		
		JButton CancelButton = new JButton("\u9000\u51FA");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出
				Cancel_actionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(FF_describle)
								.addComponent(FF_name)
								.addComponent(FF_id, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(AddFFButton)
							.addGap(80)
							.addComponent(CancelButton)))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(FF_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(FF_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(FF_describle, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(CancelButton)
						.addComponent(AddFFButton))
					.addGap(47))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void Cancel_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	private void Add_FF_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int FFid;
		String ffid = this.FF_id.getText();
		if(ffid.isEmpty()) {
			FFid = 0;
		}else {
			 FFid = Integer.parseInt(ffid);
		}
		String FFname = this.FF_name.getText();
		String FFdescrible = this.FF_describle.getText();
		try {
			BeanFF.currentFF = oline_fresh_supermaketUtil.FFManager.addFF(FFid, FFname, FFdescrible);
			this.setVisible(false);
		}catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
