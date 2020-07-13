package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanlimit_discount;
import oline_fresh_supermaket.util.BaseException;

public interface ILDManager {
	public List<Beanlimit_discount> loadall(List<Beancommodity> pubs)throws BaseException;
	public List<Beanlimit_discount> loadall()throws BaseException;
	public void add(Beancommodity p)throws BaseException;
}
