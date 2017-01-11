package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

/**
 * 查看酒店信息的接口
 * @author 曹畅
 *
 */
public interface HotelInfoCheckBLService {
	
	/**
	 * 查看酒店信息
	 * @param hotelInfoVO
	 * @return
	 */
    public HotelInfoVO checkHotelInfo(String hotelid);
    
    /**
	 * 查看酒店列表方法
	 * @return
	 */
	public ArrayList<HotelInfoVO> hotelScan();
  
}