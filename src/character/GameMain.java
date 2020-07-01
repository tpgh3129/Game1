package character;

import java.util.Scanner;
import character.*;

public class GameMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Hero hero = new Hero();

		System.out.println("����");
		System.out.println("1. �ü�");
		System.out.print("������ ��ȣ�� �Է� :");
		int number = scanner.nextInt();

		if (number == 1) {
			System.out.println("�ü��� ���õǾ����ϴ�");
			hero = new Archer();
			hero.defense = 5;
			hero.power = 20;
			hero.level = 1;
			hero.hp = 50;
			hero.mp = 10;
		}
		System.out.print("�г����� �Է��ϼ��� :");
		hero.name = scanner.next();
		System.out.println("�г����� �ԷµǾ����ϴ�:");
		System.out.println("���ӿ� �����մϴ�.");

		while (true) {
			System.out.println("�г��� : " + hero.name);
			System.out.println("���� : " + hero.level);
			System.out.println("�� : " + hero.power);
			System.out.println("���� : " + hero.defense);
			System.out.println("HP : " + hero.hp);
			System.out.println("MP : " + hero.mp);
			System.out.println("�޼� : " + hero.money + "��");
			System.out.println("����ġ : " + hero.experience);

			System.out.println("1. �����");
			System.out.println("2. �������");
			System.out.print("���� ��Ҹ� �����ϼ��� :");
			number = scanner.nextInt();

			if (number == 1) {
				Monster monster = new Monster();
				System.out.println("����� ����");
				System.out.println("1. ���");
				System.out.println("������ ��� : ");
				number = scanner.nextInt();

				if (number == 1) {
					monster = new Goblin();
					monster.name = "���";
					monster.hp = 100;
					monster.mp = 0;
					monster.level = 1;
					monster.power = 20;
					monster.defense = 5;
					monster.money = 10;
					monster.experience = 10;
				}
				while (true) {
					System.out.println("������ �����մϴ�");
					monster.attacked(((Archer) hero).attack());

					if (monster.hp <= 0) {
						System.out.println("���Ͱ� �׾����ϴ�");
						hero.experience += monster.experience;
						hero.money += monster.money;
						break;
					}
					System.out.println("������ �����Դϴ�");
					hero.attacked(monster.attack());
					if (hero.hp <= 0) {
						System.out.println("������ �׾����ϴ�");
						hero.hp = 1;
						System.out.println("������ ü��" + hero.hp + "���� ��Ȱ�߽��ϴ�");
						break;
					}
				}

			} else if (number == 2) {
				WeaponStore weaponStore = new WeaponStore();
				System.out.println("���� ������ �����Ͽ����ϴ�");
				System.out.println("1. ���ٷ� ���� : 100��");
				System.out.println("2. ���� ���� �Ƹ�: 100��");
				System.out.print("���� ��ȣ �Է� : ");
				number = scanner.nextInt();
				int temp = hero.money;
				if ((hero.money = weaponStore.show(hero.money, number)) != -1) {
					System.out.println("���� �Ϸ�");
					if (number == 1)
						hero.power += 5;
					if (number == 2)
						hero.defense += 5;
				} else {
					System.out.println("���� �����մϴ�");
					hero.money = temp;
				}
			}

			hero.level += 1;
			System.out.println("������ ������" + hero.level + "�� �Ǿ����ϴ�");
			hero.money += hero.level * 50;
			System.out.println("������ ��������" + hero.level * 50 + "���� ���޵Ǿ����ϴ�");
			hero.experience = 0;

		}
	}

}
