package test_work2;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;

import work2.IData;
import work2.InHotel;
import work2.OutHotel;

public class Out_test_easymock {
	private IData iData =null;
	@Test
	public void testOutsuccess(){
		iData=EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(101, "EMPTY")).andReturn("101退房成功");
		EasyMock.replay(iData);
		OutHotel outHotel=new OutHotel(iData);
		String str=outHotel.out(101);
		System.out.println(str);
		assertEquals("101退房成功",str);
		EasyMock.verify(iData);
	}
	@Test
	public void testOutFailure(){
		iData=EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(101, "EMPTY")).andReturn("该房间没有客人入住，退房失败！");
		EasyMock.replay(iData);
		OutHotel outHotel=new OutHotel(iData);
		String str=outHotel.out(101);
		assertEquals("该房间没有客人入住，退房失败！", str);
		EasyMock.verify(iData);
	}
}
