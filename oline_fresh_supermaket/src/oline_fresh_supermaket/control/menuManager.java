package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.ImenuManager;
import oline_fresh_supermaket.model.BeanMenu;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class menuManager implements ImenuManager {

	@Override
	public List<BeanMenu> allload() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanMenu> result = new ArrayList<BeanMenu>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from menu";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				BeanMenu p = new BeanMenu();
				p.setMen_id(rs.getInt(1));
				p.setMen_name(rs.getString(2));
				p.setMen_material(rs.getString(3));
				p.setMen_step(rs.getString(4));
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
	public void delete(int men_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "delete from com_menu where men_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, men_id);
			pst.execute();
			
			sql = "delete from menu where men_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, men_id);
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
	public void Addmenu(BeanMenu p) throws BaseException{
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select max(men_id) from menu";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				p.setMen_id(rs.getInt(1)+1);
			}
			else {
				p.setMen_id(1);
			}
			rs.close();
			
			sql = "insert into menu(men_id,men_name,men_materials,men_step) values (?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getMen_id());
			pst.setString(2, p.getMen_name());
			pst.setString(3, p.getMen_material());
			pst.setString(4, p.getMen_step());
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
	public void Addmenu_com(int com_id, int menu_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql ="insert into com_menu(com_id,men_id) values (?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, com_id);
			pst.setInt(2, menu_id);
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
