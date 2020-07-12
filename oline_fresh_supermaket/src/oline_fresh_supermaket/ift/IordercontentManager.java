package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.util.BaseException;

public interface IordercontentManager {
	public  Beanorder_content add(List<Beancommodity> coms) throws BaseException;

	public List<Beanorder_content> allload(Beanorder_message ord)throws BaseException;
}
