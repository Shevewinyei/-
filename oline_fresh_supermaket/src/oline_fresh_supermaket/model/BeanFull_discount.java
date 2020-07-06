package oline_fresh_supermaket.model;

import java.util.Date;

public class BeanFull_discount {
	int FD_id;
	String FD_content;
	int FD_com_count;
	double FD_discount;
	Date FD_startdate;
	public int getFD_id() {
		return FD_id;
	}
	public void setFD_id(int fD_id) {
		FD_id = fD_id;
	}
	public String getFD_content() {
		return FD_content;
	}
	public void setFD_content(String fD_content) {
		FD_content = fD_content;
	}
	public int getFD_com_count() {
		return FD_com_count;
	}
	public void setFD_com_count(int fD_com_count) {
		FD_com_count = fD_com_count;
	}
	public double getFD_discount() {
		return FD_discount;
	}
	public void setFD_discount(double fD_discount) {
		FD_discount = fD_discount;
	}
	public Date getFD_startdate() {
		return FD_startdate;
	}
	public void setFD_startdate(Date fD_startdate) {
		FD_startdate = fD_startdate;
	}
	public Date getFD_enddate() {
		return FD_enddate;
	}
	public void setFD_enddate(Date fD_enddate) {
		FD_enddate = fD_enddate;
	}
	Date FD_enddate;
}
