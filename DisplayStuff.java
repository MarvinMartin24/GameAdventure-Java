//package gameadventure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // Needed for event listener interface
import java.util.Random;
import javax.swing.JOptionPane;
import java.applet.Applet;


public class DisplayStuff extends JFrame {


    final int WINDOW_WIDTH = 300;
    final int WINDOW_HEIGHT = 400;

     //stuff
  private JLabel Potion;
  private JLabel Scroll;
  private JLabel Gold;
  private JLabel Silver;
  private JLabel label;
  private JLabel Weapon;
  private JLabel Armor1;
  private JLabel Armor2;

  private ImageIcon potion;
  private ImageIcon scroll;
  private ImageIcon gold;
  private ImageIcon silver;

  private Image imPotion;
  private Image imScroll;
  private Image imGold;
  private Image imSilver;

  private Image resize;

  private JPanel panel;

  protected GridBagConstraints c;

  private int ctrUserTurn = 1;
  private int ctrEnnemyTurn = 1;

  public DisplayStuff(Fighters U)
  {


   panel = new JPanel(new GridBagLayout());
    c = new GridBagConstraints();


    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

    //------------------------IMAGE--------------------------------

    potion = new ImageIcon(getClass().getResource("Images/po.jpg"));
    imPotion = potion.getImage();
    resize = imPotion.getScaledInstance(50,50, Image.SCALE_SMOOTH);
    potion = new ImageIcon(resize);
    label = new JLabel(potion);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    panel.add(label,c);

    scroll = new ImageIcon(getClass().getResource("Images/sc.jpg"));
    imScroll = scroll.getImage();
    resize = imScroll.getScaledInstance(50,50, Image.SCALE_SMOOTH);
    scroll = new ImageIcon(resize);
    label = new JLabel(scroll);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 2;
    panel.add(label,c);

    gold = new ImageIcon(getClass().getResource("Images/go.jpg"));
    imGold = gold.getImage();
    resize = imGold.getScaledInstance(50,50, Image.SCALE_SMOOTH);
    gold = new ImageIcon(resize);
    label = new JLabel(gold);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 3;
    panel.add(label,c);

    silver = new ImageIcon(getClass().getResource("Images/si.jpg"));
    imSilver = silver.getImage();
    resize = imSilver.getScaledInstance(50,50, Image.SCALE_SMOOTH);
    silver = new ImageIcon(resize);
    label = new JLabel(silver);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 4;
    panel.add(label,c);



     // --------------------------STUFF-----------------------------------------
    Potion = new JLabel("Potions : " + U.getTreasureItems("Potion"));
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 1;
    panel.add(Potion, c);

    Scroll = new JLabel("Scroll : " + U.getTreasureItems("Scroll"));
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 2;
    panel.add(Scroll, c);

    Gold = new JLabel("Gold : " + U.getTreasureItems("Gold"));
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 3;
    panel.add(Gold, c);

    Silver = new JLabel("Silver : " + U.getTreasureItems("Silver"));
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 4;
    panel.add(Silver, c);

    Weapon = new JLabel("Current Weapon : " +U.getWeaponType());
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 7;
    panel.add(Weapon, c);

    Armor1 = new JLabel("Current Armor : "+U.getArmorName1());
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 9;
    panel.add(Armor1, c);

    Armor2 = new JLabel("Current Armor 2 : "+ U.getArmorName2());
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 11;
    panel.add(Armor2, c);

    Potion.setText("Potion : "+ U.getTreasureItems("Potion"));
    Scroll.setText("Scroll : "+U.getTreasureItems("Scroll"));
    Gold.setText("Gold : " +U.getTreasureItems("Gold"));
    Silver.setText("Silver : " +U.getTreasureItems("Silver"));

    //-----------------------Weapon/Armor------------------------------
    Weapon.setText("Current Weapon : " +U.getWeaponType());
    Armor1.setText("Current Armor : "+U.getArmorName1());
    Armor2.setText("Current Armor 2 : "+ U.getArmorName2());

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocation(170,250);
    getContentPane().add(panel);
    setVisible(true);



}
  public void close()
  {
    setVisible(false);
  }


}
