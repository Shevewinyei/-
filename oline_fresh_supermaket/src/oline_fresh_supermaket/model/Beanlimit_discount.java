package oline_fresh_supermaket.model;

import java.util.Date;

public class Beanlimit_discount {
	int LD_id;
	double LD_price;
	int LD_count;
	Date LD_starttime;
	Date LD_enddate;
	public int getLD_id() {
		return LD_id;
	}
	public void setLD_id(int lD_id) {
		LD_id = lD_id;
	}
	public double getLD_price() {
		return LD_price;
	}
	public void setLD_price(double lD_price) {
		LD_price = lD_price;
	}
	public int getLD_count() {
		return LD_count;
	}
	public void setLD_count(int lD_count) {
		LD_count = lD_count;
	}
	public Date getLD_starttime() {
		return LD_starttime;
	}
	public void setLD_starttime(Date lD_starttime) {
		LD_starttime = lD_starttime;
	}
	public Date getLD_enddate() {
		return LD_enddate;
	}
	public void setLD_enddate(Date lD_enddate) {
		LD_enddate = lD_enddate;
	}
	
}
