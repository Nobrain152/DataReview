package util;

/**
 * 操作的结果信息
 * @author txin
 *
 */
public enum ResultMsg {
	
	/**
	 * 成功
	 */
	SUCCESS,
	/**
	 * 失败
	 */
	FAIL,
	/**
	 * 中断
	 */
	PAUSE,
	
	hasExist,
	
	/**
	 * 数据不存在
	 */
	NOT_EXIST,
	
	SQL_ERROR,
	
	MONEY_NOT_ENOUGH,
	
	/*
	 * 未授权操作
	 */
	UNAUYHORIZED,
	/**
	 * ID缺失
	 */
	NONEID,
	/**
	 * 电话号码不正确
	 */
	WRONG_PHONENUMBER,
	
	/**
	 * 信息不完整
	 */
	INCOMPLETE_INFO

}
