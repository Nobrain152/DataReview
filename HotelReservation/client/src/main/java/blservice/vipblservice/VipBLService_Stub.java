package blservice.vipblservice;

import po.BusinessVipPO;
import po.CommonVipPO;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class VipBLService_Stub implements VipBLService {

	@Override
	public int searchLevel(CustomerInfoVO user) {
		return 3;
	}

	@Override
	public ResultMsg registerVip(String userID, VipType type, String str) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public CommonVipPO findByUserIDC(String userID) {
		return null;
	}

	@Override
	public BusinessVipPO findByUserIDB(String userID) {
		return null;
	}

	@Override
	public ResultMsg updateC(CommonVipPO commonVipPO) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg updateB(BusinessVipPO businessVipPO) {
		return ResultMsg.SUCCESS;
	}
	
}