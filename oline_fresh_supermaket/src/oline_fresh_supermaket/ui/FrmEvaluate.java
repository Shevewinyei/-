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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.addrManager;
import oline_fresh_supermaket.model.Beanevaluate;
import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmEvaluate extends JFrame implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel toolBar1 = new JPanel();
	private Button btnAdd = new Button("添加评价");
	private Button btnDelete = new Button("删除评价");   //添加
	private Button btncancel = new Button("退出");  
	private Button btnModity = new Button("修改评价内容");
	private Button btnModity1 = new Button("修改星级");
	private JTextField edtKeyword = new JTextField(20);
	int id;
	private Object tblTitle[]={"评价编号","评价内容","星级","评价时间"};
	private Object tblData[][];
	List<Beanevaluate> pubs = new ArrayList<Beanevaluate>();
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		tblData =new Object[pubs.size()][4];
		for(int i=0;i<pubs.size();i++){
			tblData[i][0]=pubs.get(i).getEva_order();
			tblData[i][1]=pubs.get(i).getEva_content();
			tblData[i][2]=pubs.get(i).getEva_star();
			tblData[i][3]=pubs.get(i).getEva_date();
		}
		tablmod.setDataVector(tblData,tblTitle);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
	public FrmEvaluate(int ord_id) {
		id = ord_id;
		// TODO Auto-generated constructor stub
		try {
			pubs = oline_fresh_supermaketUtil.evaluateManager.load(ord_id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(this.btnDelete);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar1.add(edtKeyword);
		toolBar1.add(btnModity);
		toolBar1.add(btnModity1);
		this.getContentPane().add(toolBar1, BorderLayout.SOUTH);
		
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
		this.btnModity.addActionListener(this);
		this.btnModity1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.btnAdd) {
			FrmAddEva dlgAddEva = new FrmAddEva(id);
			dlgAddEva.setVisible(true);
			this.reloadTable();
		}
		else if(e.getSource()==this.btncancel) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnDelete) {
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要删除的评价","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanevaluate p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定删除吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.evaluateManager.delete(p.getEva_order());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(e.getSource()==this.btnModity) {
			//修改内容
			String content = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要修改的评价","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanevaluate p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定修改吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.evaluateManager.ModifyContent(p.getEva_order(),content);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(e.getSource()==this.btnModity1) {
			//修改星级
			String star = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择要修改的评价","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanevaluate p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"确定修改吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.evaluateManager.ModifyStar(p.getEva_order(),star);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
