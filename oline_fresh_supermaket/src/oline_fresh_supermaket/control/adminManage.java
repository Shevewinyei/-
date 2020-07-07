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
		if(userid.isEmpty()) throw new BusinessException("用户名不能为空。");
		if(!pwd.equals(pwd2)||pwd.isEmpty()||pwd2.isEmpty()) throw new BusinessException("两次输入密码必须相同");
		
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Administrator where admin_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				//System.out.println("用户名已存在。");
				throw new BusinessException("用户名已存在。");
				
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
		if(userid.isEmpty()) throw new BusinessException("用户名不能为空！");
		if(pwd.isEmpty()) throw new BusinessException("密码不能为空！");
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Administrator where admin_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				throw new BusinessException("用户名不存在,登陆失败");
			result.setAdmin_id(rs.getInt(1));
			result.setAdmin_name(rs.getString(2));
			result.setAdmin_pwd(rs.getNString(3));
			if(!result.getAdmin_pwd().equals(pwd)) {
				throw new BusinessException("密码错误。");
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
			throw new BusinessException("密码不能为空");
		if(!newPwd.equals(newPwd2)) throw new BusinessException("两次新密码应该保持一致。");
		if(oldPwd.equals(newPwd)) throw new BusinessException("新旧密码不能相同");
		
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Administrator where admin_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, user.getAdmin_id());
			java.sql.ResultSet rs=pst.executeQuery();
			rs.next();
			if(!rs.getString(3).equals(oldPwd)) throw new BusinessException("旧密码输入不正确");
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
