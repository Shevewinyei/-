package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IordermessageManager;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class ordermessageManager implements IordermessageManager {

	@Override
	public Beanorder_message add(List<Beancommodity> coms) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beanorder_message> allload() throws BaseException {
		// TODO Auto-generated method stub
		List<Beanorder_message> result = new ArrayList<Beanorder_message>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from order_message where ord_id = (select ord_id from Relationship_2 where usr_id = ?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, Beanuser.currentLoginUser.getUsr_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanorder_message p = new Beanorder_message();
				p.setOrd_id(rs.getInt(1));
				p.setOrd_startprice(rs.getDouble(2));
				p.setOrd_endprice(rs.getDouble(3));
				p.setOrd_time(rs.getTime(4));
				p.setOrd_state(rs.getString(5));
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
