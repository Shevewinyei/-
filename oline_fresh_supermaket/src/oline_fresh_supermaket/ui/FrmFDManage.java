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

import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.model.BeanFD_com_connect;
import oline_fresh_supermaket.model.BeanFull_discount;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmFDManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel toolBar1 = new JPanel();
	private Button btnAdd = new Button("��������Ż�");
	private Button btnModity = new Button("�޸���Ʒ����");
	private Button btnModity1 = new Button("�޸��ۿ�");
	private Button btnModity2 = new Button("�޸�����");
	private JTextField edtKeyword = new JTextField(20);
	private Button btnAddcom = new Button("�����������Ʒ");
	private Button btnDelete = new Button("ɾ������");
	private Button btncancel = new Button("�˳�"); 
	private Object tblTitle[]={"���۱��","��������","�ﵽ���۵���Ʒ����","�����ۿ�","���ۿ�ʼʱ��","���۽���ʱ��"};
	private Object tblData[][];
	List<BeanFull_discount> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable() {
		try {
			pubs = oline_fresh_supermaketUtil.FDManager.loadFD();
			tblData =new Object[pubs.size()][6];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getFD_id();
				tblData[i][1]=pubs.get(i).getFD_content();
				tblData[i][2]=pubs.get(i).getFD_com_count();
				tblData[i][3]=pubs.get(i).getFD_discount();
				tblData[i][4]=pubs.get(i).getFD_startdate();
				tblData[i][5]=pubs.get(i).getFD_enddate();
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
		FrmFDManage dlg = new FrmFDManage();
		dlg.setVisible(true);
	}
	public FrmFDManage() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnAddcom);
		toolBar.add(btnDelete);
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
		this.btnAddcom.addActionListener(this);
		this.btncancel.addActionListener(this);
		this.btnDelete.addActionListener(this);
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
		else if(e.getSource()==this.btnDelete){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫɾ���Ż�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFull_discount p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ�����Ż���","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.FDManager.delete(p.getFD_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnAddcom){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���ۿ�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFull_discount p = this.pubs.get(i);
			FrmAddFD_com dlg = new FrmAddFD_com(p);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.btnAdd) {
			FrmAddFD dlg = new FrmAddFD();
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.btnModity) {
			//�޸�����
			int count = Integer.parseInt(edtKeyword.getText());
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸ĵ��Ż�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFull_discount p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸���","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.FDManager.Modity(p.getFD_id(),count);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if (e.getSource()==this.btnModity1) {
			//�޸��ۿ�
			double discount = Double.parseDouble(edtKeyword.getText());
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸��Ż�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFull_discount p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸�����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.FDManager.Modity1(p.getFD_id(),discount);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if (e.getSource()==this.btnModity2) {
			//�޸�����
			String content = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸��Ż�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFull_discount p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸�����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.FDManager.Modity2(p.getFD_id(),content);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
				
	}

}
