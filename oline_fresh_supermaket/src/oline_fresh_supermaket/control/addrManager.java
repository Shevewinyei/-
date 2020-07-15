package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IaddressManager;
import oline_fresh_supermaket.model.Beanaddress;
import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class addrManager implements IaddressManager {

	@Override
	public List<Beanaddress> loadall(int userid) throws BaseException {
		// TODO Auto-generated method stub
		List<Beanaddress> result = new ArrayList<Beanaddress>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from address where usr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanaddress p = new Beanaddress();
				p.setAddr_id(rs.getInt(1));
				p.setUsr_id(rs.getInt(2));
				p.setAddr_pro(rs.getString(3));
				p.setAddr_city(rs.getString(4));
				p.setAddr_area(rs.getString(5));
				p.setAddr_current(rs.getString(6));
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
	public void Add(String addpro, String addcity, String addarea, String addcurrent) throws BaseException {
		// TODO Auto-generated method stub
		Beanaddress p = new Beanaddress();
		Connection conn = null;
		if (addpro.isEmpty()||addarea.isEmpty()||addcity.isEmpty()||addcurrent.isEmpty()) {
			throw new BaseException("«ÎÃÓ–¥ÕÍ’˚µÿ÷∑£°");
		}
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select max(addr_id) from address";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) {
				p.setAddr_id(1);
			}
			else {
				p.setAddr_id(rs.getInt(1)+1);
			}
			
			sql = "insert into address(addr_id,usr_id,addr_pro,"
					+ "addr_city,addr_area,addr_current) values (?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getAddr_id());
			pst.setInt(2, Beanuser.currentLoginUser.getUsr_id());
			pst.setString(3, addpro);
			pst.setString(4, addcity);
			pst.setString(5, addarea);
			pst.setString(6, addcurrent);
			pst.execute();
			
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
	}

	@Override
	public void deleteAddress(int addr_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from address where addr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, addr_id);
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
	public void Modity(int addr_id, String string) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update address set addr_pro = ? where addr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, string);
			pst.setInt(2,addr_id);
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
	public void Modity1(int addr_id, String string) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update address set addr_city = ? where addr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, string);
			pst.setInt(2,addr_id);
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
	public void Modity2(int addr_id, String string) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update address set addr_area = ? where addr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, string);
			pst.setInt(2,addr_id);
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
	public void Modity3(int addr_id, String string) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update address set addr_current = ? where addr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, string);
			pst.setInt(2,addr_id);
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
