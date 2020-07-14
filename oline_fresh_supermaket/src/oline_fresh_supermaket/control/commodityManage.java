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
		if(commodity.getCom_id()>=100) throw new BaseException("输入商品编号必须大于100！");
		Connection conn=null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from FF where FF_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, commodity.getFF_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BaseException("该商品类型不存在。请先创建新的商品类型。");
			rs.close();
			
			sql = "insert into commodity(com_id,FF_id,com_name,com_price,com_vip_price,"
					+ "com_count,com_specification,com_describe) values (?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, commodity.getCom_id());
			pst.setInt(2, commodity.getFF_id());
			pst.setString(3, commodity.getCom_name());
			pst.setDouble(4, commodity.getCom_price());
			pst.setDouble(5, commodity.getCom_vip_price());
			pst.setInt(6, commodity.getCom_count());
			pst.setString(7, commodity.getCom_specification());
			pst.setString(8, commodity.getCom_describle());
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
	public Beancommodity seachcommodity(int comid) throws BaseException {
		// TODO Auto-generated method stub
		Beancommodity result = new Beancommodity();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select com_id,com_name,com_price,com_vip_price,com_count,com_specification,com_describe "
					+ "from commodity where com_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, comid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BaseException("查询失败，无该编号商品!");
			else{
				result.setCom_id(rs.getInt(1));
				result.setCom_name(rs.getString(2));
				result.setCom_price(rs.getDouble(3));
				result.setCom_vip_price(rs.getDouble(4));
				result.setCom_count(rs.getInt(5));
				result.setCom_specification(rs.getString(6));
				result.setCom_describle(rs.getString(7));
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
	public List<Beancommodity> loadall(int ffid) throws BaseException {
		// TODO Auto-generated method stub
		List<Beancommodity> result = new ArrayList<Beancommodity>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select com_id,com_name,com_price,com_vip_price,"
					+ "com_count,com_specification,com_describe from commodity "
					+ "where FF_id = ? order by com_id";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, ffid);
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
	public Beancommodity add(String name,double lDprice, int lDcount) throws BaseException {
		// TODO Auto-generated method stub
		Beancommodity result = new Beancommodity();
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select max(com_id) from commodity where FF_id = 3100";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) {
				result.setCom_id(100);
				result.setLd_id(100);
			}else {
				result.setCom_id(rs.getInt(1)+1);
				result.setLd_id(rs.getInt(1)+1);
			}
			sql = "insert into commodity(com_id,FF_id,com_name,com_price,com_vip_price,"
					+ "com_count,com_specification,com_describe) values (?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,result.getCom_id());
			pst.setInt(2, 3100);
			pst.setString(3,name);
			pst.setDouble(4, lDprice);
			pst.setDouble(5, 0);
			pst.setInt(6,lDcount);
			pst.setString(7,"斤");
			pst.setString(8, "限时促销商品！");
			pst.execute();
			pst.close();
			
			result.setCom_name(name);
			result.setCom_price(lDprice);
			result.setCom_count(lDcount);
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
	public void update(Beancommodity p) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int count = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from commodity where com_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getCom_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				count = rs.getInt(7);
			}
			rs.close();
			
			sql = "update commodity set com_count = ? where com_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, count - p.getCom_count());
			pst.setInt(2,p.getCom_id());
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
