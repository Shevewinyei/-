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
		return null;
	}

	@Override
	public BeanAdmin login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		BeanAdmin result = new BeanAdmin();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Administrator where admin_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				throw new BusinessException("ÓÃ»§Ãû²»´æÔÚ,µÇÂ½Ê§°Ü");
			result.setAdmin_id(rs.getInt(1));
			result.setAdmin_name(rs.getString(2));
			if(!result.getAdmin_pwd().equals(pwd)) {
				throw new BusinessException("ÃÜÂë´íÎó¡£");
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
		
	}
		
}
