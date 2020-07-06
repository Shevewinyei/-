package oline_fresh_supermaket.model;

import java.util.Date;

public class Beancom_purchase {
	int purchase_id;
	int admin_id;
	int purchase_count;
	String purchase_state;
	Date purchase_time;
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getPurchase_count() {
		return purchase_count;
	}
	public void setPurchase_count(int purchase_count) {
		this.purchase_count = purchase_count;
	}
	public String getPurchase_state() {
		return purchase_state;
	}
	public void setPurchase_state(String purchase_state) {
		this.purchase_state = purchase_state;
	}
	public Date getPurchase_time() {
		return purchase_time;
	}
	public void setPurchase_time(Date purchase_time) {
		this.purchase_time = purchase_time;
	}
	public Date getArrive_time() {
		return arrive_time;
	}
	public void setArrive_time(Date arrive_time) {
		this.arrive_time = arrive_time;
	}
	Date arrive_time;
}
