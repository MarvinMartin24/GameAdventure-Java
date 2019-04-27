//package gameadventure;

import java.util.Random;
 //@authors Alex,Marvin,Laura,Valentine,Stephanie

public class GameAdventure {

    public static void main(String[] args)

    {

      Fighters[] FightersArray = new Fighters[9];
      Fighters NewFighter;
      Weapon[]  WeaponArray = new Weapon[8];
      Armor[] ArmorArray = new Armor[10];
      Treasure[] TreasureOfFighter = new Treasure[9];


      // Data Weapon
      WeaponArray[0] = new Weapon("Sword", 2, 1, 8);
      WeaponArray[1] = new Weapon("Dagger", 3, 1, 4);
      WeaponArray[2] = new Weapon("Venom", 1, 4, 20);
      WeaponArray[3] = new Weapon("Hands", 4, 1, 8);
      WeaponArray[4] = new Weapon("Sword 2", 4, 1, 4);
      WeaponArray[5] = new Weapon("Super Sword", 4, 2, 8);
      WeaponArray[6] = new Weapon("Claws", 2, 11, 20);
      WeaponArray[7] = new Weapon("Lightning Bolts", 1, 21, 40);

      // Data Armor
      ArmorArray[0] = new Armor("Orc Chain Mail", 12);
      ArmorArray[1] = new Armor("None", 0);
      ArmorArray[2] = new Armor("Hide", 14);
      ArmorArray[3] = new Armor("Skin", 3);
      ArmorArray[4] = new Armor("Shield", 2);
      ArmorArray[5] = new Armor("Ninja Chain Mail", 14);
      ArmorArray[6] = new Armor("Dragon Skin", 14);
      ArmorArray[7] = new Armor("Heavy Shield", 4);
      ArmorArray[8] = new Armor("Magic Aura", 15);
      ArmorArray[9] = new Armor("Leather Armor", 10);

      // Data Treasure
      //Gold / Silver / Potion / Scroll
      TreasureOfFighter[0] = new Treasure(1,0,1,0);
      TreasureOfFighter[1] = new Treasure(0,0,1,0);
      TreasureOfFighter[2] = new Treasure(1,1,2,0);
      TreasureOfFighter[3] = new Treasure(0,1,1,0);
      TreasureOfFighter[4] = new Treasure(0,0,2,1);
      TreasureOfFighter[5] = new Treasure(1,3,0,1);
      TreasureOfFighter[6] = new Treasure(0,0,0,0);
      TreasureOfFighter[7] = new Treasure(3,0,0,0);
      TreasureOfFighter[8] = new Treasure (0,0,2,1); //Treasure Start for User


      // Data Fighters
      FightersArray[0] = new Fighters("Orc", 22, WeaponArray[1], ArmorArray[0],  ArmorArray[1],   TreasureOfFighter[0] );
      FightersArray[1] = new Fighters("Nest of snakes", 12, WeaponArray[2], ArmorArray[1],  ArmorArray[1],   TreasureOfFighter[1] );
      FightersArray[2] = new Fighters("Troll", 35, WeaponArray[3], ArmorArray[2],  ArmorArray[1],   TreasureOfFighter[2] );
      FightersArray[3] = new Fighters("Berserker", 28, WeaponArray[4], ArmorArray[3],  ArmorArray[4],   TreasureOfFighter[3] );
      FightersArray[4] = new Fighters("Ninja", 40, WeaponArray[5], ArmorArray[5],  ArmorArray[1],   TreasureOfFighter[4] );
      FightersArray[5] = new Fighters("Dragon", 25, WeaponArray[6], ArmorArray[6],  ArmorArray[1],   TreasureOfFighter[5] );
      FightersArray[6] = new Fighters("Doppleganger", 0, WeaponArray[0], ArmorArray[1],  ArmorArray[7],   TreasureOfFighter[6] );
      FightersArray[7] = new Fighters("Wizard", 150, WeaponArray[7], ArmorArray[8],  ArmorArray[1],   TreasureOfFighter[7] );
      FightersArray[8] = new Fighters("User", 50, WeaponArray[0], ArmorArray[9],  ArmorArray[1],   TreasureOfFighter[8] );

      // Start the Graphics
      HomePage H = new HomePage(FightersArray[8], FightersArray);


    }

}
