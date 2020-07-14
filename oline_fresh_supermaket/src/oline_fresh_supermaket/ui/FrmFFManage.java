package oline_fresh_supermaket.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import oline_fresh_supermaket.control.FFManage;
import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;

public class FrmFFManage extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel toolBar1 = new JPanel();
	//���
	private Button btnAdd = new Button("����������");
	private Button btnModify = new Button("�޸��������");
	private Button btnModify1 = new Button("�޸��������");
	private JTextField edtKeyword1 = new JTextField(10);
	private Button btnDelete = new Button("ɾ���������");
	private Button btnSearch = new Button("��ѯ�������");  
	private Button cancelButton =  new Button("�˳�");
	private Button refreshButton =  new Button("ˢ��");
	private JTextField edtKeyword = new JTextField(10);
	private Object tblTitle[]={"���ʱ��","��������","��������"};
	private Object tblData[][];
	List<BeanFF> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			pubs=(new FFManage()).loadall();
			tblData =new Object[pubs.size()][3];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getFF_id()+"";
				tblData[i][1]=pubs.get(i).getFF_name();
				tblData[i][2]=pubs.get(i).getFF_describle();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void reloadTable(List<BeanFF> pubs) {
		tblData =new Object[pubs.size()][3];
		for(int i=0;i<pubs.size();i++){
			tblData[i][0]=pubs.get(i).getFF_id()+"";
			tblData[i][1]=pubs.get(i).getFF_name();
			tblData[i][2]=pubs.get(i).getFF_describle();
		}
		tablmod.setDataVector(tblData,tblTitle);
		this.dataTable.validate();
		this.dataTable.repaint();
		
	}
	
	public static void main(String[] args) {
		FrmFFManage aa = new FrmFFManage();
		aa.setVisible(true);
	}
	public  FrmFFManage() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(this.btnDelete);
		toolBar.add(edtKeyword);
		toolBar.add(btnSearch);
		toolBar.add(this.cancelButton);
		toolBar.add(this.refreshButton);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar1.add(edtKeyword1);
		toolBar1.add(btnModify);
		toolBar1.add(btnModify1);
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
		this.btnModify.addActionListener(this);
		this.btnModify1.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.cancelButton.addActionListener(this);
		this.btnSearch.addActionListener(this);
		this.refreshButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnAdd) {
			FrmAddFF dlgAddFF = new FrmAddFF();
			dlgAddFF.setVisible(true);
		}
		else if(e.getSource()==this.btnDelete){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���������","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFF p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ��"+p.getFF_name()+"��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					(new FFManage()).deleteFF(p.getFF_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.cancelButton){
			this.setVisible(false);
		}
		else if (e.getSource()==this.btnSearch) {
			int FFid;
			String ffid = edtKeyword.getText();
			if(ffid.isEmpty()) {
				FFid = 0;
			}else {
				FFid = Integer.parseInt(ffid);
			}
			try {
				this.pubs = oline_fresh_supermaketUtil.FFManager.searchFF(FFid);
				//if(pubs==null) throw new BaseException("��Ų�����");
				this.reloadTable(pubs);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		else if (e.getSource()==this.refreshButton) {
			this.reloadTable();
		}
		else if(e.getSource()==this.btnModify) {
			String s = edtKeyword1.getText();
			if(s.isEmpty()) {
				JOptionPane.showMessageDialog(null,  "δ�������","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���������","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFF p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸���","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.FFManager.Modify(p,s);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnModify1){
			String s = edtKeyword1.getText();
			if(s.isEmpty()) {
				JOptionPane.showMessageDialog(null,  "δ�������","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���������","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			BeanFF p = this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ���޸���","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					oline_fresh_supermaketUtil.FFManager.Modify1(p,s);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
}
