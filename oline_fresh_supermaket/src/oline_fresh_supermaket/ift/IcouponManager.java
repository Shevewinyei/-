package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancoupon;
import oline_fresh_supermaket.util.BaseException;

public interface IcouponManager {

	public List<Beancoupon> allload()throws BaseException;

	public void deleteCou(int cou_id)throws BaseException;

	public void add(Beancoupon p)throws BaseException;

	public void Modity(int cou_id, String content)throws BaseException;

	public void Modity1(int cou_id, double price)throws BaseException;

	public void Modity2(int cou_id, double price)throws BaseException;

}
