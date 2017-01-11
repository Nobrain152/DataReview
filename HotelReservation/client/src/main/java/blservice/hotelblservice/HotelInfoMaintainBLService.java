package blservice.hotelblservice;

import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 维护酒店基本信息的接口
 * @author 曹畅
 *
 */
public interface HotelInfoMaintainBLService {
	
	/**
	 * 输入酒店信息
	 * @param hotelInfoVO
	 * @return
	 */
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO);
	
	/**
	 * 检查信息是否符合条件
	 * @param hotelInfoVO
	 * @return
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO);
    
    /**
     * 添加酒店
     * @param hotelInfoVO
     * @return
     */
    public String addHotel(HotelInfoVO hotelInfoVO);
    
    public HotelInfoPO find(String hotelID);
  
}