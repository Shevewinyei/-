package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.model.Beancoupon;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmCoupon extends JDialog{
	private Object tblTitle[]= {"优惠券编号","内容","适用金额","减免金额","起始日期","结束日期"};
	private Object tblData[][];
	List<Beancoupon> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			pubs = oline_fresh_supermaketUtil.couponManager.allload();
			tblData =new Object[pubs.size()][6];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getCou_id()+"";
				tblData[i][1]=pubs.get(i).getCou_content();
				tblData[i][2]=pubs.get(i).getCou_abl_price();
				tblData[i][3]=pubs.get(i).getCou_redu_price();
				tblData[i][4]=pubs.get(i).getCou_starttime();
				tblData[i][5]=pubs.get(i).getCou_enddate();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public FrmCoupon() {
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
