package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.BeanFull_discount;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.util.BaseException;

public interface IFDManager {
	public List<BeanFull_discount> loadFD()throws BaseException;

	public void delete(int fd_id)throws BaseException;
	public void add_FD(String fD_content, int fD_com_count, double fD_discount, int fD_month)throws BaseException;

	public void addFD_com(int comid, BeanFull_discount dct)throws BaseException;
	
}
