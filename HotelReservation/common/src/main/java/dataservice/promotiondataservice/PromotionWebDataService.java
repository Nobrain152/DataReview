package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionWebPO;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;

/**
 * ��վ�������Ե����ݲ�ӿ�
 * @author T5-SK
 *
 */

public interface PromotionWebDataService extends Remote{
	
	public ResultMsg insert(PromotionWebPO Promotion) throws RemoteException;
	
	public ResultMsg deleteCircleCut(Area area) throws RemoteException;
	
	public ResultMsg deleteLevelCut(int level) throws RemoteException;
	
	public ResultMsg deleteWebCustomCut(String beginTime,String endTme) throws RemoteException;
	
	public ResultMsg update(PromotionWebPO Promotion) throws RemoteException;
	
	public ArrayList<PromotionWebPO> findByType(PromotionWebType type) throws RemoteException;
	
	public ArrayList<PromotionWebPO> show() throws RemoteException;
	
}