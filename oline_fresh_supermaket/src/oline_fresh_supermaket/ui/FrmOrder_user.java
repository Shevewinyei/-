package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmOrder_user extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); 
	private JMenu menu_order = new JMenu("订单处理");
	private JMenu menu_eva = new JMenu("评价管理");
	
	 private JMenuItem  menuItem_ok = new JMenuItem("确认收货");
	 private JMenuItem  menuItem_delete = new JMenuItem("删除订单");
	 
	 private JMenuItem menuItem_eva = new JMenuItem("评价管理单元");
	 
	//订单
	private Object tblTitle[]=Beanorder_message.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	//订单详情
	private Object tblTitle1[]=Beanorder_content.tableTitles;
	private Object tblData1[][];
	DefaultTableModel tabModel1=new DefaultTableModel();
	private JTable dataTable1=new JTable(tabModel1);
	
	private Beanorder_message ord = null;
	List<Beanorder_message> messList = null;
	List<Beanorder_content> conList = null;
	private void reloadTable(){
		try {
			messList = oline_fresh_supermaketUtil.ordermessageManager.allload();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblData =  new Object[messList.size()][Beanorder_message.tableTitles.length];
		for(int i=0;i<messList.size();i++){
			for(int j=0;j<Beanorder_message.tableTitles.length;j++)
				tblData[i][j]=messList.get(i).getCell(j);
		}
		tabModel.setDataVector(tblData,tblTitle);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
	private void reloadTabel1(int Index){
		if(Index<0) return;
		ord = messList.get(Index);
		try {
			conList = oline_fresh_supermaketUtil.ordercontentManager.allload(ord);
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblData1 =new Object[conList.size()][Beanorder_content.tableTitles.length];
		for(int i=0;i<conList.size();i++){
			for(int j=0;j<Beanorder_content.tableTitles.length;j++)
				tblData1[i][j]=conList.get(i).getCell(j);
		}
		
		tabModel1.setDataVector(tblData1,tblTitle1);
		this.dataTable1.validate();
		this.dataTable1.repaint();
	}
	public FrmOrder_user(){
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("订单表");
		
		menubar.add(menu_order);
		menubar.add(menu_eva);
		
		this.menu_order.add(this.menuItem_ok);
		this.menu_order.add(this.menuItem_delete);
		this.menu_eva.add(menuItem_eva);
		this.setJMenuBar(menubar);
		
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.WEST);
	    this.dataTable.addMouseListener(new MouseAdapter (){
	    	@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmOrder_user.this.dataTable.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmOrder_user.this.reloadTabel1(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTable1), BorderLayout.CENTER);
	    
	    this.reloadTable();
	    
	    this.menuItem_delete.addActionListener(this);
	    this.menuItem_eva.addActionListener(this);
	    this.menuItem_ok.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.menuItem_ok) {
			int i = this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "请选择订单", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanorder_message p = this.messList.get(i);
			if(p.getOrd_state().equals("下单")){
				JOptionPane.showMessageDialog(null, "等待超市配送中.....", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"确定已收货吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.ordermessageManager.Modify_state(p.getOrd_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.menuItem_delete) {
			int i = this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "请选择订单", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanorder_message p = this.messList.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定删除该订单吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.ordermessageManager.deleteOrder(p.getOrd_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.menuItem_eva) {
			int i = this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "请选择订单", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanorder_message p = this.messList.get(i);
			if(p.getOrd_state().equals("下单")||p.getOrd_state().equals("配送")) {
				JOptionPane.showMessageDialog(null, "确认收货后才能评价！", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			FrmEvaluate dlgEvaluate = new FrmEvaluate(p.getOrd_id());
			dlgEvaluate.setVisible(true);
		}
	}
}
