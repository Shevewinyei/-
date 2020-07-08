package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.util.BaseException;

public class FrmCommodityManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加商品");
	//private Button btnModify = new Button("修改出版社");
	private Button btnDelete = new Button("删除商品");
	private Button btnSearch = new Button("查询商品");   //添加
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
	public static void main(String[] args) {
		FrmCommodityManage dlgCommodityManage = new FrmCommodityManage();
		dlgCommodityManage.setVisible(true);
	}
	public  FrmCommodityManage() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		//toolBar.add(btnModify);
		toolBar.add(this.btnDelete);
		toolBar.add(btnSearch);
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
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
