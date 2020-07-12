package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IordercontentManager;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class ordercontentManager implements IordercontentManager {

	@Override
	public Beanorder_content add(List<Beancommodity> coms) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beanorder_content> allload(Beanorder_message ord) throws BaseException {
		// TODO Auto-generated method stub
		List<Beanorder_content> result = new ArrayList<Beanorder_content>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from order_content where ord_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, ord.getOrd_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanorder_content p = new Beanorder_content();
				p.setCom_id(rs.getInt(1));
				p.setOrd_id(rs.getInt(2));
				p.setOc_count(rs.getInt(3));
				p.setOc_price(rs.getDouble(4));
				p.setOc_discount(rs.getDouble(5));
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
