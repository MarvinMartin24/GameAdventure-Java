//package gameadventure;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // Needed for event listener interface
import java.util.Random;
import javax.swing.JOptionPane;
import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.JFrame;



public class GUI extends JFrame
{

  final int WINDOW_WIDTH = 1000;
  final int WINDOW_HEIGHT = 700;

  private ImageIcon img1;
  private ImageIcon[] imgEnnemy = new ImageIcon[7] ;
  private Image image1;
  private Image newimg1;
  private Image[] imageEnnemy = new Image[7];
  private Image[] newimgEnnemy  = new Image[7];

  private JLabel label1;
  private JLabel[] labelEnnemy = new JLabel[7];
  private JLabel UserCounterLabel;
  private JLabel EnnemyCounterLabel;
  private JLabel UserTitle;
  private JLabel EnnemyTitle;
  private JLabel hitPointUser;
  private JLabel hitPointEnnemy;
  private JLabel WeaponUser;
  private JLabel WeaponEnnemy;
  private JLabel UserBreakDefense;
  private JLabel EnnemyBreakDefense;
  private JLabel ArmorEnnemy;
  private JLabel ArmorUser;
  private JLabel GameOverUser;

  private JButton UserSetBreakDefense;
  private JButton UserSetAttackValue;
  private JButton UserAttack;

  private JButton EnnemySetBreakDefense;
  private JButton EnnemySetAttackValue;
  private JButton EnnemyAttack;

  private JPanel panel;

  private String image;

  protected Fighters User;
  protected Fighters Ennemy;
  protected Fighters[] EnnemyArray;

  protected DisplayStuff dStuff;

  protected GridBagConstraints c;

  private int ctrUserTurn = 1;
  private int ctrEnnemyTurn = 1;

  private int nbDeadEnemmies = 0;


  public GUI(Fighters U, Fighters[] FightersArray, DisplayStuff ds)
  {

    int firstEnnemy = 0;

    User = U;
    EnnemyArray = FightersArray;
    Ennemy = EnnemyArray[firstEnnemy];
    dStuff = ds;

    image = extractImage(Ennemy);

    setTitle("Game");
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

    panel = new JPanel(new GridBagLayout());
    c = new GridBagConstraints();

    UserTitle = new JLabel("            " + User.getFighterName());
    UserTitle.setFont(new Font("Calibri", Font.PLAIN, 25));
    c.fill = GridBagConstraints.HORIZONTAL;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    panel.add(UserTitle, c);

    EnnemyTitle = new JLabel("            " + Ennemy.getFighterName());
    EnnemyTitle.setFont(new Font("Calibri", Font.PLAIN, 25));
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weighty = 0.5;
    c.gridx = 1;
    c.gridy = 0;
    panel.add(EnnemyTitle, c);

    UserCounterLabel = new JLabel(" Turn : " + ctrUserTurn + " (Out of: " + User.getWeaponAttackPerTurn() + ")");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 1;
    panel.add(UserCounterLabel, c);

    EnnemyCounterLabel = new JLabel(" Turn: " +  ctrEnnemyTurn  + " (Out of: " + Ennemy.getWeaponAttackPerTurn() + ")");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weighty = 0.5;
    c.gridx = 1;
    c.gridy = 1;
    panel.add(EnnemyCounterLabel, c);
    EnnemyCounterLabel.setVisible(false);

    // Images ------------------------------------------------------------------

    img1 = new ImageIcon(getClass().getResource("Images/User.jpg"));
    image1 = img1.getImage(); // transform it
    newimg1 = image1.getScaledInstance(300, 300,  Image.SCALE_SMOOTH); // scale it the smooth way
    img1 = new ImageIcon(newimg1);  // transform it back
    label1 = new JLabel(img1);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 2;
    panel.add(label1, c);



    imgEnnemy[0] = new ImageIcon(getClass().getResource(image));
    imageEnnemy[0] = imgEnnemy[0].getImage(); // transform it
    newimgEnnemy[0] = imageEnnemy[0].getScaledInstance(300, 300,  Image.SCALE_SMOOTH); // scale it the smooth way
    imgEnnemy[0] = new ImageIcon(newimgEnnemy[0]);  // transform it back
    labelEnnemy[0] = new JLabel(imgEnnemy[0]);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 2;
    panel.add(labelEnnemy[0], c);

    // Label (life, break defense/ Armor, weapon -------------------------------)

    hitPointUser = new JLabel("Life Points : " + User.getHitPoint());
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 3;
    panel.add(hitPointUser, c);

    hitPointEnnemy = new JLabel("Life Points : " + Ennemy.getHitPoint());
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 3;
    panel.add(hitPointEnnemy, c);

    UserBreakDefense = new JLabel("Break Defense : Press Break Defense");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 4;
    panel.add(UserBreakDefense, c);

    EnnemyBreakDefense = new JLabel("Break Defense : Press Break Defense");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 4;
    panel.add(EnnemyBreakDefense, c);
    EnnemyBreakDefense.setVisible(false); //Only Display in the ennemy turn


    ArmorUser = new JLabel("Armor : " + (User.getArmorProtection(1) + User.getArmorProtection(2)) );
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 4;
    panel.add(ArmorUser, c);
    ArmorUser.setVisible(false);  //Only Display in the ennemy turn

    ArmorEnnemy = new JLabel("Armor : " + (Ennemy.getArmorProtection(1) + Ennemy.getArmorProtection(2)) );
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 4;
    panel.add(ArmorEnnemy, c);

    WeaponUser = new JLabel("Weapon Points : Press Set Attack ");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 5;
    panel.add(WeaponUser, c);

    WeaponEnnemy = new JLabel("Weapon Points :" + Ennemy.getTmpAttack());
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 5;
    panel.add(WeaponEnnemy, c);

    GameOverUser = new JLabel("GAME OVER");


    //Button -------------------------------------------------------------------

    UserSetBreakDefense = new JButton("Break Defense");
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 6;
    panel.add(UserSetBreakDefense, c);

    UserSetAttackValue = new JButton("Set Attack");
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 6;
    panel.add(UserSetAttackValue, c);
    UserSetAttackValue.setVisible(false);


    UserAttack = new JButton("FIGHT !");
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 6;
    panel.add(UserAttack, c);
    UserAttack.setVisible(false);

    // -----------------------------------------------------------------------

    EnnemySetBreakDefense = new JButton("Break Defense");
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 6;
    panel.add(EnnemySetBreakDefense, c);
    EnnemySetBreakDefense.setVisible(false);

    EnnemySetAttackValue = new JButton("Set Attack");
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 6;
    panel.add(EnnemySetAttackValue, c);
    EnnemySetAttackValue.setVisible(false);


    EnnemyAttack = new JButton("FIGHT !");
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 6;
    panel.add(EnnemyAttack, c);
    EnnemyAttack.setVisible(false);

    //-------------------------------------------------------------------------

    UserSetBreakDefense.addActionListener(new UserSetBreakDefenseValueListener());
    UserSetAttackValue.addActionListener(new UsersetAttackValueListener());
    UserAttack.addActionListener(new UserAttackListener());

    EnnemySetBreakDefense.addActionListener(new EnnemySetBreakDefenseValueListener());
    EnnemySetAttackValue.addActionListener(new EnnemySetAttackValueListener());
    EnnemyAttack.addActionListener(new EnnemyAttackListener());


    setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
    setLocation(500, 120);
    getContentPane().add(panel);
    setVisible(true);
  }

 // ----------------------------------------------------------------------------

  private class UserSetBreakDefenseValueListener implements ActionListener
  {

      public void actionPerformed(ActionEvent e)
      {
           // White BackGround
           panel.setBackground(Color.WHITE);

           // Display the turns of the User
           UserCounterLabel.setVisible(true);
           UserCounterLabel.setText(" Turn : " + ctrUserTurn + " ( Out of : " + User.getWeaponAttackPerTurn() + " )");

           // Throw the dices & Display the result of the dices game
           User.setAttackPossible();
           UserBreakDefense.setText("Break Defense :" + User.getBreakDefense() + " ("+ User.attackPossible(Ennemy)+")");


           // User lose game of dice
           if ((User.attackPossible(Ennemy) == false))
           {
               // Fail Sound
               PlayBeep("Fail");

               // Say that you cannot attack to the User
               WeaponUser.setText("Impossible to attack this turn");

               // It was the last turn of the user;
               if (ctrUserTurn == User.getWeaponAttackPerTurn())
               {
                   // Ennemy turn restart
                   ctrEnnemyTurn = 1;

                   //From attack mode to Defense mode for User (remove break defense and add armor of the user)
                   UserBreakDefense.setVisible(false);
                   ArmorUser.setVisible(true);

                   //From Defense mode to attack mode for Ennemy (remove armor and add break defense of the ennemy)
                   ArmorEnnemy.setVisible(false);
                   EnnemyBreakDefense.setVisible(true);

                   // display set break defense Button of the Ennemy
                   EnnemySetBreakDefense.setVisible(true);

                   // remove the Button on User side
                   UserCounterLabel.setVisible(false);
                   UserSetBreakDefense.setVisible(false);
                   UserSetAttackValue.setVisible(false);
                   UserAttack.setVisible(false);

               }

               // It was not the last turn of the user;
               else
               {
                 // Next Turn for the user
                 ctrUserTurn++;

                 // display set break defense Button of the User
                 UserSetBreakDefense.setVisible(true);
               }

           }

           // If the User won the dices game
           else
           {
              // BreakDefense Sound
              PlayBeep("BreakDefense");

              // lightGray BackGround
              panel.setBackground(Color.lightGray);

              // Remove the Set break Defense Button
              UserSetBreakDefense.setVisible(false);

              //Display the set Attack Button
              UserSetAttackValue.setVisible(true);
           }
       }
   }

  private class UsersetAttackValueListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
           // WHITE BackGround
           panel.setBackground(Color.WHITE);

            //Determine the weapon point of the User by using attack()
           WeaponUser.setText("Weapon Points :" + User.attack());

           //remove the Button set attack of the User
           UserSetAttackValue.setVisible(false);

           //Activate the Button attack of the User
           UserAttack.setVisible(true);
      }
   }

  private class UserAttackListener implements ActionListener
  {

      public void actionPerformed(ActionEvent e)
      {
          // Attack Sound
          PlayBeep("Attack");

          // lightGray BackGround
          panel.setBackground(Color.gray);

          // Ennemy take damage
          Ennemy.takesDamage(User.getTmpAttack());

          // Display the new life point of the Ennemy
          hitPointEnnemy.setText("Life Points : " + Ennemy.getHitPoint());

          //Ennemy is dead
          if (Ennemy.isAlive() == false)
          {

              // Rest the User Turns
              ctrUserTurn = 1;

              // Display the game over on the ennemy side
              hitPointEnnemy.setText("Game Over");

              PlayBeep("tada");

              // Take the weapon of the dead ennemy if this last one is better and possible
              //If the weapon is on the body of ennemy you can't take it
              if (User.isWeaponBetter(Ennemy) == true && !(Ennemy.getWeaponType().equals("Venom") || Ennemy.getWeaponType().equals("Hands") || Ennemy.getWeaponType().equals("Claws")))
              {

                  String[] rep2 = {"YES", "NO"};
                  JOptionPane jopo = new JOptionPane();
                  int rang1 = jopo.showOptionDialog(null,
                    "Take his weapon ?",
                    "His weapon is better than yours !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    rep2,
                    rep2[1]);


                //If user want to keep its weapon
                  if(rep2[rang1]=="YES")
                  {
                    User.changeWeapon(Ennemy.getWeapon());
                    jopo.showMessageDialog(null, "You Just win :\n" + User.getWeaponType() +
                      " with " + User.getWeaponAttackPerTurn() + " Attack/Turn " +
                       "\nDamage : " + User.getWeaponDamage(0) + " - " + User.getWeaponDamage(1), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

                    // Display in another GUI User Information
                    dStuff.close();
                    dStuff = new DisplayStuff(User);
                  }
                  //If user don't want to keep it
                  if(rep2[rang1]=="NO")
                  {
                    jopo.showMessageDialog(null, "You refuse to take his Weapon", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                  }

              }

              // Take the Armor 1  of the dead ennemy if this last one is better and possible
              if (User.isArmorBetter(Ennemy, 1, 1) == true && !(Ennemy.getArmorType(1).equals("Hide") || Ennemy.getArmorType(1).equals("Skin") || Ennemy.getArmorType(1).equals("Dragon Skin")))
              {

                  String[] rep3 = {"YES", "NO"};
                  JOptionPane jopn = new JOptionPane();
                  int rang2 = jopn.showOptionDialog(null,
                    "Take his First Armor ?",
                    "His First Armor is better than yours !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    rep3,
                    rep3[1]);



                  if(rep3[rang2]=="YES")
                  {
                    User.changeArmor(Ennemy.getArmor(1),1);

                    jopn.showMessageDialog(null, "You Just win :\n" + User.getArmorType(1) +
                      " with " + User.getArmorProtection(1) + " protection " +
                      "\nYour second Armor is " + User.getArmorType(2) +
                      " with " + User.getArmorProtection(2) + " protection ", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

                    // Display in another GUI User Information
                    dStuff.close();
                    dStuff = new DisplayStuff(User);

                  }

                  if(rep3[rang2]=="NO")
                  {
                    jopn.showMessageDialog(null, "You refuse to take his First Armor", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                  }

              }

              // Take the Armor 2 of the dead ennemy if this last one is better
              if (User.isArmorBetter(Ennemy, 2, 2) == true )
              {

                  String[] rep4 = {"YES", "NO"};
                  JOptionPane jopm = new JOptionPane();
                  int rang3 = jopm.showOptionDialog(null,
                    "Take his First Armor ?",
                    "His First Armor is better than yours !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    rep4,
                    rep4[1]);



                  if(rep4[rang3]=="YES")
                  {
                    User.changeArmor(Ennemy.getArmor(2),2);

                    jopm.showMessageDialog(null, "You Just win a 2ed Armor:\n" + User.getArmorType(2) +
                      " with " + User.getArmorProtection(2) + " protection ", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

                    // Display in another GUI User Information
                    dStuff.close();
                    dStuff = new DisplayStuff(User);

                  }

                  if(rep4[rang3]=="NO")
                  {
                    jopm.showMessageDialog(null, "You refuse to take his second Armor", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                  }

              }

              // Take the treasure of the dead ennemy
              User.stealTreasure(Ennemy);

              // Display your last gain
              JOptionPane jopa = new JOptionPane();

              //Print the ennemy's treasure
              jopa.showMessageDialog(null, "You steal his treasure: \nGold: " + Ennemy.getTreasureItems("Gold")
                      + "\nSilver: " + Ennemy.getTreasureItems("Silver")
                      + "\nPotion: " + Ennemy.getTreasureItems("Potion")
                      + "\nScroll: " + Ennemy.getTreasureItems("Scroll") , "ENNEMY TREASURE", JOptionPane.INFORMATION_MESSAGE);
              //Print your new treasure after keep ennemy's treasure
              jopa.showMessageDialog(null, "This is your new treasure: \nGold: " + User.getTreasureItems("Gold")
                      + "\nSilver: " + User.getTreasureItems("Silver")
                      + "\nPotion: " + User.getTreasureItems("Potion")
                      + "\nScroll: " + User.getTreasureItems("Scroll") , "YOUR FINAL TREASURE", JOptionPane.INFORMATION_MESSAGE);
              // Display in another GUI User Information

              dStuff.close();
              dStuff = new DisplayStuff(User);

              // Menu between two fights
              String[] rep = {"Rest", "Next fighter", "Potion", "Scroll", "Quit"};
              JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
              JOptionPane jop3 = new JOptionPane(), jop4 = new JOptionPane();
              int rang = jop.showOptionDialog(null,
                "What is your choice ?",
                "You win !",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                rep,
                rep[3]);

              // User Choose to take some Rest
              if(rep[rang]=="Rest")
              {
                  User.isResting();
                  jop3.showMessageDialog(null, "Number of hitpoint after rest : " + User.getHitPoint(), "HITPOINTS", JOptionPane.INFORMATION_MESSAGE);
              }

              // User Choose to take some Potions
              if(rep[rang]=="Potion")
              {
                  if(User.getTreasureItems("Potion") == 0)
                    jop4.showMessageDialog(null, "You have zero potion, sorry.. ", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                else
                {



                    JOptionPane jop9 = new JOptionPane();
                    int number;
                    //Ask how many potion to drink in function to the number of potion he have
                    do
                    {
                        String answer = jop9.showInputDialog(null, "Your number of potions is "+User.getTreasureItems("Potion"), "Takes potions", JOptionPane.QUESTION_MESSAGE);
                        number = Integer.parseInt(answer);

                    }while(number>User.getTreasureItems("Potion") || number < 0);

                    for(int y=0;y<number;y++)

                    jop2.showMessageDialog(null, "Number of hitpoint before potions : " + User.getHitPoint(), "HITPOINTS", JOptionPane.INFORMATION_MESSAGE);

                    {
                        User.isDrinkingPotion();
                    }

                    jop4.showMessageDialog(null, "Number of hitpoint after potions : " + User.getHitPoint(), "HITPOINTS", JOptionPane.INFORMATION_MESSAGE);
                    User.addNumberPotions(-number);

                    // Display in another GUI User Information
                    dStuff.close();
                    dStuff = new DisplayStuff(User);

                }
              }

              // User Choose to take 1 Scrool
              if(rep[rang]=="Scroll")
              {
                  if(User.getTreasureItems("Scroll")==0)
                      jop4.showMessageDialog(null, "You have zero scroll, sorry.. ", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                  else
                  {

                      jop2.showMessageDialog(null, "Number of hitpoint before scrolls : " + User.getHitPoint(), "HITPOINTS", JOptionPane.INFORMATION_MESSAGE);

                      User.isDrinkingScroll();


                      jop4.showMessageDialog(null, "Number of hitpoint after scrolls : " + User.getHitPoint(), "HITPOINTS", JOptionPane.INFORMATION_MESSAGE);
                      User.addNumberScrolls(-1);

                      // Display in another GUI User Information
                      dStuff.close();
                      dStuff = new DisplayStuff(User);

                  }
              }
              // User Choose to Stop playing
              if(rep[rang]=="Quit")
              {
                  System.exit(0);
              }

            // Close the Gui about the user details
            dStuff.close();

            // User is dead because of the scroll
            if (User.isAlive() == false)
            {
                PlayBeep("GameOver");
                // Display that the user is game over
                panel.removeAll();
                panel.add(GameOverUser);
                GameOverUser.setFont(new Font("Serif", Font.PLAIN, 120));





            }
            //User is not dead because of the scroll
            else
            {
              // Against a new fighter come back to breakDefense mode (remove attack first)
              UserAttack.setVisible(false);
              UserSetBreakDefense.setVisible(true);

              //Label From attack mode to Defense mode for Ennemy (remove break defense and add armor of the Ennemy)
              EnnemyBreakDefense.setVisible(false);
              ArmorEnnemy.setVisible(true);

              //From Defense mode to attack mode for User (remove armor and add break defense of the User)
              ArmorUser.setVisible(false);
              UserBreakDefense.setVisible(true);


              //Update User lifepoint after the menu
              hitPointUser.setText("Life Points : " + User.getHitPoint());

              //Update User Armor points after the menu but don't display it
              ArmorUser.setText("Armor: " + (User.getArmorProtection(1) + User.getArmorProtection(2)) );
              ArmorUser.setVisible(false);



              // Increase the number of dead Ennemies
              nbDeadEnemmies++;


              //Remove the image of the previous fighter
              panel.remove(labelEnnemy[nbDeadEnemmies-1]);

              //Udate Fighter
              if (nbDeadEnemmies == 6)  // Speacial case of the Doppleganger
              {
                Ennemy = new Fighters("Doppleganger", User.getHitPoint(), User.getWeapon(), User.getArmor(1), EnnemyArray[6].getArmor(2),  User.getTreasure() );
                Ennemy.setWeaponAttackPerTurn(1);
              }
              else
              {
                Ennemy = EnnemyArray[nbDeadEnemmies];
              }


              //Update Title
              EnnemyTitle.setText("           "+Ennemy.getFighterName());
              EnnemyTitle.setFont(new Font("Calibri", Font.PLAIN, 25));

              //Update lifepoint
              hitPointEnnemy.setText("Life Points : " + Ennemy.getHitPoint());

              //Update Armor
              ArmorEnnemy.setText("Armor : " + (Ennemy.getArmorProtection(1) + Ennemy.getArmorProtection(2)));

              //Update weap
              WeaponEnnemy.setText("Weapon Points : " + Ennemy.getTmpAttack());
              dStuff = new DisplayStuff(User);


              //Add the image of the new fighter
              image = extractImage(Ennemy);
              imgEnnemy[nbDeadEnemmies] = new ImageIcon(getClass().getResource(image));
              imageEnnemy[nbDeadEnemmies] = imgEnnemy[nbDeadEnemmies].getImage(); // transform it
              newimgEnnemy[nbDeadEnemmies] = imageEnnemy[nbDeadEnemmies].getScaledInstance(300, 300,  Image.SCALE_SMOOTH); // scale it the smooth way
              imgEnnemy[nbDeadEnemmies] = new ImageIcon(newimgEnnemy[nbDeadEnemmies]);  // transform it back
              labelEnnemy[nbDeadEnemmies] = new JLabel(imgEnnemy[nbDeadEnemmies]);
              c.gridx = 1;
              c.gridy = 2;
              panel.add(labelEnnemy[nbDeadEnemmies], c);
            }
          }

          // Ennemy is alive
          else
          {
            // It is the last turn of the User
            if (ctrUserTurn == User.getWeaponAttackPerTurn())
            {
              // Reset the Ennemy turn
              ctrEnnemyTurn = 1;

              //Label From attack mode to Defense mode for User (remove break defense and add armor of the User)
              UserBreakDefense.setVisible(false);
              ArmorUser.setVisible(true);

              //From Defense mode to attack mode for Ennemy (remove armor and add break defense of the Ennemy)
              ArmorEnnemy.setVisible(false);
              EnnemyBreakDefense.setVisible(true);

              // Break defense mode for the Ennemy (Display the Ennemy set Break Button)
              EnnemySetBreakDefense.setVisible(true);

              // Remove Attack mode for the User (remove the User attack Button)
              UserAttack.setVisible(false);

              // Remove the turn label of the User
              UserCounterLabel.setVisible(false);


            }

            // It is not the last turn of the User
            else
            {
              // User go to the next turn
              ctrUserTurn++;

              // Get back to the break defense mode for User (add Set Break Defense Button of the User)
              UserSetBreakDefense.setVisible(true);

              // End of the attack mode for User (Remove attack Button of the User)
              UserAttack.setVisible(false);
            }
          }
      }
   }

// -----------------------------------------------------------------------------

  private class EnnemySetBreakDefenseValueListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
         // White BackGround
         panel.setBackground(Color.WHITE);

         // Display the turns of the Ennemy
         EnnemyCounterLabel.setVisible(true);
         EnnemyCounterLabel.setText(" Turn : " + ctrEnnemyTurn + " ( Out of: " + Ennemy.getWeaponAttackPerTurn() + " )");

         // Throw the dices & Display the result of the dices game
         Ennemy.setAttackPossible();
         EnnemyBreakDefense.setText("Break Defense :" + Ennemy.getBreakDefense() + " ("+ Ennemy.attackPossible(User)+")");


         // Ennemy lose game of dice
         if ((Ennemy.attackPossible(User) == false))
         {
             // Fail Sound
             PlayBeep("Fail");

             // Say that you cannot attack to the Ennemy
             WeaponEnnemy.setText("Impossible to attack this turn");

             // It was the last turn of the Ennemy;
             if (ctrEnnemyTurn == Ennemy.getWeaponAttackPerTurn())
             {
                 // User turn restart
                 ctrUserTurn = 1;

                 //Label From attack mode to Defense mode for Ennemy (remove break defense and add armor of the Ennemy)
                 EnnemyBreakDefense.setVisible(false);
                 ArmorEnnemy.setVisible(true);

                 //From Defense mode to attack mode for User (remove armor and add break defense of the User)
                 ArmorUser.setVisible(false);
                 UserBreakDefense.setVisible(true);

                 // display set break defense Button of the User
                 UserSetBreakDefense.setVisible(true);

                 // remove the Button on Ennemy side
                 EnnemyCounterLabel.setVisible(false);
                 EnnemySetBreakDefense.setVisible(false);
                 EnnemySetAttackValue.setVisible(false);
                 EnnemyAttack.setVisible(false);

             }

             // It was not the last turn of the Ennemy;
             else
             {
               // Next Turn for the Ennemy
               ctrEnnemyTurn++;

               // display set break defense Button of the Ennemy
               EnnemySetBreakDefense.setVisible(true);
             }

         }

         // If the Ennemy won the dices game
         else
         {
             // BreakDefense Sound
             PlayBeep("BreakDefense");

             // lightGray BackGround
             panel.setBackground(Color.lightGray);

            // From set break defense mode to set attack mode for the Ennemy (Remove the Set break Defense Button of the Ennemy)
            EnnemySetBreakDefense.setVisible(false);

            //Display the set Attack Button of the Ennemy
            EnnemySetAttackValue.setVisible(true);
         }
     }
  }

  private class EnnemySetAttackValueListener implements ActionListener
  {

      public void actionPerformed(ActionEvent e)
      {
           // WHITE BackGround
           panel.setBackground(Color.WHITE);

           //Determine the weapon point of the Ennemy by using attack()
           WeaponEnnemy.setText("Weapon Points :" + Ennemy.attack());

           //remove the Button set attack of the Ennemy
           EnnemySetAttackValue.setVisible(false);

           //Activate the Button attack of the Ennemy
           EnnemyAttack.setVisible(true);
      }
  }

  private class EnnemyAttackListener implements ActionListener
  {

      public void actionPerformed(ActionEvent e)
      {
          // Attack Sound
          PlayBeep("Attack");

          // lightGray BackGround
          panel.setBackground(Color.gray);

          // User take damage
          User.takesDamage(Ennemy.getTmpAttack());


          // User is dead
          if (User.isAlive() == false)
          {
              PlayBeep("GameOver");
              // Display that the user is game over
              panel.removeAll();
              dStuff.close();
              panel.add(GameOverUser);
              GameOverUser.setFont(new Font("Serif", Font.PLAIN, 120));


          }

          // User is alive
          else
          {
            // Display the new life point of the User
            hitPointUser.setText("Life Points : " + User.getHitPoint());

            // It is the last turn of the Ennemy
            if (ctrEnnemyTurn == Ennemy.getWeaponAttackPerTurn())
            {
              // Reset the user turn
              ctrUserTurn = 1;

              //Label From attack mode to Defense mode for Ennemy (remove break defense and add armor of the Ennemy)
              EnnemyBreakDefense.setVisible(false);
              ArmorEnnemy.setVisible(true);

              //From Defense mode to attack mode for User (remove armor and add break defense of the User)
              ArmorUser.setVisible(false);
              UserBreakDefense.setVisible(true);

              // Break defense mode for the User (Display the User set Break Button)
              UserSetBreakDefense.setVisible(true);

              // Remove Attack mode for the Ennemy (remove the Ennemy attack Button)
              EnnemyAttack.setVisible(false);

              // Remove the turn label of the Ennemy
              EnnemyCounterLabel.setVisible(false);

            }

            // It is not the last turn of the Ennemy
            else
            {
              // Ennemy go to the next turn
              ctrEnnemyTurn++;

              // Get back to the break defense mode for Ennemy (add Set Break Defense Button of the Ennemy)
              EnnemySetBreakDefense.setVisible(true);

              // End of the attack mode for Ennemy (Remove attack Button of the Ennemy)
              EnnemyAttack.setVisible(false);
            }

          }

      }

  }

// -----------------------------------------------------------------------------

  public String extractImage(Fighters f)
  {
    String image = null;
    switch(f.getFighterName()) {
      case "Orc":
        image = "Images/Ocre.png";
        break;
      case "Nest of snakes":
        image = "Images/Snake.jpg";
        break;
      case "Troll":
        image = "Images/Troll.jpg";
        break;
      case "Berserker":
      image = "Images/Berserker.jpg";
        break;
      case "Ninja":
      image = "Images/Ninja.jpg";
        break;
      case "Dragon":
      image = "Images/Dragon.jpg";
        break;
      case "Doppleganger":
      image = "Images/User.jpg";
        break;
      case "Wizard":
      image = "Images/Wizard.jpg";
        break;
      }

      return image;
  }

  public void PlayBeep(String s)
  {
        String sound = "/Sound/AttackSound.wav";
        if (s.equals("Attack"))
          sound = "/Sound/AttackSound.wav";
        else if (s.equals("BreakDefense"))
          sound = "/Sound/BreakDefense.wav";
        else if (s.equals("Fail"))
          sound = "/Sound/Fail.wav";
        else if (s.equals("GameOver"))
          sound = "/Sound/GameOver.wav";
        else if (s.equals("tada"))
          sound = "/Sound/tada.wav";


        AudioClip clip = Applet.newAudioClip(getClass().getResource(sound));
        clip.play();
  }


}
