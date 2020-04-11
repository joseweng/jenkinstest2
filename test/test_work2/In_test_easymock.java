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
		EasyMock.expect(iData.in_Out_Room(102, "mumu")).andReturn("mumu�ɹ���ס102����");
		EasyMock.replay(iData);
		InHotel inHotel=new InHotel(iData);
		String str=inHotel.in(102, "mumu");
		assertEquals("mumu�ɹ���ס102����", str);
		EasyMock.verify(iData);
	}	@Test
	public void testInFailure(){
		iData=EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(102, "mumu")).andReturn("�÷����Ѿ��п�����ס");
		EasyMock.replay(iData);
		InHotel inHotel=new InHotel(iData);
		String str=inHotel.in(102, "mumu");
		assertEquals("�÷����Ѿ��п�����ס", str);
		EasyMock.verify(iData);
	}
}
