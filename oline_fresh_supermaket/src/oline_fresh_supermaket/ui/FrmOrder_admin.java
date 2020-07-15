package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmOrder_admin extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel toolBar = new JPanel();
	private Button btnModity = new Button("点击配送");
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
			messList = oline_fresh_supermaketUtil.ordermessageManager.load();
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
	public FrmOrder_admin(){
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("订单表");
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnModity);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.WEST);
	    this.dataTable.addMouseListener(new MouseAdapter (){
	    	@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmOrder_admin.this.dataTable.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmOrder_admin.this.reloadTabel1(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTable1), BorderLayout.CENTER);
	    
	    this.reloadTable();
	    
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
		
		this.btnModity.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnModity) {
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要配送的订单","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanorder_message p = this.messList.get(i);
			if(p.getOrd_state().equals("完成")||p.getOrd_state().equals("配送")) {
				JOptionPane.showMessageDialog(null,  "订单已完成或在配送中！","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"确定配送吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.ordermessageManager.Modify_state2(p.getOrd_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
}
