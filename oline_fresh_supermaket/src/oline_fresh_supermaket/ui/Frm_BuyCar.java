package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.util.BaseException;

public class Frm_BuyCar extends JFrame implements ActionListener {
	private JPanel toolBar = new JPanel();
	private Button btnok = new Button("确认订单");
	private Button btnDelete = new Button("删除商品");
	private Button btncancel = new Button("退出");
	private static List<Beancommodity> coms;
	private Object tblTitle[]={"商品编号","商品名称","商品价格","商品vip价格","商品数量","商品规格","商品描述"};
	private Object tblData[][];
	List<Beancommodity> pubs = null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		pubs = coms;
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
		Frm_BuyCar dlg = new Frm_BuyCar();
		dlg.setVisible(true);
	}
	public Frm_BuyCar(List<Beancommodity> table) {
		// TODO Auto-generated constructor stub
		coms = table;
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnok);
		toolBar.add(this.btnDelete);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		//this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
	
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		this.validate();
		
		this.btnDelete.addActionListener(this);
		this.btncancel.addActionListener(this);
	}
	public Frm_BuyCar() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnok);
		toolBar.add(this.btnDelete);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		//this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
	
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		this.validate();
		
		this.btnok.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btncancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btncancel) {
			this.setVisible(false);
		}
	}

}
