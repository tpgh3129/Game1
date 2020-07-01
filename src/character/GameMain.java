package character;

import java.util.Scanner;
import character.*;

public class GameMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Hero hero = new Hero();

		System.out.println("게임");
		System.out.println("1. 궁수");
		System.out.print("직업의 번호를 입력 :");
		int number = scanner.nextInt();

		if (number == 1) {
			System.out.println("궁수가 선택되었습니다");
			hero = new Archer();
			hero.defense = 5;
			hero.power = 20;
			hero.level = 1;
			hero.hp = 50;
			hero.mp = 10;
		}
		System.out.print("닉네임을 입력하세요 :");
		hero.name = scanner.next();
		System.out.println("닉네임이 입력되었습니다:");
		System.out.println("게임에 입장합니다.");

		while (true) {
			System.out.println("닉네임 : " + hero.name);
			System.out.println("레벨 : " + hero.level);
			System.out.println("힘 : " + hero.power);
			System.out.println("방어력 : " + hero.defense);
			System.out.println("HP : " + hero.hp);
			System.out.println("MP : " + hero.mp);
			System.out.println("메소 : " + hero.money + "원");
			System.out.println("경험치 : " + hero.experience);

			System.out.println("1. 사냥터");
			System.out.println("2. 무기상점");
			System.out.print("입장 장소를 선택하세요 :");
			number = scanner.nextInt();

			if (number == 1) {
				Monster monster = new Monster();
				System.out.println("사냥터 입장");
				System.out.println("1. 고블린");
				System.out.println("전투할 상대 : ");
				number = scanner.nextInt();

				if (number == 1) {
					monster = new Goblin();
					monster.name = "고블린";
					monster.hp = 100;
					monster.mp = 0;
					monster.level = 1;
					monster.power = 20;
					monster.defense = 5;
					monster.money = 10;
					monster.experience = 10;
				}
				while (true) {
					System.out.println("영웅이 공격합니다");
					monster.attacked(((Archer) hero).attack());

					if (monster.hp <= 0) {
						System.out.println("몬스터가 죽었습니다");
						hero.experience += monster.experience;
						hero.money += monster.money;
						break;
					}
					System.out.println("몬스터의 공격입니다");
					hero.attacked(monster.attack());
					if (hero.hp <= 0) {
						System.out.println("영웅이 죽었습니다");
						hero.hp = 1;
						System.out.println("영웅이 체력" + hero.hp + "으로 부활했습니다");
						break;
					}
				}

			} else if (number == 2) {
				WeaponStore weaponStore = new WeaponStore();
				System.out.println("무기 상점에 입장하였습니다");
				System.out.println("1. 빛바랜 석궁 : 100원");
				System.out.println("2. 낡은 가죽 아머: 100원");
				System.out.print("구입 번호 입력 : ");
				number = scanner.nextInt();
				int temp = hero.money;
				if ((hero.money = weaponStore.show(hero.money, number)) != -1) {
					System.out.println("구입 완료");
					if (number == 1)
						hero.power += 5;
					if (number == 2)
						hero.defense += 5;
				} else {
					System.out.println("돈이 부족합니다");
					hero.money = temp;
				}
			}

			hero.level += 1;
			System.out.println("영웅의 레벨이" + hero.level + "이 되었습니다");
			hero.money += hero.level * 50;
			System.out.println("레벨업 보상으로" + hero.level * 50 + "원이 지급되었습니다");
			hero.experience = 0;

		}
	}

}
