package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.Beanaddress;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class Frm_BuyCar extends JFrame implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel endJPanel = new JPanel();
	private static Beanaddress pBeanaddress = new Beanaddress();
	private JLabel Addrcurrent;     //当前地址
	private JLabel finalprice;	    //合计价格（优惠后价格）
	private JLabel discountprice;   //优惠价格
	private Button btnSetAddress = new Button("修改当前地址");
	private Button btnok = new Button("确认订单");
	private Button btnDelete = new Button("删除商品");
	private Button btncancel = new Button("退出");
	private static List<Beancommodity> coms ;
	private double price;
	private double discount;
	private static String addrString ;
	private Object tblTitle[]={"商品编号","商品名称","商品价格","商品vip价格","商品数量","商品规格","商品描述"};
	private Object tblData[][];
	List<Beancommodity> pubs = new ArrayList<Beancommodity>();
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
	
//	public static void main(String[] args) {
//		Frm_BuyCar dlg = new Frm_BuyCar();
//		dlg.setVisible(true);
//	}
	public Frm_BuyCar(List<Beancommodity> table) {
		// TODO Auto-generated constructor stub
		coms = table;
		if(Beanuser.currentLoginUser.isUsr_isvip()) {
			for (int i = 0; i < coms.size(); i++) {
				if(coms.get(i).getCom_vip_price() == 0) 
					price = price + coms.get(i).getCom_price()*coms.get(i).getCom_count();
				else 
					price = price + coms.get(i).getCom_vip_price()*coms.get(i).getCom_count();
			}
		}
		else {
			for (int i = 0; i < coms.size(); i++) {
				price = price + coms.get(i).getCom_price()*coms.get(i).getCom_count();
			}
		}
		for (int i = 0; i < coms.size(); i++) {
			boolean p = false;
			try {
				p = oline_fresh_supermaketUtil.FDManager.isFDcom(coms.get(i).getCom_id(),coms.get(i).getCom_count());
			} catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(p) {
				double t = 0;
				try {
					t = oline_fresh_supermaketUtil.FDManager.discount_price(coms.get(i).getCom_id());
				} catch (BaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				discount = price*(1-t);
			}
		}
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		Addrcurrent = new JLabel("地址："+addrString);
		toolBar.add(Addrcurrent);
		toolBar.add(btnSetAddress);
		toolBar.add(this.btnDelete);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		endJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		finalprice = new JLabel("合计："+new java.text.DecimalFormat("#.00").format(price-discount));
		endJPanel.add(finalprice);
		discountprice = new JLabel("优惠："+new java.text.DecimalFormat("#.00").format(discount));
		endJPanel.add(discountprice);
		endJPanel.add(btnok);
		this.getContentPane().add(endJPanel,BorderLayout.SOUTH);
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
		
		this.btnDelete.addActionListener(this);
		this.btncancel.addActionListener(this);
		this.btnSetAddress.addActionListener(this);
		this.btnok.addActionListener(this);
	}
	public Frm_BuyCar(Beanaddress p) {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		addrString = p.getAddr_pro()+p.getAddr_city()+p.getAddr_area()+p.getAddr_current();
		Addrcurrent = new JLabel("地址：" + addrString);
		toolBar.add(Addrcurrent);
		toolBar.add(btnSetAddress);
		toolBar.add(this.btnDelete);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		endJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		finalprice = new JLabel("合计：");
		endJPanel.add(finalprice);
		discountprice = new JLabel("优惠：");
		endJPanel.add(discountprice);
		endJPanel.add(btnok);
		this.getContentPane().add(endJPanel,BorderLayout.SOUTH);
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
		
		this.btnDelete.addActionListener(this);
		this.btncancel.addActionListener(this);
		this.btnSetAddress.addActionListener(this);
		this.btnok.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btncancel) {
			this.setVisible(false);
		}
		else if(e.getSource()== this.btnDelete) {
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择商品","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beancommodity p =  this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定删除"+p.getCom_name()+"吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				Iterator<Beancommodity> iter = coms.iterator();
				while (iter.hasNext()) {
					Beancommodity item = iter.next();
				    if (item.equals(p)) {
				        iter.remove();
				    }
				}
				this.reloadTable();
			}
				
		}
		else if(e.getSource()==this.btnSetAddress){
			this.setVisible(false);
			FrmchoseAddress dlg = new FrmchoseAddress();
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.btnok) {
			if(addrString.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请选择送货地址！");
			}
			Beanorder_message p = new Beanorder_message();
			p.setOrd_startprice(price);
			p.setOrd_endprice(price-discount);
			p.setOrd_time(new java.sql.Date(System.currentTimeMillis()));
			FrmCouponChose dlg = new FrmCouponChose(p,coms);
			dlg.setVisible(true);
			this.setVisible(false);
		//	Beanorder_content = oline_fresh_supermaketUtil.ordercontentManager.add(coms);
		}
	}

}
