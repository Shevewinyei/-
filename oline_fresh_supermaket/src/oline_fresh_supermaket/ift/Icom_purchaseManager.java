package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancom_purchase;
import oline_fresh_supermaket.util.BaseException;

public interface Icom_purchaseManager {

	List<Beancom_purchase> allload()throws BaseException;

}
