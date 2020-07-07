package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;

import oline_fresh_supermaket.ift.IadminManage;
import oline_fresh_supermaket.model.BeanAdmin;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.BusinessException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class adminManage implements IadminManage {

	@Override
	public BeanAdmin reg(String userid, String pwd, String pwd2) throws BaseException {
		// TODO Auto-generated method stub

		BeanAdmin result = new BeanAdmin();
		if(userid.isEmpty()) throw new BusinessException("�û�������Ϊ�ա�");
		if(!pwd.equals(pwd2)||pwd.isEmpty()||pwd2.isEmpty()) throw new BusinessException("�����������������ͬ");
		
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Administrator where admin_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				//System.out.println("�û����Ѵ��ڡ�");
				throw new BusinessException("�û����Ѵ��ڡ�");
				
			}
			sql = "select max(admin_id) from Administrator";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			rs.next();
			result.setAdmin_id(rs.getInt(1)+1);
			rs.close();
			
			sql="insert into Administrator(admin_id,admin_name,admin_pwd) values (?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, result.getAdmin_id());
			pst.setString(2, userid);
			pst.setString(3, pwd);
			result.setAdmin_name(userid);
			result.setAdmin_pwd(pwd);
			pst.execute();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
		}
		return result;
	}

	@Override
	public BeanAdmin login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		BeanAdmin result = new BeanAdmin();
		if(userid.isEmpty()) throw new BusinessException("�û�������Ϊ�գ�");
		if(pwd.isEmpty()) throw new BusinessException("���벻��Ϊ�գ�");
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Administrator where admin_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				throw new BusinessException("�û���������,��½ʧ��");
			result.setAdmin_id(rs.getInt(1));
			result.setAdmin_name(rs.getString(2));
			result.setAdmin_pwd(rs.getNString(3));
			if(!result.getAdmin_pwd().equals(pwd)) {
				throw new BusinessException("�������");
			}
			pst.close();
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

	@Override
	public void changePwd(BeanAdmin user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(newPwd.isEmpty()||newPwd2.isEmpty()||oldPwd.isEmpty())
			throw new BusinessException("���벻��Ϊ��");
		if(!newPwd.equals(newPwd2)) throw new BusinessException("����������Ӧ�ñ���һ�¡�");
		if(oldPwd.equals(newPwd)) throw new BusinessException("�¾����벻����ͬ");
		
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Administrator where admin_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, user.getAdmin_id());
			java.sql.ResultSet rs=pst.executeQuery();
			rs.next();
			if(!rs.getString(3).equals(oldPwd)) throw new BusinessException("���������벻��ȷ");
			sql = "update Administrator set admin_pwd =  '"+newPwd+"' where admin_id = '"+user.getAdmin_id()+"'";
			java.sql.Statement st = conn.createStatement();
			st.execute(sql);
			rs.close();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
		
}
