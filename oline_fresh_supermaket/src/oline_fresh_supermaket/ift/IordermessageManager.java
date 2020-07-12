package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.util.BaseException;

public interface IordermessageManager {
	public Beanorder_message add(List<Beancommodity> coms) throws BaseException;
	public List<Beanorder_message> allload()throws BaseException;
}
