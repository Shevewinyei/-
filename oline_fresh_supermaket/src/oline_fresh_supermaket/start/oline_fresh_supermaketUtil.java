package oline_fresh_supermaket.start;

import oline_fresh_supermaket.control.FDManager;
import oline_fresh_supermaket.control.FFManage;
import oline_fresh_supermaket.control.LDManager;
import oline_fresh_supermaket.control.addrManager;
import oline_fresh_supermaket.control.adminManage;
import oline_fresh_supermaket.control.com_purchaseManager;
import oline_fresh_supermaket.control.commodityManage;
import oline_fresh_supermaket.control.couponManager;
import oline_fresh_supermaket.control.evaluateManager;
import oline_fresh_supermaket.control.menuManager;
import oline_fresh_supermaket.control.ordercontentManager;
import oline_fresh_supermaket.control.ordermessageManager;
import oline_fresh_supermaket.control.userManager;
import oline_fresh_supermaket.ift.IFDManager;
import oline_fresh_supermaket.ift.IFFManager;
import oline_fresh_supermaket.ift.ILDManager;
import oline_fresh_supermaket.ift.IaddressManager;
import oline_fresh_supermaket.ift.IadminManage;
import oline_fresh_supermaket.ift.Icom_purchaseManager;
import oline_fresh_supermaket.ift.IcommodityManage;
import oline_fresh_supermaket.ift.IcouponManager;
import oline_fresh_supermaket.ift.IevaluateManager;
import oline_fresh_supermaket.ift.ImenuManager;
import oline_fresh_supermaket.ift.IordercontentManager;
import oline_fresh_supermaket.ift.IordermessageManager;
import oline_fresh_supermaket.ift.IuserManager;

public class oline_fresh_supermaketUtil {
	public static IadminManage adminManager = new adminManage();
	public static IcommodityManage comManager = new commodityManage();
	public static IFFManager FFManager= new FFManage();
	public static ImenuManager menuManager = new menuManager();
	public static Icom_purchaseManager com_purchaseManager = new com_purchaseManager();
	public static IFDManager FDManager = new FDManager();
	public static IcouponManager couponManager = new couponManager();
	public static ILDManager LDManager = new LDManager();
	
	public static IuserManager userManager = new userManager();
	public static IaddressManager addrManager = new addrManager();
	public static IevaluateManager evaluateManager = new evaluateManager();
	public static IordermessageManager ordermessageManager = new ordermessageManager();
	public static IordercontentManager ordercontentManager = new ordercontentManager();
	
	
	
}
