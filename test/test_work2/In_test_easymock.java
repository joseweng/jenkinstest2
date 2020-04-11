package test_work2;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;

import work2.IData;
import work2.InHotel;
import work2.OutHotel;

public class In_test_easymock {
	private IData iData =null;
	@Test
	public void testInsuccess(){
		iData=EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(102, "mumu")).andReturn("mumu成功入住102房间");
		EasyMock.replay(iData);
		InHotel inHotel=new InHotel(iData);
		String str=inHotel.in(102, "mumu");
		assertEquals("mumu成功入住102房间", str);
		EasyMock.verify(iData);
	}	@Test
	public void testInFailure(){
		iData=EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(102, "mumu")).andReturn("该房间已经有客人入住");
		EasyMock.replay(iData);
		InHotel inHotel=new InHotel(iData);
		String str=inHotel.in(102, "mumu");
		assertEquals("该房间已经有客人入住", str);
		EasyMock.verify(iData);
	}
}
