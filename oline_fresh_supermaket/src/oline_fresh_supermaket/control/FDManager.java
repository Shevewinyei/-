package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IFDManager;
import oline_fresh_supermaket.model.BeanFull_discount;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class FDManager implements IFDManager {

	@Override
	public List<BeanFull_discount> loadFD() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanFull_discount> result = new  ArrayList<BeanFull_discount>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from Full_discount";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				BeanFull_discount p = new BeanFull_discount();
				p.setFD_id(rs.getInt(1));
				p.setFD_content(rs.getString(2));
				p.setFD_com_count(rs.getInt(3));
				p.setFD_discount(rs.getDouble(4));
				p.setFD_startdate(rs.getDate(5));
				p.setFD_enddate(rs.getDate(6));
				result.add(p);
			}
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
