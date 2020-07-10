package oline_fresh_supermaket.ift;

import oline_fresh_supermaket.model.Beanuser;
import oline_fresh_supermaket.util.BaseException;

public interface IuserManager {

	public Beanuser login(String userid, String pwd)throws BaseException;
	public Beanuser reg(String name,String gender,char[] pwd,char[] pwd2,String telephone,String city,String email)throws BaseException;
}
