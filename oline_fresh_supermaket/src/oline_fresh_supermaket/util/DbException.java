package oline_fresh_supermaket.util;

public class DbException extends BaseException{
	public DbException(java.lang.Throwable ex){
		super("���ݿ��������"+ex.getMessage());
	}
}
