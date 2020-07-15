package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.util.BaseException;

public interface IordermessageManager {
	public List<Beanorder_message> allload() throws BaseException;
	public Beanorder_message AddOrder(Beanorder_message message)throws BaseException;
	public void Modify_state(int ord_id)throws BaseException;
	public void deleteOrder(int ord_id)throws BaseException;
	public List<Beanorder_message> load()throws BaseException;
	public void Modify_state2(int ord_id)throws BaseException;
}
