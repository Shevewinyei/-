package oline_fresh_supermaket.model;

import java.util.Date;

public class Beanorder_message {
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
}
