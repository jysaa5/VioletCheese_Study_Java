package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1023 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split("\\.");
        System.out.println(str1[0]);
        System.out.println(str1[1]);
        
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1023 Ŭ���� ��