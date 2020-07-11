package oline_fresh_supermaket.model;

public class Beancommodity {
	public static final String[] tbltitle={"编号","名称","单价","vip价格","剩余数量","规格","描述"};
	public static Beancommodity currentCom;
	public String getCell(int col){
		if(col==0) return this.getCom_id()+"";
		else if(col==1) return this.getCom_name();
		else if(col==2) return this.getCom_price()+"";
		else if(col==3) return this.getCom_vip_price()+"";
		else if(col==4) return this.getCom_count()+"";
		else if(col==5) return this.getCom_specification()+"";
		else if(col == 6) return this.getCom_describle();
		else return "";
	}
	int com_id;
	int Ld_id;
	int FF_id;
	String com_name;
	double com_price;
	double com_vip_price;
	int com_count;
	String com_specification;
	String com_describle;
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public int getLd_id() {
		return Ld_id;
	}
	public void setLd_id(int ld_id) {
		Ld_id = ld_id;
	}
	public int getFF_id() {
		return FF_id;
	}
	public void setFF_id(int fF_id) {
		FF_id = fF_id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public double getCom_price() {
		return com_price;
	}
	public void setCom_price(double com_price) {
		this.com_price = com_price;
	}
	public double getCom_vip_price() {
		return com_vip_price;
	}
	public void setCom_vip_price(double com_vip_price) {
		this.com_vip_price = com_vip_price;
	}
	public int getCom_count() {
		return com_count;
	}
	public void setCom_count(int com_count) {
		this.com_count = com_count;
	}
	public String getCom_specification() {
		return com_specification;
	}
	public void setCom_specification(String com_specification) {
		this.com_specification = com_specification;
	}
	public String getCom_describle() {
		return com_describle;
	}
	public void setCom_describle(String com_describle) {
		this.com_describle = com_describle;
	}
	
	
	
}
