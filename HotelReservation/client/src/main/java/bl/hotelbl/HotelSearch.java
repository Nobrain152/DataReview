package bl.hotelbl;

import java.nio.file.DirectoryNotEmptyException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import vo.HotelInfoVO;
import vo.RoomInfoVO;

/**
 * ËÑË÷¾Æµê
 * @author ²Ü³©
 *
 */
public class HotelSearch {
	private HotelInfoDataService hotelData;
	public ArrayList<HotelInfoVO> hotelList;
	private RoomAddController room;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();
	
	public HotelSearch(HotelInfoDataService hotelDataService){
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
	}

	/**
	 * Ñ¡ÔñÌõ¼þ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelInfoVO,RoomInfoVO roomin) throws RemoteException{
		ArrayList<HotelInfoPO> pos;
		pos=hotelData.findByAreaAndCircle(hotelInfoVO.getAddress(),hotelInfoVO.getArea());
		boolean flag0 = false;
		if(hotelInfoVO.getName()!=null){
//			for(int i=0;i<pos.size();i++){
//				if(!pos.get(i).getName().equals(hotelInfoVO.getName())){
//					pos.remove(i);
//				}
//			}
			for(int i=0;i<pos.size();i++){
				if(flag0 == false && pos.get(i).getName().equals(hotelInfoVO.getName())){
					
				}else if(flag0 == true){
					flag0 = false;
					i = -1;
				}else{
					pos.remove(i);
					flag0 = true;
					i--;
				}
				
			}
		}
		boolean flag = false;
		if(hotelInfoVO.getLevel()!=0){
			for(int i=0;i<pos.size();i++){
				if(flag == false && pos.get(i).getLevel() != hotelInfoVO.getLevel()){
					pos.remove(i);
					flag = true;
					i--;
				}else if(flag == true){
					flag = false;
					i = -1;
				}
			}
		}
		boolean flag2 = false;
		double up=hotelInfoVO.getUp();
		double down=hotelInfoVO.getDown();
		if((up-down>=0.01)){
//			for(int i=0;i<pos.size();i++){
//				HotelInfoPO po=pos.get(i);
//				if((po.getScore()<down)||(po.getScore()>up)){
//					pos.remove(i);
//				}
//			}
			for(int i=0;i<pos.size();i++){
				if(flag2 == false && pos.get(i).getScore()>=down && pos.get(i).getScore()<=up){
					
				}else if(flag2 == true){
					flag2 = false;
					i = -1;
				}else{
					pos.remove(i);
					flag2 = true;
					i--;
				}
				
			}
		}
		
		if(hotelInfoVO.getIsReserved() == true){
			for(int i = 0; i<pos.size(); i++){
				if(pos.get(i).getIsReserved()!=true){
					pos.remove(i);
					i = -1;
				}
			}
		}
		
		
		if(roomin!=null){
			for(int i=0;i<pos.size();i++){
				String hotelid=pos.get(i).getHotelID();
				room=(RoomAddController)factory.getRoomAddBLService();
				ArrayList<RoomInfoVO> r=room.HotelRoomSearch(hotelid);
				for(int j=0;j<r.size();j++){
					if(roomin.getPrice()!=0){
						if(r.get(j).getPrice()!=roomin.getPrice()){
							pos.remove(i);
							break;
						}
					}
					if(roomin.getType()!=null){
						if(r.get(j).getType()!=roomin.getType()){
							pos.remove(i);
							break;
						}
					}
				}
				
			}
		}
		
		
		
		for(HotelInfoPO p:pos){
			hotelList.add((HotelInfoVO)VOPOchange.POtoVO(p));
		}
		return hotelList;
	}
	
}
