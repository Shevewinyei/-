package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.util.BaseException;

public interface IcommodityManage {
	/**
	 *º”‘ÿ¿‡
	 */
	public List<Beancommodity> loadcommodity()throws BaseException;
	public Beancommodity addcommodity(Beancommodity commodity)throws BaseException;
	
}
