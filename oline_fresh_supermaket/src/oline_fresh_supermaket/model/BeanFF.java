package oline_fresh_supermaket.model;

public class BeanFF {
	public static final String[] tableTitles={"编号","生鲜类别名称","描述"};
	int FF_id;
	String FF_name;
	String FF_describle;
	public String getCell(int col){
		if(col==0) return this.getFF_id()+"";
		else if(col==1) return this.getFF_name();
		else if(col==2) return this.getFF_describle()+"";
		
		else return "";
	}
	public int getFF_id() {
		return FF_id;
	}
	public void setFF_id(int fF_id) {
		FF_id = fF_id;
	}
	public String getFF_name() {
		return FF_name;
	}
	public void setFF_name(String fF_name) {
		FF_name = fF_name;
	}
	public String getFF_describle() {
		return FF_describle;
	}
	public void setFF_describle(String fF_describle) {
		FF_describle = fF_describle;
	}
	
	
}
