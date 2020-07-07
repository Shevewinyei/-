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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 593);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		/**
		 * 生鲜类别管理
		 */
		JMenu mnNewMenu = new JMenu("\u751F\u9C9C\u7C7B\u522B\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6DFB\u52A0\u751F\u9C9C\u7C7B\u522B");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加生鲜类别
				Add_FF_actionPerformed(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5220\u9664\u751F\u9C9C\u7C7B\u522B");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除生鲜类别
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u4FEE\u6539\u63CF\u8FF0");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改生鲜描述
			}
		});
		mnNewMenu.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u751F\u9C9C\u7C7B\u522B\u7BA1\u7406\u5355\u5143");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//生鲜类别管理单元
			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);
		/**
		 * 商品管理
		 */
		JMenu mnNewMenu_1 = new JMenu("\u5546\u54C1\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6DFB\u52A0\u5546\u54C1");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加商品
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5220\u9664\u5546\u54C1");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除商品
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u4FEE\u6539\u5546\u54C1\u5269\u4F59\u6570\u91CF");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改商品剩余数量
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u4FEE\u6539\u5546\u54C1\u89C4\u683C");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改商品规格
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u4FEE\u6539\u5546\u54C1\u63CF\u8FF0");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改商品描述
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		/**
		 * 顾客账户管理
		 */
		JMenu mnNewMenu_2 = new JMenu("\u987E\u5BA2\u8D26\u6237\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u9000\u6B3E\u5904\u7406");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退款处理
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u91CD\u7F6E\u5BC6\u7801");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//重置密码
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
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
		JPanel.setToolTipText("");
		JPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanel);
		GroupLayout gl_JPanel = new GroupLayout(JPanel);
		gl_JPanel.setHorizontalGroup(
			gl_JPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE)
		);
		gl_JPanel.setVerticalGroup(
			gl_JPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 268, Short.MAX_VALUE)
		);
		JPanel.setLayout(gl_JPanel);
	}

	protected void Add_FF_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		FrmAddFF dlgAddFF = new FrmAddFF();
		dlgAddFF.setVisible(true);
	}

	protected void change_admin_pwd_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		FrmModifyPwd_admin dlg=new FrmModifyPwd_admin();
		dlg.setVisible(true);
	}

	
}
