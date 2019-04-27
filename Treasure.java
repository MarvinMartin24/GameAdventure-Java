//package gameadventure; 

public class Treasure {

  private int numberGold;
  private int numberSilver;
  private int numberPotions;
  private int numberScrolls;


  public Treasure(int g, int silv, int p, int scr)
  {
    numberGold = g;
    numberSilver = silv;
    numberPotions = p;
    numberScrolls = scr;

  }

  public void setNumberPotions(int num)
  {
    numberPotions += num;
  }

  public void setNumberScrolls(int num)
  {
    numberScrolls += num;
  }

  public int getTreasureItems(String item)
  {
    int res = 0;
    if (item.equals("Gold"))
      res = numberGold;
    else if (item.equals("Silver"))
      res = numberSilver;
    else if (item.equals("Potion"))
      res = numberPotions;
    else if (item.equals("Scroll"))
      res = numberScrolls;
    return res;
  }

  public void addTreasure(Treasure NewT)
  {
       numberGold += NewT.getTreasureItems("Gold");
       numberSilver += NewT.getTreasureItems("Silver");
       numberPotions += NewT.getTreasureItems("Potion");
       numberScrolls += NewT.getTreasureItems("Scroll");
  }

}
