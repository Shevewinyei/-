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

	@Override
	public void delete(int fd_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql ="delete from Full_discount where FD_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, fd_id);
			pst.execute();
			
			sql = "delete from FD_com_connect where FD_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, fd_id);
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
	public void add_FD(String fD_content, int fD_com_count, double fD_discount, int fD_month) throws BaseException {
		// TODO Auto-generated method stub
		BeanFull_discount p = new BeanFull_discount();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select max(FD_id) from Full_discount";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) {
				p.setFD_id(1);
			}
			else {
				p.setFD_id(rs.getInt(1)+1);
			}
			
			sql = "insert into Full_discount(FD_id,FD_content,FD_com_count,"
					+ "FD_discount,FD_startdate,FD_enddate) values (?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getFD_id());
			pst.setString(2, fD_content);
			pst.setInt(3, fD_com_count);
			pst.setDouble(4, fD_discount);
			pst.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			pst.setDate(6, new java.sql.Date(System.currentTimeMillis()+2592000000L*fD_month));
			pst.execute();
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
	}

	@Override
	public void addFD_com(int comid, BeanFull_discount dct) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from commodity where com_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, comid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BaseException("该商品不存在，请输入正确的商品编号！");
			rs.close();
			
			sql = "insert into FD_com_connect(com_id,FD_id,FD_startdate,FD_enddate) values (?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, comid);
			pst.setInt(2, dct.getFD_id());
			pst.setDate(3, new java.sql.Date(dct.getFD_startdate().getTime()));
			pst.setDate(4, new java.sql.Date(dct.getFD_enddate().getTime()));
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
