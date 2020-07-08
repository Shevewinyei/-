package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IFFManager;
import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class FFManage implements IFFManager {

	@Override
	public List<BeanFF> loadall() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanFF> result = new ArrayList<BeanFF>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from FF ";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				BeanFF p = new BeanFF();
				p.setFF_id(rs.getInt(1));
				p.setFF_name(rs.getString(2));
				p.setFF_describle(rs.getString(3));
				result.add(p);
			}
		} catch (SQLException e) {
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
	public BeanFF addFF(int FFid, String FFname, String FFdescrible) throws BaseException {
		// TODO Auto-generated method stub
		if(FFid == 0) throw new BaseException("生鲜编号不能为空！");
		if(FFname.isEmpty()) throw new BaseException("生鲜名称不能为空！");
		BeanFF result = new BeanFF();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "insert into FF(FF_id,FF_name,FF_describe) values (?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, FFid);
			pst.setString(2, FFname);
			pst.setString(3, FFdescrible);
			pst.execute();
			pst.close();
			
			result.setFF_id(FFid);
			result.setFF_name(FFname);
			result.setFF_describle(FFdescrible);
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
	public void deleteFF(int FF_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "delete from FF where FF_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, FF_id);
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
	public List<BeanFF> searchFF(int FF_id) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanFF> result = new ArrayList<BeanFF>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from FF where FF_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, FF_id);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BaseException("未查询到该编号商品。");
			else {
				BeanFF p = new BeanFF();
				p.setFF_id(FF_id);
				p.setFF_name(rs.getString(2));
				p.setFF_describle(rs.getString(3));
				result.add(p);
			}
			
		} catch (SQLException e) {
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
