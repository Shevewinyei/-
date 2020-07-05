package oline_fresh_supermaket.model;

import java.util.Date;

public class Beanuser {
	int usr_id;
	String usr_name;
	String usr_gender;
	String usr_pwd;
	String usr_phonenumber;
	String usr_email;
	String usr_city;
	Date usr_registration_time;
	boolean usr_isvip;
	Date usr_vip_ddl;
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_gender() {
		return usr_gender;
	}
	public void setUsr_gender(String usr_gender) {
		this.usr_gender = usr_gender;
	}
	public String getUsr_pwd() {
		return usr_pwd;
	}
	public void setUsr_pwd(String usr_pwd) {
		this.usr_pwd = usr_pwd;
	}
	public String getUsr_phonenumber() {
		return usr_phonenumber;
	}
	public void setUsr_phonenumber(String usr_phonenumber) {
		this.usr_phonenumber = usr_phonenumber;
	}
	public String getUsr_email() {
		return usr_email;
	}
	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}
	public String getUsr_city() {
		return usr_city;
	}
	public void setUsr_city(String usr_city) {
		this.usr_city = usr_city;
	}
	public Date getUsr_registration_time() {
		return usr_registration_time;
	}
	public void setUsr_registration_time(Date usr_registration_time) {
		this.usr_registration_time = usr_registration_time;
	}
	public boolean isUsr_isvip() {
		return usr_isvip;
	}
	public void setUsr_isvip(boolean usr_isvip) {
		this.usr_isvip = usr_isvip;
	}
	public Date getUsr_vip_ddl() {
		return usr_vip_ddl;
	}
	public void setUsr_vip_ddl(Date usr_vip_ddl) {
		this.usr_vip_ddl = usr_vip_ddl;
	}
	
}
