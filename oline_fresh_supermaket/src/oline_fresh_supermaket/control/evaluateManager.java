package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IevaluateManager;
import oline_fresh_supermaket.model.Beanevaluate;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class evaluateManager implements IevaluateManager {

	@Override
	public List<Beanevaluate> load(int ord_id) throws BaseException {
		// TODO Auto-generated method stub
		List<Beanevaluate> result = new ArrayList<Beanevaluate>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from evaluate where ord_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, ord_id);
			java.sql.ResultSet rs=pst.executeQuery();
			while (rs.next()) {
				Beanevaluate p = new Beanevaluate();
				p.setEva_content(rs.getString(1));
				p.setEva_date(rs.getDate(2));
				String star = rs.getString(3);
				p.setEva_star(star);
				p.setEva_order(rs.getInt(5));
				p.setOrd_id(rs.getInt(6));
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
	public void add(String starString, String contentString,int ord_id) throws BaseException {
		// TODO Auto-generated method stub
		Beanevaluate p = new Beanevaluate();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql ="select max(eva_order) from evaluate where ord_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);			
			pst.setInt(1, ord_id);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				p.setEva_order(rs.getInt(1)+1);
			}
			else {
				p.setEva_order(1);
			}
			sql = "insert into evaluate(eva_content,eva_date,eva_star,ord_id,eva_order) values (?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, contentString);
			pst.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			pst.setString(3, starString);
			pst.setInt(4, ord_id);
			pst.setInt(5, p.getEva_order());
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
	public void delete(int eva_order) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql ="delete from evaluate where eva_order = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, eva_order);
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
	public void ModifyContent(int eva_order,String content) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update evaluate set eva_content = ? where eva_order = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, content);
			pst.setInt(2,eva_order);
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
	public void ModifyStar(int eva_order,String star) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update evaluate set eva_star = ? where eva_order = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, star);
			pst.setInt(2,eva_order);
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
