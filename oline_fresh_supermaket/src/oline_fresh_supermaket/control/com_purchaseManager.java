package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.Icom_purchaseManager;
import oline_fresh_supermaket.model.BeanAdmin;
import oline_fresh_supermaket.model.Beancom_purchase;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class com_purchaseManager implements Icom_purchaseManager {

	@Override
	public List<Beancom_purchase> allload() throws BaseException {
		// TODO Auto-generated method stub
		List<Beancom_purchase> result = new ArrayList<Beancom_purchase>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from com_purchase where admin_id = ? ";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, BeanAdmin.currentLoginAdmin.getAdmin_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beancom_purchase p = new Beancom_purchase();
				p.setPurchase_id(rs.getInt(1));
				p.setPurchase_count(rs.getInt(3));
				p.setPurchase_state(rs.getString(4));
				p.setPurchase_time(rs.getDate(5));
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
