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

import oline_fresh_supermaket.model.Beancoupon;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmCouponManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel toolBar1 = new JPanel();
	private Button btnAdd = new Button("����Ż�ȯ");
	private Button btnDelete = new Button("ɾ���Ż�ȯ");
	private Button btnModity = new Button("�޸��Ż�����");
	private Button btnModity1 = new Button("�޸����ý��");
	private Button btnModity2 = new Button("�޸ļ�����");
	private JTextField edtKeyword = new JTextField(20);
	private Button btncancel = new Button("�˳�");  
	private Object tblTitle[]= {"�Ż�ȯ���","����","���ý��","������","��ʼ����","��������"};
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
	public static void main(String[] args) {
		FrmCouponManage dlgCouponManage = new FrmCouponManage();
		dlgCouponManage.setVisible(true);
	}
	public FrmCouponManage() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(this.btnDelete);
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
		this.btnDelete.addActionListener(this);
		this.btncancel.addActionListener(this);
		this.btnModity.addActionListener(this);
		this.btnModity1.addActionListener(this);
		this.btnModity2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btncancel) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnAdd){
			FrmAddcoupon dlgAddcoupon = new FrmAddcoupon();
			dlgAddcoupon.setVisible(true);
		}
		else if(e.getSource()==this.btnDelete) {
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫɾ�����Ż�ȯ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beancoupon p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ����","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.couponManager.deleteCou(p.getCou_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity) {
			//�޸�����
			String content = edtKeyword.getText();
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸��Ż�ȯ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beancoupon p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸���","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.couponManager.Modity(p.getCou_id(),content);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity1) {
			//�޸����ý��
			double price = Double.parseDouble(edtKeyword.getText());
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸��Ż�ȯ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beancoupon p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸���","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.couponManager.Modity1(p.getCou_id(),price);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModity2) {
			//�޸ļ�����
			double price = Double.parseDouble(edtKeyword.getText());
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ��Ҫ�޸��Ż�ȯ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Beancoupon p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸���","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.couponManager.Modity2(p.getCou_id(),price);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}

}
