package softstone.paper.sql.util;

import net.sf.jsqlparser.statement.select.PlainSelect;

import java.util.Map;

public class ReturnSqlUtil {

	private static Map<String,PlainSelect> plainSelects;
	//private static String regex;
	private static PlainSelect plainSelect;
	private static String tablealias=null;
	public static Map<String, PlainSelect> getPlainSelects() {
		return plainSelects;
	}
	public static void setPlainSelects(Map<String, PlainSelect> plainSelects) {
		ReturnSqlUtil.plainSelects = plainSelects;
	}
	/*public static String getRegex() {
		return regex;
	}
	public static void setRegex(String regex) {
		ReturnSqlUtil.regex = regex;
	}*/
	public static PlainSelect getPlainSelect() {
		return plainSelect;
	}
	public static void setPlainSelect(PlainSelect plainSelect) {
		ReturnSqlUtil.plainSelect = plainSelect;
	}
	public static String getTablealias() {
		return tablealias;
	}
	public static void setTablealias(String tablealias) {
		ReturnSqlUtil.tablealias = tablealias;
	}
	/*private static Map<String,String> typeMap;
	
	
	private static boolean flag;//���б���Ƿ���ͬһ�����ݲֿ���   true��ʾ���б����ͬ�����ݲֿ��У�false��ʾ����ͬһ�����ݲֿ���
	*/
	/*public static Map<String, String> getTypeMap() {
		return typeMap;
	}
	public static void setTypeMap(Map<String, String> typeMap) {
		ReturnSqlUtil.typeMap = typeMap;
	}
	
	
	
	public static boolean isFlag() {
		return flag;
	}
	public static void setFlag(boolean flag) {
		ReturnSqlUtil.flag = flag;
	}
	*/
	
	
}
