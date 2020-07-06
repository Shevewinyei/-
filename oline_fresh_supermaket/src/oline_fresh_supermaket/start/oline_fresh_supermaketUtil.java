package oline_fresh_supermaket.start;

import oline_fresh_supermaket.control.adminmanage;
import oline_fresh_supermaket.ift.Iadminmanage;

public class oline_fresh_supermaketUtil {
	public static Iadminmanage userManager=(Iadminmanage) new adminmanage();//需要换成自行设计的实现类
}
