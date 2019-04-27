//package gameadventure;

public class Weapon {

  private String type;
  private int attackPerTurn;
  private int minDamage;
  private int maxDamage;

  public Weapon(String t, int apt, int min, int max)
  {
    type = t;
    attackPerTurn = apt;
    minDamage = min;
    maxDamage = max;

  }

  public String getWeaponType()
  {
    return type;
  }

  public int getWeaponAttackPerTurn()
  {
    return attackPerTurn;
  }

  public void setWeaponAttackPerTurn(int i)
  {
     attackPerTurn = i;
  }

  public int getWeaponMinDamage()
  {
    return minDamage;
  }

  public int getWeaponMaxDamage()
  {
    return maxDamage;
  }

  public boolean isBetter(Weapon f)
  {

    double ValueUser;
    double ValueFighter;
    boolean res= false;

    ValueUser=(attackPerTurn*(minDamage+maxDamage)/2); //9
    ValueFighter=(f.getWeaponAttackPerTurn()*(f.getWeaponMinDamage()+f.getWeaponMaxDamage())/2); //2.5

    if(ValueUser < ValueFighter)
        res = true;
    else
        res = false;
    return res;

  }

  public void copieWeapon( Weapon NewWeapon)
  {
    type = NewWeapon.getWeaponType();
    attackPerTurn = NewWeapon.getWeaponAttackPerTurn();
    minDamage = NewWeapon.getWeaponMinDamage();
    maxDamage = NewWeapon.getWeaponMaxDamage();
  }


}
