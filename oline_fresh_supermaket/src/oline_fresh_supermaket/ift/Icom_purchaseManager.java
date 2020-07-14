package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancom_purchase;
import oline_fresh_supermaket.util.BaseException;

public interface Icom_purchaseManager {

	public List<Beancom_purchase> allload()throws BaseException;

	public void delete(int purchase_id)throws BaseException;

	public void add(Beancom_purchase t)throws BaseException;

}
