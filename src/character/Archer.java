package character;

import java.util.Scanner;

public class Archer extends Hero {
	public int attack() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. 더블 에로우 ");
		System.out.println("2. 붐 에로우 ");
		System.out.print("공격 번호 : ");
		int number = scanner.nextInt();

		int sum = 0;

		if (number == 1) {
			sum += level * 10;
			sum += power * 10;
			sum += defense * 10;
			System.out.println("데미지는 " + sum + "입니다");
			return sum;
		}

		else if (number == 2) {
			sum += level * 10;
			sum += power * 30;
			sum += defense * 10;
			System.out.println("데미지는 " + sum + "입니다");
			return sum;
		}
		System.out.println("데미지는 " + sum + "입니다");
		return sum;
	}

	public void attacked(int sum) {
		if (defense >= sum)
			hp = hp - 0;
		else
			hp = hp + defense - sum;
	}
}
