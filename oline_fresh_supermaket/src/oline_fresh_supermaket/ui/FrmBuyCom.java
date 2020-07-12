package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmBuyCom  extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static List<Beancommodity> table = new ArrayList<Beancommodity>();  
	int count;
	private JMenuBar menubar=new JMenuBar(); 
	private JMenu menu_buy=new JMenu("购买管理");
    private JMenu menu_more=new JMenu("更多");
    
    private JMenuItem  menuItem_Add = new JMenuItem("加入购物车");
    private JMenuItem menu_buycar = new JMenuItem("查看购物车");
	/**
	 * 主函数测试
	 * @param args
	 */
	public static void main(String[] args) {
		FrmBuyCom dlgBuyCom = new FrmBuyCom();
		dlgBuyCom.setVisible(true);
	}
	private Object tblFFTitle[]= BeanFF.tableTitles;
	private Object tblFFData[][];
	DefaultTableModel tabFFModel=new DefaultTableModel();
	private JTable dataTableFF=new JTable(tabFFModel);
	
	private Object tblComTitle[]=Beancommodity.tbltitle;
	private Object tblComData[][];
	DefaultTableModel tabComModel=new DefaultTableModel();
	private JTable dataTableCom=new JTable(tabComModel);
	
	private BeanFF curFF=null;
	List<BeanFF> allFF=null;
	List<Beancommodity> coms=null;
	private void reloadPlanTable(){
		try {
			allFF=oline_fresh_supermaketUtil.FFManager.loadall();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblFFData =  new Object[allFF.size()][BeanFF.tableTitles.length];
		for(int i=0;i<allFF.size();i++){
			for(int j=0;j<BeanFF.tableTitles.length;j++)
				tblFFData[i][j]=allFF.get(i).getCell(j);
		}
		tabFFModel.setDataVector(tblFFData,tblFFTitle);
		this.dataTableFF.validate();
		this.dataTableFF.repaint();
	}
	private void reloadPlanStepTabel(int planIdx){
		if(planIdx<0) return;
		curFF=allFF.get(planIdx);
		try {
			coms=oline_fresh_supermaketUtil.comManager.loadall(curFF);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblComData =new Object[coms.size()][Beancommodity.tbltitle.length];
		for(int i=0;i<coms.size();i++){
			for(int j=0;j<Beancommodity.tbltitle.length;j++)
				tblComData[i][j]=coms.get(i).getCell(j);
		}
		
		tabComModel.setDataVector(tblComData,tblComTitle);
		this.dataTableCom.validate();
		this.dataTableCom.repaint();
	}
	public FrmBuyCom() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("商品表");
		menubar.add(menu_buy);
		menubar.add(menu_more);
		
		this.menu_buy.add(this.menuItem_Add);
		this.menuItem_Add.addActionListener(this);
		this.menu_buy.add(this.menu_buycar);
		this.menu_buycar.addActionListener(this);
		this.setJMenuBar(menubar);
	    
		this.getContentPane().add(new JScrollPane(this.dataTableFF), BorderLayout.WEST);
	    this.dataTableFF.addMouseListener(new MouseAdapter (){
	    	
	    	@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmBuyCom.this.dataTableFF.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmBuyCom.this.reloadPlanStepTabel(i);
			}
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTableCom), BorderLayout.CENTER);
	    
	    this.reloadPlanTable();
	}
	public void add(Beancommodity com, int count) {
		// TODO Auto-generated constructor stub
		com.setCom_count(count);
		{this.table.add(com);}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.menuItem_Add) {
			int i = FrmBuyCom.this.dataTableCom.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "请选择商品", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Frm_addcom dlg = new Frm_addcom(this.coms.get(i));
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menu_buycar) {
			Frm_BuyCar dlg = new Frm_BuyCar(table);
			dlg.setVisible(true);
		}
	}

}
