package oline_fresh_supermaket.model;

import java.util.Date;

public class Beanevaluate {
	String eva_content;
	Date eva_date;
	String eva_star;
	byte[] eva_image;
	int eva_order;
	int ord_id;
	public String getEva_content() {
		return eva_content;
	}
	public void setEva_content(String eva_content) {
		this.eva_content = eva_content;
	}
	public Date getEva_date() {
		return eva_date;
	}
	public void setEva_date(Date eva_date) {
		this.eva_date = eva_date;
	}
	public String getEva_star() {
		return eva_star;
	}
	public void setEva_star(String star) {
		this.eva_star = star;
	}
	public byte[] getEva_image() {
		return eva_image;
	}
	public void setEva_image(byte[] eva_image) {
		this.eva_image = eva_image;
	}
	public int getEva_order() {
		return eva_order;
	}
	public void setEva_order(int eva_order) {
		this.eva_order = eva_order;
	}
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	
}
