package com.violetCheese.intermediate;

//���ٽ�
public class Ex_58_Lambda_01 {

	public static void main(String[] args) {

		//Runnable ����
		//Thread ����
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("hello");
				}

			}

		}).start();

	}

}