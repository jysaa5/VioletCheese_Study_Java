package time_date_ex;

import java.util.Calendar;

public class Calendar_02 {
	public String hundredDaysAfter() {
		// ���ú��� 100�� ���� ��¥�� "2016��1��1��"�� �������� return�ϼ���.
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.DATE, 100);

		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH) + 1;
		int date = cl.get(Calendar.DATE);
		String str = year + "��" + month + "��" + date + "��";

		return str;

	}

	public static void main(String[] args) {

		Calendar_02 cal = new Calendar_02();

		System.out.println(cal.hundredDaysAfter());

	}
}