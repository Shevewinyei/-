package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.Date;
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
	public List<Beanorder_message> allload() throws BaseException {
		// TODO Auto-generated method stub
		List<Beanorder_message> result = new ArrayList<Beanorder_message>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from order_message where ord_id in (select ord_id from Relationship_2 where usr_id = ?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, Beanuser.currentLoginUser.getUsr_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanorder_message p = new Beanorder_message();
				p.setOrd_id(rs.getInt(1));
				p.setOrd_startprice(rs.getDouble(2));
				p.setOrd_endprice(rs.getDouble(3));
				p.setOrd_time(rs.getDate(4));
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

	@Override
	public Beanorder_message AddOrder(Beanorder_message message) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select max(ord_id) from order_message";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) message.setOrd_id(1);
			else {
				message.setOrd_id(rs.getInt(1)+1);
			}
			rs.close();
			
			sql = "insert into order_message(ord_id,ord_startprice,ord_endprice,ord_time,ord_state) values (?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, message.getOrd_id());
			pst.setDouble(2, message.getOrd_startprice());
			pst.setDouble(3, message.getOrd_endprice());
			pst.setDate(4, new java.sql.Date(message.getOrd_time().getTime()));
			pst.setString(5, "下单");
			pst.execute();
			pst.close();
			
			sql = "insert into Relationship_2(ord_id,usr_id) values (?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, message.getOrd_id());
			pst.setInt(2, Beanuser.currentLoginUser.getUsr_id());
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
		return message;
	}

	@Override
	public void Modify_state(int ord_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update order_message set ord_state = ? where ord_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, "完成");
			pst.setInt(2,ord_id);
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
	public void deleteOrder(int ord_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "delete from Relationship_2 where ord_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, ord_id);
			pst.execute();
			
			sql = "delete from order_content where ord_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, ord_id);
			pst.execute();
			
			sql = "delete from order_message where ord_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, ord_id);
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
	public List<Beanorder_message> load() throws BaseException {
		// TODO Auto-generated method stub
		List<Beanorder_message> result = new ArrayList<Beanorder_message>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from order_message";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanorder_message p = new Beanorder_message();
				p.setOrd_id(rs.getInt(1));
				p.setOrd_startprice(rs.getDouble(2));
				p.setOrd_endprice(rs.getDouble(3));
				p.setOrd_time(rs.getDate(4));
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

	@Override
	public void Modify_state2(int ord_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "update order_message set ord_state = ? where ord_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, "配送");
			pst.setInt(2,ord_id);
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
