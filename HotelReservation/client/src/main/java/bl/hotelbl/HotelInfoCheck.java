
package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import vo.HotelInfoVO;

/**
 * 查看酒店信息
 * @author 曹畅
 *
 */
public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData = hotelDataService;
	}
	
	/**
	 * 查看酒店信息
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public HotelInfoVO checkHotelInfo(String hotelid) throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelData.find(hotelid);
    	return (HotelInfoVO)VOPOchange.POtoVO(hotelInfoPO);
    }
	
	
	/**
	 * 查看所有注册的酒店列表
	 * @return
	 */
	public ArrayList<HotelInfoVO> hotelScan()throws RemoteException{
		ArrayList<HotelInfoVO> vos=new ArrayList<HotelInfoVO>();
		ArrayList<HotelInfoPO> pos=hotelData.show();
		for(int i=0;i<pos.size();i++){
			vos.add((HotelInfoVO)VOPOchange.POtoVO(pos.get(i)));
		}
		return vos;
	}
}
