package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IcommodityManage;
import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class commodityManage implements IcommodityManage {

	@Override
	public List<Beancommodity> loadcommodity() throws BaseException {
		// TODO Auto-generated method stub
		List<Beancommodity> result = new ArrayList<Beancommodity>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select com_id,com_name,com_price,com_vip_price,"
					+ "com_count,com_specification,com_describe from commodity";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beancommodity p = new Beancommodity();
				p.setCom_id(rs.getInt(1));
				p.setCom_name(rs.getString(2));
				p.setCom_price(rs.getDouble(3));
				p.setCom_vip_price(rs.getDouble(4));
				p.setCom_count(rs.getInt(5));
				p.setCom_specification(rs.getString(6));
				p.setCom_describle(rs.getString(7));
				result.add(p);
			}
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
		return result;
	}

	@Override
	public Beancommodity addcommodity(Beancommodity commodity) throws BaseException {
		// TODO Auto-generated method stub
		Beancommodity result = new Beancommodity();
		Connection conn=null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into commodity(com_id,com_name,com_price,com_vip_price,"
					+ "com_count,com_specification,com_describe) values (?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, commodity.getCom_id());
			pst.setString(2, commodity.getCom_name());
			pst.setDouble(3, commodity.getCom_price());
			pst.setDouble(4, commodity.getCom_vip_price());
			pst.setInt(5, commodity.getCom_count());
			pst.setString(6, commodity.getCom_specification());
			pst.setString(7, commodity.getCom_describle());
			pst.execute();
			pst.close();
			
			result = commodity;
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
	public void deletecommodity(int com_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from commodity where com_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, com_id);
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

	@Override
	public List<Beancommodity> seachcommodity(int comid) throws BaseException {
		// TODO Auto-generated method stub
		List<Beancommodity> result = new ArrayList<Beancommodity>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select com_id,com_name,com_price,com_vip_price,com_count,com_specification,com_describe "
					+ "from commodity where com_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, comid);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beancommodity p = new Beancommodity();
				p.setCom_id(rs.getInt(1));
				p.setCom_name(rs.getString(2));
				p.setCom_price(rs.getDouble(3));
				p.setCom_vip_price(rs.getDouble(4));
				p.setCom_count(rs.getInt(5));
				p.setCom_specification(rs.getString(6));
				p.setCom_describle(rs.getString(7));
				result.add(p);
			}
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
		return result;
	}

}
