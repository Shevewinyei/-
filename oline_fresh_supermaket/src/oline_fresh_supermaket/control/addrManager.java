package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IaddressManager;
import oline_fresh_supermaket.model.Beanaddress;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class addrManager implements IaddressManager {

	@Override
	public List<Beanaddress> loadall(int userid) throws BaseException {
		// TODO Auto-generated method stub
		List<Beanaddress> result = new ArrayList<Beanaddress>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from address where usr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanaddress p = new Beanaddress();
				p.setAddr_id(rs.getInt(1));
				p.setUsr_id(rs.getInt(2));
				p.setAddr_pro(rs.getString(3));
				p.setAddr_city(rs.getString(4));
				p.setAddr_area(rs.getString(5));
				p.setAddr_current(rs.getString(6));
				result.add(p);
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
