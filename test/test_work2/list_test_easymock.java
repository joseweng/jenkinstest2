package test_work2;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import work2.HotelConstant;
import work2.IData;
import work2.ListHome;

public class list_test_easymock {
	@Rule
	public SystemOutRule sysRule=new SystemOutRule().enableLog();
	private IData iData;
	@Test
	public void testSearch() {
		// TODO Auto-generated method stub
		iData=EasyMock.createMock(IData.class);
		for (int i = 0; i<HotelConstant.HOTEL_TOTAL_FLOOR; i++) {
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++) {
				EasyMock.expect(iData.getStation((i+1)*100+j+1)).andReturn(HotelConstant.EMPTY);
			}
			}
		EasyMock.replay(iData);
		ListHome list=new ListHome(iData);
		list.search();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i<HotelConstant.HOTEL_TOTAL_FLOOR; i++) {
//打印房间号
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++) {
				if (j + 1 < 10) {
					sb.append(i + 1 + "0" + (j + 1) + "\t");
				} else {
					sb.append(i + 1 + "" + (j + 1) + "\t");
				}
			}
//打印房间状态
			sb.append(System.getProperty("line.separator"));
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++) {
				sb.append(HotelConstant.EMPTY + "\t");
			}
			sb.append(System.getProperty("line.separator"));
		}
		assertEquals(sysRule.getLog(), sb.toString());
		EasyMock.verify(iData);
	}

}
