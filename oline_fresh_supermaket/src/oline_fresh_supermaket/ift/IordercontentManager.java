package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.BeanSearch;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanorder_content;
import oline_fresh_supermaket.model.Beanorder_message;
import oline_fresh_supermaket.util.BaseException;

public interface IordercontentManager {
	public  Beanorder_content add(List<Beancommodity> coms) throws BaseException;

	public List<Beanorder_content> allload(Beanorder_message ord)throws BaseException;

	public void add(List<Beancommodity> table, int ord_id)throws BaseException;

	public List<Beanorder_content> load()throws BaseException;

	public List<Beancommodity> selectComs()throws BaseException;

	public List<BeanSearch> selectSum(List<Beancommodity> coms)throws BaseException;

	public List<BeanSearch> selectCount(List<Beancommodity> coms)throws BaseException;
}
