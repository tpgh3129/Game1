package character;

public class Hero extends character {

	public int power;
	public int defense;
	public int money = 0;
	public int experience = 0;

	public void attacked(int sum) {

		if (defense >= sum)
			hp = hp - 0;
		else
			hp = hp + defense - sum;

	}

}
