package character;

public class Goblin extends Monster {

	public int attack() {
		System.out.println("데미지는" + power + "입니다");
		return power;
	}

	public void attacked(int sum) {
		if (defense >= sum)
			hp = hp - 0;
		else
			hp = hp = defense - sum;
	}
}
