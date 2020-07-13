package oline_fresh_supermaket.ift;

import java.util.List;

import oline_fresh_supermaket.model.BeanMenu;
import oline_fresh_supermaket.util.BaseException;

public interface ImenuManager {

	public List<BeanMenu> allload()throws BaseException;

	public void delete(int men_id)throws BaseException;

	public void Addmenu(BeanMenu p)throws BaseException;

	public void Addmenu_com(int com_id, int menu_id)throws BaseException;


}
