package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beanevaluate;
import oline_fresh_supermaket.util.BaseException;

public interface IevaluateManager {

	public List<Beanevaluate> load(int ord_id)throws BaseException;

	public void add(String starString, String contentString, int ord_id)throws BaseException;

	public void delete(int eva_order)throws BaseException;

	public void ModifyContent(int eva_order, String content)throws BaseException;

	public void ModifyStar(int eva_order, String star)throws BaseException;

}
