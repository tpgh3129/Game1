package character;

public class WeaponStore {
	
		String name;
		
		int commonWeapon= 100;
		int commonShield = 100;
		
		public int show(int money, int number)
		{
			name= "���� ����";
			System.out.println(name+ "���� ������ ��� �ֽ��ϴ�");
			if(number ==1 )
			{
				if(commonWeapon <= money)
					return money - commonWeapon;
			}
			if(number ==2)
			{
				if(commonShield <=money)
					return money - commonShield;
			}
			return -1;
			
		}
		
		
	}
	


