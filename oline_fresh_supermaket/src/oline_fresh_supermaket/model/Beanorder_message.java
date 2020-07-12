package oline_fresh_supermaket.model;

import java.util.Date;

public class Beanorder_message {
	public static final String[] tableTitles = {"订单编号","初始金额","结算金额","订单时间","订单状态"};
	
	int ord_id;
	double ord_startprice;
	double ord_endprice;
	Date ord_time;
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public double getOrd_startprice() {
		return ord_startprice;
	}
	public void setOrd_startprice(double ord_startprice) {
		this.ord_startprice = ord_startprice;
	}
	public double getOrd_endprice() {
		return ord_endprice;
	}
	public void setOrd_endprice(double ord_endprice) {
		this.ord_endprice = ord_endprice;
	}
	public Date getOrd_time() {
		return ord_time;
	}
	public void setOrd_time(Date ord_time) {
		this.ord_time = ord_time;
	}
	public String getOrd_state() {
		return ord_state;
	}
	public void setOrd_state(String ord_state) {
		this.ord_state = ord_state;
	}
	String ord_state;
	public String getCell(int col) {
		// TODO Auto-generated method stub
		if(col==0) return this.getOrd_id()+"";
		else if(col==1) return this.getOrd_startprice()+"";
		else if(col==2) return this.getOrd_endprice()+"";
		else if(col==3) return this.getOrd_time()+"";
		else if(col==4) return this.getOrd_state();
		else return "";
	}
}
