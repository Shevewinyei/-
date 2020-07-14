package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import oline_fresh_supermaket.ift.ILDManager;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanlimit_discount;
import oline_fresh_supermaket.start.oline_fresh_supermaketUtil;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class LDManager implements ILDManager {

	@Override
	public List<Beanlimit_discount> loadall(List<Beancommodity> pubs) throws BaseException {
		// TODO Auto-generated method stub
		List<Beanlimit_discount> result = new ArrayList<Beanlimit_discount>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			for (int i = 0; i < pubs.size(); i++) {
				String sql = "select * from limit_discount where LD_id = ?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1, pubs.get(i).getCom_id());
				java.sql.ResultSet rs=pst.executeQuery();
				while (rs.next()) {
					Beanlimit_discount p = new Beanlimit_discount();
					p.setLD_id(rs.getInt(1));
					p.setLD_price(rs.getDouble(2));
					p.setLD_count(rs.getInt(3));
					p.setLD_starttime(rs.getDate(4));
					p.setLD_enddate(rs.getDate(5));
					result.add(p);	
				}
				pst.close();
				rs.close();
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

	@Override
	public void add(Beancommodity p) throws BaseException {
		// TODO Auto-generated method stub
		Beanlimit_discount result = new Beanlimit_discount();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql ="insert into limit_discount(LD_id,LD_price,LD_count,LD_startdate,LD_enddate) values (?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);			
			pst.setInt(1, p.getLd_id());
			pst.setDouble(2, p.getCom_price());
			pst.setInt(3, p.getCom_count());
			pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pst.setDate(5, new java.sql.Date(System.currentTimeMillis()+86400000L+172800000L));
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
	public List<Beanlimit_discount> loadall() throws BaseException {
		// TODO Auto-generated method stub
		List<Beanlimit_discount> result = new ArrayList<Beanlimit_discount>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from limit_discount order by LD_id";
			java.sql.PreparedStatement pst= conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while (rs.next()) {
				Beanlimit_discount p = new Beanlimit_discount();
				p.setLD_id(rs.getInt(1));
				p.setLD_price(rs.getDouble(2));
				p.setLD_count(rs.getInt(3));
				p.setLD_starttime(rs.getDate(4));
				p.setLD_enddate(rs.getDate(5));
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
	public void delete(int ld_id, int com_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql ="delete from limit_discount where LD_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, ld_id);
			pst.execute();
			
			sql = "delete from commodity where com_id = ?";
			pst=conn.prepareStatement(sql);
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
	public void Modity(int ld_id,double index) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update limit_discount set LD_price = ? where LD_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setDouble(1, index);
			pst.setInt(2,ld_id);
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
	public void Modity1(int ld_id,int index) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update limit_discount set LD_count = ? where LD_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, index);
			pst.setInt(2,ld_id);
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
