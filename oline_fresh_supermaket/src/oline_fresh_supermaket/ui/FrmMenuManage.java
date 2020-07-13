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

import oline_fresh_supermaket.model.BeanMenu;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmMenuManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("��Ӳ���");
	private Button btnDelete = new Button("ɾ������");
	private Button btnAddcom = new Button("�����Ʒ");
	private Button btncancel = new Button("�˳�"); 
	//����
	private Object tblTitle[]={"���ױ��","��������","���ײ���","���ײ���"};
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
		FrmMenuManage dlg = new FrmMenuManage();
		dlg.setVisible(true);
	}
	public FrmMenuManage() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnDelete);
		toolBar.add(btnAddcom);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		//��ȡ��������
		this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		
		// ��Ļ������ʾ
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		this.validate();
		
		this.btnAdd.addActionListener(this);
		this.btncancel.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnAddcom.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btncancel) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnAdd) {
			FrmAddmenu dlgAddmenu = new FrmAddmenu();
			dlgAddmenu.setVisible(true);
		}
		else if(e.getSource()==this.btnAddcom){
			
		}
		else if(e.getSource()==this.btnDelete) {
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫɾ������","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanMenu pBeanMenu = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ���ò�����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.menuManager.delete(pBeanMenu.getMen_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}

}
