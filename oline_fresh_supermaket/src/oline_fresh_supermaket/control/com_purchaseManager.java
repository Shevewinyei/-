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
				p.setArrive_time(rs.getDate(6));
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

	@Override
	public void delete(int purchase_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "delete from Relationship_7 where  purchase_id = ? ";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, purchase_id);
			pst.execute();
			
			sql = "delete from com_purchase where  purchase_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, purchase_id);
			pst.execute();
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

	@Override
	public void add(Beancom_purchase t) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int id = t.getPurchase_id();
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select max(purchase_id) from com_purchase ";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				t.setPurchase_id(rs.getInt(1)+1);
			}else {
				t.setPurchase_id(1);
			}
			
			sql= "insert into com_purchase(admin_id,arrive_time,purchase_count,purchase_id,"
					+ "purchase_state,purchase_time) values (?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, t.getAdmin_id());
			pst.setDate(2, new java.sql.Date(t.getArrive_time().getTime()));
			pst.setInt(3, t.getPurchase_count());
			pst.setInt(4, t.getPurchase_id());
			pst.setString(5, t.getPurchase_state());
			pst.setDate(6, new java.sql.Date(t.getPurchase_time().getTime()));
			pst.execute();
			pst.close();
			
			sql = "insert into Relationship_7(purchase_id,com_id) values (?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, t.getPurchase_id());
			pst.setInt(2, id);
			pst.execute();
			pst.close();
			
			int count;
			sql = "select * from commodity where com_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				count = rs.getInt(7);
			}else {
				throw new BaseException("该商品不存在，请先创建！");
			}
			pst.close();
			
			sql = "update commodity set com_count = ? where com_id = ?";
			pst=conn.prepareStatement(sql);
			count = t.getPurchase_count()+count;
			pst.setInt(1, count);
			pst.setInt(2, id);
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
	}

}
