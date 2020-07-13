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

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beancoupon;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmCouponChose extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Beanorder_message message;
	private List<Beancommodity> table;
	private Button btnchose = new Button("选择优惠券");
	private Button btn_no_chose = new Button("不使用优惠券");
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
	public FrmCouponChose(Beanorder_message p, List<Beancommodity> coms) {
		message = p;
		table = coms;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btn_no_chose);
		toolBar.add(btnchose);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
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
		
		this.btn_no_chose.addActionListener(this);
		this.btnchose.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnchose) {
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要使用的优惠券","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beancoupon p = this.pubs.get(i);
			if(p.getCou_abl_price()>message.getOrd_endprice()) {
				JOptionPane.showMessageDialog(null,  "未达到优惠券的适用金额。","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				message.setOrd_endprice(message.getOrd_endprice()-p.getCou_redu_price());
			}
			if(JOptionPane.showConfirmDialog(this,"确定使用吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					Beanorder_message ord = oline_fresh_supermaketUtil.ordermessageManager.AddOrder(message);
					oline_fresh_supermaketUtil.ordercontentManager.add(table,ord.getOrd_id());
					oline_fresh_supermaketUtil.comManager.update(table);
					this.setVisible(false);
				}catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		
		}
		else if (e.getSource() == btn_no_chose) {
			Beanorder_message ord;
			try {
				ord = oline_fresh_supermaketUtil.ordermessageManager.AddOrder(message);
				oline_fresh_supermaketUtil.ordercontentManager.add(table,ord.getOrd_id());
				oline_fresh_supermaketUtil.comManager.update(table);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
	}
	
}
