package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.LDManager;
import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanlimit_discount;
import oline_fresh_supermaket.util.BaseException;

public class FrmLDManage  extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加促销商品");
	private Button btnDelete = new Button("删除促销商品");
	private Button btncancel = new Button("退出");  
	private Object tblTitle[]= {"商品名称","促销价格","促销数量","促销开始时间","促销结束时间"};
	private Object tblData[][];
	List<Beancommodity> pubs;
	List<Beanlimit_discount> pubs2;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			pubs = (new commodityManage().loadall(3100));
			pubs2 = (new LDManager().loadall());
			tblData =new Object[pubs2.size()][5];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getCom_name();
			}
			for(int i=0;i<pubs2.size();i++){
				tblData[i][1]=pubs2.get(i).getLD_price();
				tblData[i][2]=pubs2.get(i).getLD_count();
				tblData[i][3]=pubs2.get(i).getLD_starttime();
				tblData[i][4]=pubs2.get(i).getLD_enddate();
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
		FrmLDManage dLdManage = new FrmLDManage();
		dLdManage.setVisible(true);
	}
	public FrmLDManage() {
		// TODO Auto-generated constructor stub
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(this.btnDelete);
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
		this.btnDelete.addActionListener(this);
		this.btncancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btncancel) {
			this.setVisible(false);
		}else if(e.getSource()==this.btnAdd) {
			this.setVisible(false);
			FrmAddLD dlg = new FrmAddLD();
			dlg.setVisible(true);
			
		}
	}

}
