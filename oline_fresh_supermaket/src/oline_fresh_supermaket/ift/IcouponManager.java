package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancoupon;
import oline_fresh_supermaket.util.BaseException;

public interface IcouponManager {

	public List<Beancoupon> allload()throws BaseException;

	public void deleteCou(int cou_id)throws BaseException;

}
