package bl;


import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

import po.CommonVipPO;
import po.ContactPO;
import po.CustomerInfoPO;
import po.HotelInfoPO;
import po.OrderPO;
import po.RoomInfoPO;
import po.UserInfoPO;
import util.Adress;
import util.Area;
import util.OrderState;
import util.RoomState;
import util.RoomType;
import util.VipType;
import vo.CommonVipVO;
//import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;
import vo.UserInfoVO;

/** 
 * 
 * VOPOµÄ»¥»»
 * @author txin15 
 *
 */
public class VOPOchange {
	
	public static Object POtoVO(Object o){
		
		if(o == null){
			return null;
		}
		
		Object vo = null;
		
		Class<? extends Object> poClass = o.getClass();
		
		Class<? extends Object> voClass = null;
		
		String poName = poClass.getName();
		
		String voName = "vo"+poName.substring(2,poName.length()-2)+"VO";
		
		Field[] field = poClass.getDeclaredFields();
		
		try {
			voClass = Class.forName(voName);
			vo = voClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		if(voClass.getSuperclass().toString().endsWith("CustomerInfoVO")){
			setSuperField(vo, o, "credit");
			setSuperField(vo, o, "isMember");
			setSuperField(vo, o, "vipType");
			setSuperField(vo, o, "userID");
			setSuperField(vo, o, "password");
			setSuperField(vo, o, "username");
			setSuperField(vo, o, "contact");
			setSuperField(vo, o, "type");
		}
		
		if(voClass.getSuperclass().toString().endsWith("UserInfoVO")){
			setSuperField(vo, o, "userID");
			setSuperField(vo, o, "password");
			setSuperField(vo, o, "username");
			setSuperField(vo, o, "contact");
			setSuperField(vo, o, "type");
		}
		
		for(int i = 0 ; i < field.length; i++){
			
			if(field[i].getName().equals("serialVersionUID"))
				continue;
			
			if(field[i].getType().toString().endsWith("ArrayList")
					&& !field[i].getGenericType().toString().endsWith("String>")){
				
				Field ft = null;
				try {
					ft = vo.getClass().getDeclaredField(field[i].getName());
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				ft.setAccessible(true);
				try {
					ft.set(vo, null);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			else
//				try {
//					tmp = voClass.getDeclaredField(f.getName());
//				} catch (NoSuchFieldException e) {
//					e.printStackTrace();
//				} catch (SecurityException e) {
//					e.printStackTrace();
//				}
//				f.setAccessible(true);
//				tmp.setAccessible(true);
//				try {
//					tmp.set(vo, f.get(o));
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}
				setSuperFieldTmp(vo, o, field[i].getName());
			}
		return vo;
		
	}
	
	private static void setSuperFieldTmp(Object vo, Object o, String name) {
		
		Field field1 = getSuperFieldTmp(o.getClass(), name);
		if(name.endsWith("PO")) {
			name = name.substring(0, name.length()-2) + "VO";
		}
		Field field2 = getSuperFieldTmp(vo.getClass(), name);
		
		try {
			
			field1.setAccessible(true);
			Object val = field1.get(o);

			try {
				field2.setAccessible(true);
				if(val.getClass().toString().endsWith("PO")) {
					Object valtmp = POtoVO(val);
					field2.set(vo, valtmp);
				} else {
					field2.set(vo, val);
				}
			} catch(NullPointerException exception) {
				
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes") 
	private static Field getSuperFieldTmp(Class clazz, String name) {
		Field[] field = clazz.getDeclaredFields();
		
		for(Field f : field ){
			if(f.getName().equals(name)){
				return f;
			}
		}
		
		Class supClass = clazz.getSuperclass();
		if(supClass!=null){
			return getSuperFieldTmp(supClass, name);
		}
		return null;
	}
	

	@SuppressWarnings("unchecked")
	public static Object VOtoPO(Object o){
		
		if(o == null) {
			return null;
		}
		
		Object po = null;
		
		Class<? extends Object> voClass = o.getClass();
		
		Class<? extends Object> poClass = null;
		
		String voName = voClass.getName();
		
		String poName = "po"+voName.substring(2,voName.length()-2)+"PO";
		
		Field[] field = voClass.getDeclaredFields();
	
		try {		
			poClass = Class.forName(poName);
			po = poClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		if(voClass.getSuperclass().toString().endsWith("CustomerInfoVO")){
			setSuperField(po, o, "credit");
			setSuperField(po, o, "isMember");
			setSuperField(po, o, "vipType");
			setSuperField(po, o, "userID");
			setSuperField(po, o, "password");
			setSuperField(po, o, "username");
			setSuperField(po, o, "contact");
			setSuperField(po, o, "type");
		}
		
		if(voClass.getSuperclass().toString().endsWith("UserInfoVO")){
			setSuperField(po, o, "userID");
			setSuperField(po, o, "password");
			setSuperField(po, o, "username");
			setSuperField(po, o, "contact");
			setSuperField(po, o, "type");
		}
		
		for(int i = 0 ; i < field.length; i++){
			
			if(field[i].getType().toString().endsWith("ArrayList")
					&& !field[i].getGenericType().toString().endsWith("String>")){
				Type listType = field[i].getGenericType();//java.util.ArrayList<vo.OrderVO>
				Object list = null;
				
				try {
					 list = field[i].get(o);
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
				ArrayList<Object> volist = (ArrayList<Object>)list;
				
				String[] spl = listType.toString().split("<");
				
				String potName = "po" + spl[1].substring(2, spl[1].length()-3)+"PO";

				Class<? extends Object> potmp = null;

				try {
					
					potmp = Class.forName(potName);

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				ArrayList<Object> polist = new ArrayList<Object>(volist.size());
				for(int j =0 ; j< volist.size(); j++){
					polist.add(potmp.cast(VOtoPO(volist.get(j))));
				}
				
				Field ft = null;
				try {
					ft = po.getClass().getDeclaredField(field[i].getName());
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				ft.setAccessible(true);
				try {
					ft.set(po, polist);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			else
				setSuperField(po, o, field[i].getName());
		}
		
		return po;
		
	}
	 
	private static void setSuperField(Object po,Object o, String name) {
		
		Field field1 = getSuperField(o.getClass(), name);
		if(name.endsWith("VO")) {
			name = name.substring(0, name.length()-2) + "PO";
		}
		Field field2 = getSuperField(po.getClass(), name);
		
		try {
			
			field1.setAccessible(true);
			Object val = field1.get(o);

			try {
				field2.setAccessible(true);
				if(val.getClass().toString().endsWith("VO")) {
					Object valtmp = VOtoPO(val);
					field2.set(po, valtmp);
				} else {
					field2.set(po, val);
				}
			} catch(NullPointerException exception) {
				
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	private static Field getSuperField(Class clazz, String name) {
		
		Field[] field = clazz.getDeclaredFields();
		
		for(Field f : field ){
			if(f.getName().equals(name)){
				return f;
			}
		}
		
		Class supClass = clazz.getSuperclass();
		if(supClass!=null){
			return getSuperField(supClass, name);
		}
		return null;
	}
	
	public static void main(String[] args) {
		
//		CommonVipVO commonVipVO = new CommonVipVO("19954722", "ÌÆöÎ", "sfd", "18805156300", 300, "1997-05-13", VipType.COMMON_VIP);
//		CommonVipPO commonVipPO = (CommonVipPO)VOtoPO(commonVipVO);
//		System.out.println(commonVipPO.getVipType());
		
//		CustomerInfoVO customerInfoVO = new CustomerInfoVO("19954722", "ÌÆöÎ", "18805156300","sfd", 300, true, VipType.COMMON_VIP);
//		CustomerInfoPO customerInfoPO = (CustomerInfoPO)VOtoPO(customerInfoVO);
//		System.out.println("-==-");
		//OK
//		UserInfoVO vo = new UserInfoVO("12345", "67890", "18805156300","sfd");
//		UserInfoPO po = (UserInfoPO)VOtoPO(vo);
//		System.out.println(po.getUserID());
		
//		HotelInfoPO hotelInfoPO = new HotelInfoPO("12345", "7day", Adress.BEIJING, Area.EAST, 1, "none", "none", true, 5, 4);
//		hotelInfoPO.setOrder(new ArrayList<>());
//		HotelInfoVO hotelInfoVO = (HotelInfoVO)VOPOchange.POtoVO(hotelInfoPO);
//		System.out.println(hotelInfoVO.getName());
//		
//		HotelInfoVO hotelInfoVO1 = new HotelInfoVO("7day", Adress.BEIJING, Area.EAST, 1, "none", "none", true, "12345",5, 4);
//		hotelInfoVO1.setOrder(new ArrayList<>());
//		HotelInfoPO hotelInfoPO1 = (HotelInfoPO)VOPOchange.VOtoPO(hotelInfoVO1);
//		System.out.println(hotelInfoPO1.getName());
		
		//OK
//		OrderVO vo = new OrderVO(new CustomerInfoVO("19954722", "ÌÆöÎ", 
//				new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
//				OrderState.UNEXECUTED, 99.9, "201612062014", "014", false, 
//				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", "2016-12-17 12:00",
//				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
//		OrderPO po = (OrderPO)VOtoPO(vo);
//		System.out.println(po.getOrderID());
		
		//OK
//		ContactVO vo = new ContactVO("18805156300", null);
//		ContactPO po = (ContactPO)VOtoPO(vo);
//		System.out.println(po.getPhoneNumber());

		//OK
//		ContactPO po = new ContactPO("18805156300",null);
//		ContactVO vo = (ContactVO)POtoVO(po);
//		System.out.println(vo.getPhoneNumber());
		
		//OK
//		OrderPO po = new OrderPO("201612062014",new CustomerInfoPO("19954722", "ÌÆöÎ", 
//		new ContactPO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
//		OrderState.UNEXECUTED, 99.9, "014", false, 
//		"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", "2016-12-17 12:00",
//		1, 1,new RoomInfoPO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"));
//		OrderVO vo = (OrderVO)POtoVO(po);
//		System.out.println(po.getOrderID());
		
		//OK
//		UserInfoPO po = new UserInfoPO("12345", "67890", new ContactPO("18805156300", "151250132@smail.nju.edu.cn"));
//		UserInfoVO vo = (UserInfoVO)POtoVO(po);
//		System.out.println(vo.getContact().getEmailAddress());
	}

}
