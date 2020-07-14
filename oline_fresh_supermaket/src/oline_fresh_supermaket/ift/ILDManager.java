package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.model.Beanlimit_discount;
import oline_fresh_supermaket.util.BaseException;

public interface ILDManager {
	public List<Beanlimit_discount> loadall(List<Beancommodity> pubs)throws BaseException;
	public List<Beanlimit_discount> loadall()throws BaseException;
	public void add(Beancommodity p)throws BaseException;
	public void delete(int ld_id, int com_id)throws BaseException;
	public void Modity(int ld_id, double index)throws BaseException;
	public void Modity1(int ld_id, int index)throws BaseException;
}
