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

import oline_fresh_supermaket.control.addrManager;
import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.Beanaddress;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmAddressManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel toolBar1 = new JPanel();
	private Button btnAdd = new Button("��ӵ�ַ");
	private Button btnDelete = new Button("ɾ����ַ");   //���
	private Button btncancel = new Button("�˳�");  
	private Button btnModity = new Button("�޸�ʡ");
	private Button btnModity1 = new Button("�޸���");
	private Button btnModity2 = new Button("�޸���");
	private Button btnModity3 = new Button("�޸ľ����ַ");
	private JTextField edtKeyword = new JTextField(20);
	private Object tblTitle[]={"��ַ���","ʡ","��","��","�����ַ"};
	private Object tblData[][];
	List<Beanaddress> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			pubs = (new addrManager().loadall(Beanuser.currentLoginUser.getUsr_id()));
			tblData =new Object[pubs.size()][5];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getAddr_id()+"";
				tblData[i][1]=pubs.get(i).getAddr_pro();
				tblData[i][2]=pubs.get(i).getAddr_city();
				tblData[i][3]=pubs.get(i).getAddr_area();
				tblData[i][4]=pubs.get(i).getAddr_current();
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
		FrmAddressManage dlg = new FrmAddressManage();
		dlg.setVisible(true);
	}
	public FrmAddressManage() {
		// TODO Auto-generated constructor stub
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(this.btnDelete);
		toolBar.add(this.btncancel);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar1.add(edtKeyword);
		toolBar1.add(btnModity);
		toolBar1.add(btnModity1);
		toolBar1.add(btnModity2);
		toolBar1.add(btnModity3);
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
		this.btnDelete.addActionListener(this);
		this.btncancel.addActionListener(this);
		this.btnModity.addActionListener(this);
		this.btnModity1.addActionListener(this);
		this.btnModity2.addActionListener(this);
		this.btnModity3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btncancel) {
			this.setVisible(false);
		}else if(e.getSource()==this.btnAdd) {
			Frm_AddAddress dlg = new Frm_AddAddress();
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.btnDelete){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���ַ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanaddress p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.addrManager.deleteAddress(p.getAddr_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity) {
			//�޸�ʡ
			String string = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵĵ�ַ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanaddress p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸ĸõ�ַ��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.addrManager.Modity(p.getAddr_id(),string);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity1) {
			//�޸���
			String string = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵĵ�ַ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanaddress p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸ĸõ�ַ��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.addrManager.Modity1(p.getAddr_id(),string);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity2) {
			//�޸���
			String string = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵĵ�ַ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanaddress p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸ĸõ�ַ��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.addrManager.Modity2(p.getAddr_id(),string);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity3) {
			//�޸ľ����ַ
			String string = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵĵ�ַ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beanaddress p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸ĸõ�ַ��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.addrManager.Modity3(p.getAddr_id(),string);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}

}
