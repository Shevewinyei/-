package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Rectangle;
import java.awt.Dimension;

public class FrmMain_admin extends JFrame {

	private JPanel JPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain_admin frame = new FrmMain_admin();
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
	public FrmMain_admin() {
		setTitle("\u7BA1\u7406\u5458\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 593);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		/**
		 * 生鲜类别管理
		 */
		JMenu mnNewMenu = new JMenu("\u751F\u9C9C\u7C7B\u522B\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u751F\u9C9C\u7C7B\u522B\u7BA1\u7406\u5355\u5143");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//生鲜类别管理单元
				FrmFFManage dlgFfManage = new FrmFFManage();
				dlgFfManage.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);
		/**
		 * 商品管理
		 */
		JMenu mnNewMenu_1 = new JMenu("\u5546\u54C1\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5546\u54C1\u7BA1\u7406\u5355\u5143");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//商品管理单元
				FrmCommodityManage dlgCommodityManage = new FrmCommodityManage();
				dlgCommodityManage.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5546\u54C1\u91C7\u8D2D\u8BB0\u5F55");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//商品采购记录
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_4 = new JMenu("\u4F18\u60E0\u7BA1\u7406");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9650\u65F6\u4FC3\u9500\u5546\u54C1\u7BA1\u7406");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//限时促销商品管理
				FrmLDManage dlg = new FrmLDManage();
				dlg.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6EE1\u6298\u5546\u54C1\u7BA1\u7406");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//满折商品管理
				FrmFDManage dlgFdManage = new FrmFDManage();
				dlgFdManage.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u4F18\u60E0\u5238\u7BA1\u7406");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//优惠券管理
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u63A8\u8350\u83DC\u8C31");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u63A8\u8350\u83DC\u8C31\u7BA1\u7406");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//推荐菜谱管理
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("\u66F4\u591A");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改管理员密码
				change_admin_pwd_actionPerformed(e);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);
		JPanel = new JPanel();
		JPanel.setBackground(new Color(255, 255, 255));
		JPanel.setForeground(new Color(0, 0, 0));
		JPanel.setToolTipText("");
		JPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FrmMain_admin.class.getResource("/photo/\u8D85\u5E02.png")));
		GroupLayout gl_JPanel = new GroupLayout(JPanel);
		gl_JPanel.setHorizontalGroup(
			gl_JPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_JPanel.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
		);
		gl_JPanel.setVerticalGroup(
			gl_JPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JPanel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 539, Short.MAX_VALUE)
					.addContainerGap())
		);
		JPanel.setLayout(gl_JPanel);
	}

	protected void change_admin_pwd_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		FrmModifyPwd_admin dlg=new FrmModifyPwd_admin();
		dlg.setVisible(true);
	}
}
