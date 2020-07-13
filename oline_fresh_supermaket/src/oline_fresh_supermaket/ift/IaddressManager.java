package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.Beanaddress;
import oline_fresh_supermaket.util.BaseException;

public interface IaddressManager {
	public List<Beanaddress> loadall(int userid) throws BaseException;

	public void Add(String addpro, String addcity, String addarea, String addcurrent)throws BaseException;
	public void deleteAddress(int addr_id)throws BaseException;
}
