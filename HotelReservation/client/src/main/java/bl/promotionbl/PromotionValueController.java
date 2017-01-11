package bl.promotionbl;

import java.rmi.RemoteException;

import blservice.promotionblservice.PromotionValueBLService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import dataservice.promotiondataservice.PromotionWebDataService;
import net.RMIManage;
import util.DataServiceType;
import util.PromotionHotelType;
import util.PromotionWebType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValueController implements PromotionValueBLService{

	private PromotionHotelDataService promotionHotelDataService;
	private PromotionWebDataService promotionWebDataService;
	private PromotionValue promotionValueHotel;
	private PromotionValue promotionValueWeb;
	
	public PromotionValueController() {
		promotionHotelDataService = (PromotionHotelDataService)RMIManage.
				getDataService(DataServiceType.PromotionHotelDataService);
		promotionWebDataService = (PromotionWebDataService)RMIManage.
				getDataService(DataServiceType.PromotionWebDataService);
		promotionValueHotel = new PromotionValue(promotionHotelDataService);
		promotionValueWeb = new PromotionValue(promotionWebDataService);
	}
	
	@Override
	public double getValue(CustomerInfoVO user, OrderVO order, PromotionHotelType hotelType) {
		double d = 1;
		try {
			d = promotionValueHotel.getValue(user, order, hotelType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public double getValue(CustomerInfoVO user, OrderVO order, PromotionWebType webType) {
		double d = 1;
		try {
			d = promotionValueWeb.getValue(user, order, webType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

}
