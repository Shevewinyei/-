package oline_fresh_supermaket.model;

import java.util.Date;

public class Beancoupon {
	int cou_id;
	String cou_content;
	double cou_abl_price;
	double cou_redu_price;
	Date cou_starttime;
	Date cou_enddate;
	
	public int getCou_id() {
		return cou_id;
	}
	public void setCou_id(int cou_id) {
		this.cou_id = cou_id;
	}
	public String getCou_content() {
		return cou_content;
	}
	public void setCou_content(String cou_content) {
		this.cou_content = cou_content;
	}
	public double getCou_abl_price() {
		return cou_abl_price;
	}
	public void setCou_abl_price(double cou_abl_price) {
		this.cou_abl_price = cou_abl_price;
	}
	public double getCou_redu_price() {
		return cou_redu_price;
	}
	public void setCou_redu_price(double cou_redu_price) {
		this.cou_redu_price = cou_redu_price;
	}
	public Date getCou_starttime() {
		return cou_starttime;
	}
	public void setCou_starttime(Date cou_starttime) {
		this.cou_starttime = cou_starttime;
	}
	public Date getCou_enddate() {
		return cou_enddate;
	}
	public void setCou_enddate(Date cou_enddate) {
		this.cou_enddate = cou_enddate;
	}
	
	
}
