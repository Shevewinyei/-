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
import oline_fresh_supermaket.model.BeanFD_com_connect;
import oline_fresh_supermaket.model.BeanFull_discount;
import oline_fresh_supermaket.util.BaseException;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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

public class FrmMain_user extends JFrame {

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
	private Object tblTitle2[]={"限时优惠信息"};
	private Object tblData2[][];
	List<BeanFull_discount> pubs2;
	DefaultTableModel tablmod2=new DefaultTableModel();
	private JTable dataTable2 =new JTable(tablmod2);
	private void reloadTable2(){
		try {
			pubs2 = (new FDManager().loadFD());
			tblData2 =new Object[pubs2.size()][1];
			for(int i=0;i<pubs2.size();i++){
			//	tblData2[i][0] = pubs2.get(i).getFD_content();
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain_user frame = new FrmMain_user();
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
	public FrmMain_user() {
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
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BA2\u5355");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u67E5\u770B\u5386\u53F2\u8BA2\u5355");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查看历史订单
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u7528\u6237\u4FE1\u606F\u8BBE\u7F6E");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//用户信息设置
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u7528\u6237\u5730\u5740\u7BA1\u7406");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//用户地址管理
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u4F18\u60E0\u5238\u5361\u5305");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//优惠卡包
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
		
		JMenu mnNewMenu_2 = new JMenu("\u66F4\u591A");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u8D85\u5E02\u4F18\u60E0\u4FE1\u606F");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setFont(new Font("Libian SC", Font.PLAIN, 34));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(150))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
							.addGap(60))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
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
