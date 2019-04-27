//package gameadventure;

import java.util.ArrayList;
import java.util.Random;

public class Fighters
{
    private String name;
    private int hitPoint;
    private Weapon weap;
    private Armor arm1;
    private Armor arm2;
    private Treasure tre;
    private int tmpAttack;
    private int breakDefense;


    public Fighters(String n, int hp, Weapon wp, Armor a1, Armor a2, Treasure trt)
    {
        name = n;
        hitPoint = hp;
        weap = wp;
        arm1 = a1;
        arm2 = a2;
        tre = trt;
        tmpAttack = 0;
        breakDefense =0;


    }

    public String getFighterName()
    {
      return name;
    }

    public int getHitPoint()
    {
        return hitPoint;
    }

//Weapon Methods----------------------------------------------------------------

    public Weapon getWeapon()
    {
      return weap;
    }

    public String getWeaponType()
    {
      return weap.getWeaponType();
    }

    public int getWeaponAttackPerTurn()
    {
        return weap.getWeaponAttackPerTurn();
    }

    public void setWeaponAttackPerTurn(int i)
    {
        weap.setWeaponAttackPerTurn(i);
    }

    public int getWeaponDamage(int i)
    {
        int damage = 0;

        if(i == 0)
          damage =  weap.getWeaponMinDamage();
        if(i == 1)
          damage =  weap.getWeaponMaxDamage();
        return damage;
    }

    public boolean isWeaponBetter(Fighters F)
    {

      return weap.isBetter(F.getWeapon());

    }

    public void changeWeapon(Weapon NewWeapon)
    {
      weap.copieWeapon(NewWeapon);
    }


//Armor Methods----------------------------------------------------------------

    public Armor getArmor(int i)
    {
      Armor res = new Armor("Error",0);
      if ( i == 1 )
        res = arm1;
      if ( i == 2 )
        res = arm2;
      return res;
    }

    public String getArmorName1()
    {
        return arm1.getArmorType();
    }

     public String getArmorName2()
    {
        return arm2.getArmorType();
    }

    public String getArmorType(int i)
    {
      String res = new String();
      if ( i == 1 )
        res = arm1.getArmorType();
      if ( i == 2 )
        res = arm2.getArmorType();
      return res;
    }

    public int getArmorProtection(int i)
    {
      int res = 0;
      if ( i == 1 )
        res = arm1.getArmorProtection();
      if ( i == 2 )
        res = arm2.getArmorProtection();
      return res;
    }

    public boolean isArmorBetter(Fighters F, int i, int j) // i is armor index of the user, j is armor index of the Ennemy
    {

      boolean res = false;

      if(i == 1)
      {
          if(j == 1)
            res =  arm1.isBetter(F.getArmor(1));
          if(j == 2)
            res =  arm1.isBetter(F.getArmor(2));
      }

      if(i == 2)
      {
          if(j == 1)
            res =  arm2.isBetter(F.getArmor(1));
          if(j == 2)
            res =  arm2.isBetter(F.getArmor(2));
      }

      return res;

    }

    public void changeArmor(Armor NewArmor, int i)
    {

      if(i == 1)
        arm1.copieArmor(NewArmor);
      if(i == 2)
        arm2.copieArmor(NewArmor);
    }

//Treasure Methods--------------------------------------------------------------

    public Treasure getTreasure()
    {
      return tre;
    }

    public int getTreasureItems(String item)
    {
      int res = 0;
      if (item.equals("Gold"))
        res = tre.getTreasureItems("Gold");
      else if (item.equals("Silver"))
        res = tre.getTreasureItems("Silver");
      else if (item.equals("Potion"))
        res = tre.getTreasureItems("Potion");
      else if (item.equals("Scroll"))
        res = tre.getTreasureItems("Scroll");
      return res;
    }

    public void stealTreasure(Fighters E)
    {
     tre.addTreasure(E.getTreasure());
    }

    public void addNumberPotions(int num)
    {
      tre.setNumberPotions(num);
    }

    public void addNumberScrolls(int num)
    {
      tre.setNumberScrolls(num);
    }


// Set BreakDefense Methods ----------------------------------------------------

    public void setAttackPossible()
    {
      Random rand=new Random();
      breakDefense=rand.nextInt(21);
    }

    public boolean attackPossible(Fighters f)//test if someone can attack
    {
        boolean res = false;
        if( breakDefense > (f.getArmorProtection(1) + f.getArmorProtection(2)) )
            res = true;
        else
            res = false;
        return res;
    }

    public int getBreakDefense()
    {
      return breakDefense;
    }

// Set Attack Methods ----------------------------------------------------------

    public int attack()//choose value of damage when someone attack
    {
        int value;
        int MaxDamage = weap.getWeaponMaxDamage();
        int MinDamage = weap.getWeaponMinDamage();
        Random rand=new Random();
        value=rand.nextInt((MaxDamage-MinDamage)+1)+MinDamage;
        tmpAttack = value;
        return value;

    }

    public int getTmpAttack()
    {
      return tmpAttack;
    }

    public void takesDamage(int ValueDamage)//Remove hitpoint when someone hit
    {
        hitPoint=hitPoint-ValueDamage;
    }

    public boolean isAlive()//test to known if someone is still alive
    {
        boolean res = true;
        if(hitPoint>0)
            res =  true;
        else
            res = false;
        return res;

    }

// Menu Methods (between 2 fights) ---------------------------------------------

    public void isResting()//if he decide to rest
    {
        int value,value2;
        value=0;
        value2=0;

        Random rand=new Random();
        value=rand.nextInt((2-1)+1)+1;

        if(value == 1)
        {
            value2 = rand.nextInt((20-11)+1)+11;
            hitPoint += value2;
        }
            else
        {}
    }

    public void isDrinkingPotion() //if he decide to drink a potion
    {
        int Healing_Hurting,value,i;
        Random rand=new Random();

        //Caracteristics about potion
        Healing_Hurting=rand.nextInt((2-1)+1)+1; //if 1 potion is Healing elsif 2 potion is Hurting
        if(Healing_Hurting==1)//if healing potion
            value=rand.nextInt((30-5)+1)+5; //choose a value between 5 and 30 (number of hitpoints)
        else
            value=rand.nextInt((20-1)+1)+1; //choose a value between 1 and 20 (number of hitpoints)

        //drink potion
        if(Healing_Hurting==1)//if healing potion
        {
            if(value<11)
            {
                i=rand.nextInt(10);
                if(i<3)//30%
                    hitPoint += value;
                else{}
            }
            if(value>10 && value<21)
            {
                i=rand.nextInt(10);
                if(i<4)//40%
                    hitPoint += value;
                else{}
            }
            if(value>20)
            {
                i=rand.nextInt(10);
                if(i<2)//20%
                    hitPoint += value;
                else{}
            }
        }
        else //if hurting potion
        {
                i=rand.nextInt(10);
                if(i<1) //10%
                    hitPoint -= value;
                else{}
        }
    }

    public void isDrinkingScroll() //if the user choose to drink a scroll
    {
            int value;
            Random rand=new Random();

            value=rand.nextInt(3);
            System.out.print(value);

            if(value==0)
                hitPoint *= 2;
            else if(value==1)
                hitPoint=0;
            else{}

    }

}
