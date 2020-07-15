package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.addrManager;
import oline_fresh_supermaket.control.ordercontentManager;
import oline_fresh_supermaket.model.BeanSearch;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmSearchView extends JFrame{
	private Object tblTitle[]={"商品名称","购买次数","销量"};
	private Object tblData[][];
	List<Beancommodity> coms;
	List<Beancommodity> names;
	List<BeanSearch> sum; //次数
	List<BeanSearch> count; //数量
	//List<BeanSearch> pubs = new ArrayList<BeanSearch>();
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			coms = oline_fresh_supermaketUtil.ordercontentManager.selectComs();
			names = oline_fresh_supermaketUtil.comManager.selectName(coms);
			sum = oline_fresh_supermaketUtil.ordercontentManager.selectSum(coms);
			count = oline_fresh_supermaketUtil.ordercontentManager.selectCount(coms);
			tblData =new Object[coms.size()][3];
			for(int i=0;i<coms.size();i++){
				tblData[i][0]=names.get(i).getCom_name();
				tblData[i][1]=sum.get(i).getSum();
				tblData[i][2]=count.get(i).getCount();
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
		FrmSearchView dlgFrmSearchView = new FrmSearchView();
		dlgFrmSearchView.setVisible(true);
	}
	public FrmSearchView() {
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
	}
}
