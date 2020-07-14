package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.FFManage;
import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmCommodityManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加商品");
	//private Button btnModify = new Button("修改出版社");
	private Button btnDelete = new Button("删除商品");
	private Button btnSearch = new Button("查询商品");   //添加
	private Button btncancel = new Button("退出");  
	private JTextField edtKeyword = new JTextField(10);
	private Object tblTitle[]={"商品编号","商品名称","商品价格","商品vip价格","商品数量","商品规格","商品描述"};
	private Object tblData[][];
	List<Beancommodity> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			pubs = (new commodityManage().loadcommodity());
			tblData =new Object[pubs.size()][7];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getCom_id()+"";
				tblData[i][1]=pubs.get(i).getCom_name();
				tblData[i][2]=pubs.get(i).getCom_price();
				tblData[i][3]=pubs.get(i).getCom_vip_price();
				tblData[i][4]=pubs.get(i).getCom_count();
				tblData[i][5]=pubs.get(i).getCom_specification();
				tblData[i][6]=pubs.get(i).getCom_describle();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		}catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void reloadTable(List<Beancommodity> pubs) {
		tblData =new Object[pubs.size()][7];
		for(int i=0;i<pubs.size();i++){
			tblData[i][0]=pubs.get(i).getCom_id()+"";
			tblData[i][1]=pubs.get(i).getCom_name();
			tblData[i][2]=pubs.get(i).getCom_price();
			tblData[i][3]=pubs.get(i).getCom_vip_price();
			tblData[i][4]=pubs.get(i).getCom_count();
			tblData[i][5]=pubs.get(i).getCom_specification();
			tblData[i][6]=pubs.get(i).getCom_describle();
		}
		tablmod.setDataVector(tblData,tblTitle);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
	public static void main(String[] args) {
		FrmCommodityManage dlgCommodityManage = new FrmCommodityManage();
		dlgCommodityManage.setVisible(true);
	}
	public  FrmCommodityManage() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		//toolBar.add(btnModify);
		toolBar.add(this.btnDelete);
		toolBar.add(edtKeyword);
		toolBar.add(btnSearch);
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
	//	this.btnModify.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnSearch.addActionListener(this);
		this.btncancel.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnAdd) {
			FrmAddCommodity dlg = new FrmAddCommodity();
			dlg.setVisible(true);
			this.reloadTable();
		}else if(e.getSource() == this.btnDelete) {
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择商品","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beancommodity p =  this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定删除"+p.getCom_name()+"吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					(new commodityManage()).deletecommodity(p.getCom_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==btncancel) {
			this.setVisible(false);
		}
		else if(e.getSource()==btnSearch) {
			List<Beancommodity> pubs1 = new ArrayList<Beancommodity>();
			int comid;
			String com_id = edtKeyword.getText();
			if(com_id.isEmpty()) {
				comid = 0;
			}else {
				comid = Integer.parseInt(com_id);
			}
			try {
				Beancommodity p = oline_fresh_supermaketUtil.comManager.seachcommodity(comid);
				pubs1.add(p);
				this.reloadTable(pubs1);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
	}
}
