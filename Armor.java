//package gameadventure;


public class Armor {

  private String type;
  private int protection;

  public Armor(String t, int p)
  {
    type = t;
    protection = p;
  }

  public String getArmorType()
  {
    return type;
  }

  public int getArmorProtection()
  {
    return protection;
  }


  public boolean isBetter(Armor A)
  {
    boolean res = false;
    if(protection < A.getArmorProtection())
        res = true;
    else
        res = false;
    return res;
  }

  public void copieArmor( Armor NewArmor)
  {
    type = NewArmor.getArmorType();
    protection = NewArmor.getArmorProtection();
  }



}
