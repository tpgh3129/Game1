package character;

public class Monster extends character {

	public int power;
	public int defense;
	public int meney;
	public int experience;
	public int money;

	public int attack() {
		return power;
	}

	public void attacked(int sum) {

		if (defense >= sum)
			hp = hp - 0;
		else
			hp = hp + defense - sum;
	}
}
