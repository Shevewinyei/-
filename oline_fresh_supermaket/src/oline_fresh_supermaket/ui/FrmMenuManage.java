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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.model.BeanMenu;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmMenuManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel toolBar1 = new JPanel();
	private Button btnAdd = new Button("��Ӳ���");
	private Button btnDelete = new Button("ɾ������");
	private Button btnAddcom = new Button("�����Ʒ");
	private Button btnModity = new Button("�޸Ĳ�������");
	private Button btnModity1 = new Button("�޸Ĳ��ײ���");
	private Button btnModity2 = new Button("�޸Ĳ��ײ���");
	private JTextField edtKeyword = new JTextField(20);
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
		toolBar1.add(edtKeyword);
		toolBar1.add(btnModity);
		toolBar1.add(btnModity1);
		toolBar1.add(btnModity2);
		this.getContentPane().add(toolBar1, BorderLayout.SOUTH);
		
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
		this.btnModity.addActionListener(this);
		this.btnModity1.addActionListener(this);
		this.btnModity2.addActionListener(this);
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
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�����Ʒ�Ĳ���","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanMenu pBeanMenu = this.pubs.get(i);
			FrmAddMenu_com dlg = new FrmAddMenu_com(pBeanMenu.getMen_id());
			dlg.setVisible(true);
			this.reloadTable();
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
		else if(e.getSource()==this.btnModity) {
			//�޸Ĳ�������
			String string = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵĲ���","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanMenu pBeanMenu = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸ĸò�����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.menuManager.Modity(pBeanMenu.getMen_id(),string);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity1) {
			//�޸Ĳ��ײ���
			String string = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵĲ���","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanMenu pBeanMenu = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸ĸò�����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.menuManager.Modity1(pBeanMenu.getMen_id(),string);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity2) {	
			//�޸Ĳ��ײ���
			String string = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵĲ���","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanMenu pBeanMenu = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸ĸò�����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.menuManager.Modity2(pBeanMenu.getMen_id(),string);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		
	}

}
