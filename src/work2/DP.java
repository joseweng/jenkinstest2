package work2;

//DP��ʵ��IData�ӿ�
public class DP implements IData {
	private static String[][] rooms; // ��ʾ����

	public DP() {
		iniRooms();
	}
	public void iniRooms() {
		rooms = new String[HotelConstant.HOTEL_TOTAL_FLOOR][HotelConstant.HOTEL_ROOMS_EVERYFLOOR];
//HotelConstant.HOTEL_TOTAL_FLOOR ��ʾ�Ƶ����
//HotelConstant.HOTEL_ROOMS_EVERYFLOOR ��ʾ�Ƶ�ÿ�㷿���� 
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				rooms[i][j] = HotelConstant.EMPTY;
			}
		}
	}

	public String getStation(int roomNo) {
		return rooms[(roomNo / 100) - 1][(roomNo % 100) - 1];
	}

	public int roomNo(int roomNo) {
		if (HotelConstant.EMPTY.equals(rooms[(roomNo / 100) - 1][(roomNo % 100) - 1])) {
			return roomNo;
		} // ��ʾ����Ϊ��
		else {
			return 0;
		} // ��ʾ����������ס
	}
public static void main(String[] args) {
	IData d=new DP();
	ListHome l=new ListHome(d);
	l.search();
}
	public String in_Out_Room(int roomNo, String name) {
//��name=��EMPTY����ʾ�˷�
		if (name.equals(HotelConstant.EMPTY)) {
			if (roomNo(roomNo) == 0) {
				rooms[(roomNo / 100) - 1][(roomNo % 100) - 1] = name;
				return roomNo + "�˷��ɹ�";
			} else
				return "�÷���û�п�����ס���˷�ʧ��";
		} else if (roomNo(roomNo) == 0) {
			return "�÷����Ѿ��п�����ס";
		} else {
			rooms[(roomNo / 100) - 1][(roomNo % 100) - 1] = name;
			return name + "�ɹ���ס" + roomNo + "����";
		}
	}
}