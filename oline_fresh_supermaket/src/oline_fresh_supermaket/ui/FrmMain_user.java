package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.FDManager;
import oline_fresh_supermaket.control.FFManage;
import oline_fresh_supermaket.control.LDManager;
import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.BeanFD_com_connect;
import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.model.BeanFull_discount;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanlimit_discount;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class FrmMain_user extends JFrame {
	private String Userid;
	private JPanel contentPane;
	private Object tblTitle[]={"满折优惠信息","开始","结束"};
	private Object tblData[][];
	List<BeanFull_discount> pubs1;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable1 =new JTable(tablmod);
	private void reloadTable1(){
		try {
			pubs1 = (new FDManager().loadFD());
			tblData =new Object[pubs1.size()][3];
			for(int i=0;i<pubs1.size();i++){
				tblData[i][0] = pubs1.get(i).getFD_content();
				tblData[i][1] = pubs1.get(i).getFD_startdate();
				tblData[i][2] = pubs1.get(i).getFD_enddate();
			}
			tablmod.setDataVector(tblData,tblTitle);
			dataTable1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			dataTable1.setPreferredScrollableViewportSize(new Dimension(200, 300));
			this.dataTable1.validate();
			this.dataTable1.repaint();
		}catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Object tblTitle2[]={"商品名称","限时优惠价格","开始时间","结束时间"};
	private Object tblData2[][];
	List<Beancommodity> pubs2;
	List<Beanlimit_discount> pubs3;
	DefaultTableModel tablmod2=new DefaultTableModel();
	private JTable dataTable2 =new JTable(tablmod2);
	private void reloadTable2(){
		try {
			pubs2 = (new commodityManage().loadall(3100));
			pubs3 = (new LDManager().loadall());
			tblData2 =new Object[pubs2.size()][4];
			for(int i=0;i<pubs2.size();i++){
				tblData2[i][0] = pubs2.get(i).getCom_name();
			}
			for (int i = 0; i < pubs3.size(); i++) {
				tblData2[i][1] = pubs3.get(i).getLD_price();
				tblData2[i][2] = pubs3.get(i).getLD_starttime();
				tblData2[i][3] = pubs3.get(i).getLD_enddate();
			}
			tablmod2.setDataVector(tblData2,tblTitle2);
			dataTable2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			dataTable2.setPreferredScrollableViewportSize(new Dimension(200, 300));
			this.dataTable2.validate();
			this.dataTable2.repaint();
		}catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 */
	public FrmMain_user(String userid) {
		Userid = userid; 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 624);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8D2D\u4E70\u5546\u54C1");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5546\u54C1\u8868");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//商品表
				FrmBuyCom dlg = new FrmBuyCom();
				dlg.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
		JMenu mnNewMenu1 = new JMenu("推荐菜谱");
		menuBar.add(mnNewMenu1);
		JMenuItem mntmNewMenuItem1 = new JMenuItem("菜谱详情");
		mnNewMenu1.add(mntmNewMenuItem1);
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//菜谱详情
				FrmMenu dlgFrmMenu = new FrmMenu();
				dlgFrmMenu.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("\u8BA2\u5355");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u67E5\u770B\u5386\u53F2\u8BA2\u5355");
		JMenuItem searchItem = new JMenuItem("推荐商品");
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查看历史订单
				FrmOrder_user dlg = new FrmOrder_user();
				dlg.setVisible(true);
			}
		});
		searchItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//统计查询
				FrmSearchView dlg = new FrmSearchView();
				dlg.setVisible(true);
			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mnNewMenu_1.add(searchItem);
		
		JMenu mnNewMenu_3 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u7528\u6237\u4FE1\u606F\u8BBE\u7F6E");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//用户信息设置
				Frmcurrentuser dlg;
				try {
					dlg = new Frmcurrentuser();
					dlg.setVisible(true);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u7528\u6237\u5730\u5740\u7BA1\u7406");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//用户地址管理
				FrmAddressManage dlgAddressManage = new FrmAddressManage();
				dlgAddressManage.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u4F18\u60E0\u5238\u5361\u5305");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//优惠券卡包
				FrmCoupon dlgCoupon = new FrmCoupon();
				dlgCoupon.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		//显示FD折扣信息
		this.reloadTable1();
		JScrollPane scrollPane_1 = new JScrollPane(this.dataTable1);
		scrollPane_1.setPreferredSize(new Dimension(460, 190));
		panel.add(scrollPane_1, BorderLayout.CENTER);
		setTableColumnCenter(dataTable1);
		//显示限时促销信息
		this.reloadTable2();
		JScrollPane scrollPane = new JScrollPane(this.dataTable2);
		scrollPane.setPreferredSize(new Dimension(460, 190));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		setTableColumnCenter(dataTable2);
		
		JMenu mnNewMenu_4 = new JMenu("\u4F1A\u5458\u4FE1\u606F");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5145\u503C\u4F1A\u5458");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//充值会员
				FrmBeVIP dlg = new FrmBeVIP(Userid);
				dlg.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u67E5\u770B\u4F1A\u5458\u5230\u671F\u65F6\u95F4");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查看会员到期时间
				try {
					java.sql.Date pDate = oline_fresh_supermaketUtil.userManager.searchDDLDate(Userid);
					JOptionPane.showMessageDialog(null,pDate);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		//JMenu mnNewMenu_2 = new JMenu("\u66F4\u591A");
		//menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u8D85\u5E02\u4F18\u60E0\u4FE1\u606F");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setFont(new Font("Libian SC", Font.PLAIN, 34));
		
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u662F\u5426VIP\uFF1A");
		
		//显示当前用户的用户名字和是否是vip信息
		JLabel user_name = new JLabel(Userid);
		JLabel Vip;
		boolean p = false ;
		try {
			p = oline_fresh_supermaketUtil.userManager.isvip(Userid);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (p) {
			Vip = new JLabel("是");
		}else {
			Vip = new JLabel("否");
		}
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(176, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(150))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
							.addGap(60))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Vip))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(user_name)))
					.addContainerGap(460, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(user_name))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(Vip))
					.addGap(24)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void setTableColumnCenter(JTable table){
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
		
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
	}
}
