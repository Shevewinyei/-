package oline_fresh_supermaket.ift;

import java.util.List;


import oline_fresh_supermaket.model.BeanFF;
import oline_fresh_supermaket.model.Beancommodity;
import oline_fresh_supermaket.util.BaseException;

public interface IFFManager {
	public List<BeanFF> loadall()throws BaseException;
	public BeanFF addFF(int FFid,String FFname,String FFdescrible) throws BaseException;
	public void deleteFF(int FF_id) throws BaseException;
	public List<BeanFF> searchFF(int FF_id) throws BaseException;
}
