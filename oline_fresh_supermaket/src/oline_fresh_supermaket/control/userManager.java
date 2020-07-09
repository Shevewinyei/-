package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;

import oline_fresh_supermaket.ift.IuserManager;
import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.BusinessException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class userManager implements IuserManager {

	@Override
	public Beanuser login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Beanuser result =new Beanuser();
		if(userid.isEmpty()) throw new BusinessException("用户名不能为空！");
		if(pwd.isEmpty()) throw new BusinessException("密码不能为空！");
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from user where usr_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				throw new BusinessException("用户名不存在,登陆失败");
			result.setUsr_id(rs.getInt(1));
			result.setUsr_name(rs.getString(2));
			result.setUsr_gender(rs.getNString(3));
			result.setUsr_pwd(rs.getString(4));
			result.setUsr_phonenumber(rs.getString(5));
			result.setUsr_city(rs.getString(6));
			result.setUsr_registration_time(rs.getDate(7));
			result.setUsr_isvip(rs.getBoolean(8));
			result.setUsr_vip_ddl(rs.getDate(9));
			if(!result.getUsr_pwd().equals(pwd)) {
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

}
