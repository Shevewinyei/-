package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmOrder extends JFrame {
	private static final long serialVersionUID = 1L;
	//¶©µ¥
	private Object tblTitle[]=Beanorder_message.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	//¶©µ¥ÏêÇé
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
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
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
	public FrmOrder(){
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("ÀúÊ·¶©µ¥");
		
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.WEST);
	    this.dataTable.addMouseListener(new MouseAdapter (){
	    	@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmOrder.this.dataTable.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmOrder.this.reloadTabel1(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTable1), BorderLayout.CENTER);
	    
	    this.reloadTable();
	    
	}
}
