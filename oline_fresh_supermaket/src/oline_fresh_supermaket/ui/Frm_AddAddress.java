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
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frm_AddAddress extends JFrame {

	private JPanel contentPane;
	private JTextField pro;
	private JTextField city;
	private JTextField area;
	private JTextPane currentarea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_AddAddress frame = new Frm_AddAddress();
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
	public Frm_AddAddress() {
		setTitle("\u6DFB\u52A0\u5730\u5740");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6240  \u5728  \u7701\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u6240  \u5728  \u5E02\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u6240  \u5728  \u533A\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u5177\u4F53\u8857\u9053\uFF1A");
		
		pro = new JTextField();
		pro.setColumns(10);
		
		city = new JTextField();
		city.setColumns(10);
		
		area = new JTextField();
		area.setColumns(10);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ìí¼Ó
				addAction(e);
			}
		});
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//È¡Ïû
				setVisible(false);
			}
		});
		
		currentarea = new JTextPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(currentarea)
								.addComponent(area, Alignment.LEADING)
								.addComponent(city, Alignment.LEADING)
								.addComponent(pro, Alignment.LEADING)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(btnAdd)
							.addGap(46)
							.addComponent(btnCancel)))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(pro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(area, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(currentarea, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd)
						.addComponent(btnCancel))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void addAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String addpro = pro.getText();
		String addcity = city.getText();
		String addarea = area.getText();
		String addcurrent = this.currentarea.getText();
		try {
			oline_fresh_supermaketUtil.addrManager.Add(addpro,addcity,addarea,addcurrent);
			this.setVisible(false);
		}catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
