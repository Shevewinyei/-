package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.BeanFull_discount;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.util.BaseException;

public interface IFDManager {
	public List<BeanFull_discount> loadFD()throws BaseException;
}
