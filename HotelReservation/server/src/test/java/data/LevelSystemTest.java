package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.vipdata.LevelSystem;
import po.LevelSystemPO;

public class LevelSystemTest {
	private LevelSystem impl;
	LevelSystemPO po1,po2;
	
	@Before
	public void set() throws RemoteException{
		impl = new LevelSystem();
		po1 = new LevelSystemPO(1, 1000);
		po2 = new LevelSystemPO(2, 2000);
	}
	
//	@Test
//	public void testInsert() throws RemoteException{
//		ResultMsg aMsg  = impl.insert(po1);
//		assertEquals(aMsg, ResultMsg.SUCCESS);
//	}
	
	@Test
	public void testFindBy() throws RemoteException{
		LevelSystemPO po = impl.findByLevel("3");
		if(po == null){
			System.out.println("warn");
		}else{
			System.out.println(po.getLevels());
		System.out.println(po.getCredits());
		}
		
	}
}
