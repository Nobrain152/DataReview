package util;

/**
 * 订单状态
 * @author txin
 *
 */
public enum OrderState {
	/**
	 * 已执行
	 */
	EXECUTED,
	/**
	 * 未执行
	 */
	UNEXECUTED,
	/**
	 * 异常
	 */
	ABNORMAL,
	/**
	 * 已撤销
	 */
	CANCELLED
}
