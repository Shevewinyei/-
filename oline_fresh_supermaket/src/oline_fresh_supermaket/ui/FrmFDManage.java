package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.BeanFD_com_connect;
import oline_fresh_supermaket.model.BeanFull_discount;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmFDManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加满折优惠");
	private Button btnAddcom = new Button("该满折添加商品");
	private Button btnDelete = new Button("删除满折");
	private Button btncancel = new Button("退出"); 
	private Object tblTitle[]={"满折编号","满折内容","达到满折的商品数量","满折折扣","满折开始时间","满折结束时间"};
	private Object tblData[][];
	List<BeanFull_discount> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			pubs = oline_fresh_supermaketUtil.FDManager.loadFD();
			tblData =new Object[pubs.size()][6];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getFD_id();
				tblData[i][1]=pubs.get(i).getFD_content();
				tblData[i][2]=pubs.get(i).getFD_com_count();
				tblData[i][3]=pubs.get(i).getFD_discount();
				tblData[i][4]=pubs.get(i).getFD_startdate();
				tblData[i][5]=pubs.get(i).getFD_enddate();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		}catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		FrmFDManage dlg = new FrmFDManage();
		dlg.setVisible(true);
	}
	public FrmFDManage() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnAddcom);
		toolBar.add(btnDelete);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		//提取现有数据
		this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		this.validate();

		this.btnAdd.addActionListener(this);
		this.btnAddcom.addActionListener(this);
		this.btncancel.addActionListener(this);
		this.btnDelete.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btncancel) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnDelete){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要删除优惠","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFull_discount p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定删除该优惠吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.FDManager.delete(p.getFD_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnAddcom){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择折扣","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFull_discount p = this.pubs.get(i);
			FrmAddFD_com dlg = new FrmAddFD_com(p);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.btnAdd) {
			FrmAddFD dlg = new FrmAddFD();
			dlg.setVisible(true);
		}
				
	}

}
