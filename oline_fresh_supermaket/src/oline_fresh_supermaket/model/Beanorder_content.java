package oline_fresh_supermaket.model;

public class Beanorder_content {
	public static final String[] tableTitles = {"商品编号","订单编号","商品数量","单笔商品价格","商品所享受的满折"};
	int com_id;
	int ord_id;
	int Oc_count;
	double Oc_price;
	double Oc_discount;
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public int getOc_count() {
		return Oc_count;
	}
	public void setOc_count(int oc_count) {
		Oc_count = oc_count;
	}
	public double getOc_price() {
		return Oc_price;
	}
	public void setOc_price(double oc_price) {
		Oc_price = oc_price;
	}
	public double getOc_discount() {
		return Oc_discount;
	}
	public void setOc_discount(double oc_discount) {
		Oc_discount = oc_discount;
	}
	public String getCell(int col) {
		// TODO Auto-generated method stub
		if(col==0) return this.getCom_id()+"";
		else if(col==1) return this.getOrd_id()+"";
		else if(col==2) return this.getOc_count()+"";
		else if(col==3) return this.getOc_price()+"";
		else if (col == 4) return this.getOc_discount()+"";
		else return "";
	}
	
	
}
