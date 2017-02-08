package com.fererlab.aa.factorial;

import java.util.stream.IntStream;

public class Factorials {

	public int factorial4(int number) {
		int factorial4 = IntStream.rangeClosed(1, number)
			.reduce(1, (left, right) -> left * right);
		System.out.println("factorial4 = " + factorial4);
		return factorial4;
	}

	public int factorial3(int number) {
		int factorial3 = fact3(number);
		System.out.println("factorial3 = " + factorial3);
		return factorial3;
	}

	private int fact3(int num) {
		int fact3 = 1;
		for (int i = 1; i <= num; i++) {
			fact3 = fact3 * i;
		}
		return fact3;
	}

	public int factorial2(int number) {
		int factorial2 = fact2(number);
		System.out.println("factorial2 = " + factorial2);
		return factorial2;
	}

	private int fact2(int num) {
		int fact2 = 1;
		while (num > 0) {
			fact2 = fact2 * num;
			num--;
		}
		return fact2;
	}

	public int factorial1(int number) {
		int factorial1 = fact1(number);
		System.out.println("factorial1 = " + factorial1);
		return factorial1;
	}

	private int fact1(int num) {
		if (num < 1) {
			return 1;
		} else {
			return num * fact1(num - 1);
		}
	}

}
