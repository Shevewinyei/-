package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.model.BeanMenu;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmMenu extends JFrame implements ActionListener{
	private JPanel toolBar=new JPanel(); 
	private Button btnAdd=new Button("一键加入购物车");
	private Button btnsearch = new Button("查看菜谱内商品");
	private Button btncancel = new Button("退出"); 
	private Object tblTitle[]={"菜谱编号","菜谱名称","菜谱材料","菜谱步骤"};
	private Object tblData[][];
	List<BeanMenu> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			pubs = oline_fresh_supermaketUtil.menuManager.allload();
			tblData =new Object[pubs.size()][4];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getMen_id();
				tblData[i][1]=pubs.get(i).getMen_name();
				tblData[i][2]=pubs.get(i).getMen_material();
				tblData[i][3]=pubs.get(i).getMen_step();
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
		FrmMenu dlg = new FrmMenu();
		dlg.setVisible(true);
	}
	public FrmMenu() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnsearch);
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
		this.btncancel.addActionListener(this);
		this.btnsearch.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.btncancel) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnAdd) {
			//添加入购物车（count = 1）
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要添加的菜谱","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanMenu pBeanMenu = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定加商品进购物车吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					List<Beancommodity> p = oline_fresh_supermaketUtil.menuManager.addBuyCar(pBeanMenu);
					Frm_BuyCar dlg = new Frm_BuyCar(p);
					dlg.setVisible(true);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if (e.getSource()==this.btnsearch) {
			//查看菜谱内商品
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要查看的菜谱","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanMenu pBeanMenu = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定查看吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					List<Beancommodity> p = oline_fresh_supermaketUtil.menuManager.addBuyCar(pBeanMenu);
					FrmMenushow dlg = new FrmMenushow(p);
					dlg.setVisible(true);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
	
}
