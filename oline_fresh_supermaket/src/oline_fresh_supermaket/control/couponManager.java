package oline_fresh_supermaket.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oline_fresh_supermaket.ift.IcouponManager;
import oline_fresh_supermaket.model.Beancoupon;
import oline_fresh_supermaket.util.BaseException;
import oline_fresh_supermaket.util.DbException;
import oline_fresh_supermaket.util.JDBCUtil;

public class couponManager implements IcouponManager {

	@Override
	public List<Beancoupon> allload() throws BaseException {
		// TODO Auto-generated method stub
		List<Beancoupon> result = new ArrayList<Beancoupon>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select * from coupon";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beancoupon p = new Beancoupon();
				p.setCou_id(rs.getInt(1));
				p.setCou_content(rs.getString(2));
				p.setCou_abl_price(rs.getDouble(3));
				p.setCou_redu_price(rs.getDouble(4));
				p.setCou_starttime(rs.getDate(5));
				p.setCou_enddate(rs.getDate(6));
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
	public void deleteCou(int cou_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="delete from coupon where cou_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, cou_id);
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
	public void add(Beancoupon p) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			String sql = "select max(cou_id) from coupon";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) p.setCou_id(1);
			else {
				p.setCou_id(rs.getInt(1)+1);
			}
			rs.close();
			
			sql ="insert into coupon(cou_id,cou_content,cou_abl_price,cou_redu_price,cou_startdatet,cou_enddate) values (?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getCou_id());
			pst.setString(2, p.getCou_content());
			pst.setDouble(3, p.getCou_abl_price());
			pst.setDouble(4, p.getCou_redu_price());
			pst.setDate(5, new java.sql.Date(p.getCou_starttime().getTime()));
			pst.setDate(6, new java.sql.Date(p.getCou_enddate().getTime()));
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
