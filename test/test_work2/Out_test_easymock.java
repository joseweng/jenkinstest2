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
		EasyMock.expect(iData.in_Out_Room(101, "EMPTY")).andReturn("101�˷��ɹ�");
		EasyMock.replay(iData);
		OutHotel outHotel=new OutHotel(iData);
		String str=outHotel.out(101);
		System.out.println(str);
		assertEquals("101�˷��ɹ�",str);
		EasyMock.verify(iData);
	}
	@Test
	public void testOutFailure(){
		iData=EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(101, "EMPTY")).andReturn("�÷���û�п�����ס���˷�ʧ�ܣ�");
		EasyMock.replay(iData);
		OutHotel outHotel=new OutHotel(iData);
		String str=outHotel.out(101);
		assertEquals("�÷���û�п�����ס���˷�ʧ�ܣ�", str);
		EasyMock.verify(iData);
	}
}
