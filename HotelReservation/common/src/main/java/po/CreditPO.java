package po;

import java.io.Serializable;

import util.Action;

public class CreditPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ʱ��
	 */
	String time;
	
	/**
	 * �û�ID
	 */
	String userID;
	
	/**
	 * ����ID
	 */
	String orderID;
	
	/**
	 * ִ�ж���
	 */
	Action action;
	
	/**
	 * ����ֵ�仯
	 */
	String creditChange;
	
	/**
	 * ����ֵ���
	 */
	int creditResult;
	
	public CreditPO() {}
	
	public CreditPO(String userID,String orderID,String time,Action action,
			String creditChange,int creditResult) {
		this.userID = userID;
		this.time = time;
		this.orderID = orderID;
		this.action = action;
		this.creditChange = creditChange;
		this.creditResult = creditResult;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public String getOrderID(){
		return orderID;
	}
	
	public int getCreditResult() {
		return creditResult;
	}
	
	public void setCreditResult(int creditResult) {
		this.creditResult = creditResult;
	}
	
	public Action getAction() {
		return action;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public String getCreditChange() {
		return creditChange;
	}
	
	public void setCreditChange(String creditChange) {
		this.creditChange = creditChange;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
}