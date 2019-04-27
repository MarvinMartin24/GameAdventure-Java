//package gameadventure;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;





public class HomePage extends JFrame
{

  final int WINDOW_WIDTH = 1400;
  final int WINDOW_HEIGHT = 900;

  private ImageIcon img1;
  private Image image1;
  private Image newimg1;


  private JLabel HomeImage;
  private JLabel HomeTitle;

  private JPanel panel;

  protected Fighters User;
  protected Fighters[] EnnemyArray;

  private JButton StartButton;
  private JButton QuitButton;

  public HomePage(Fighters U, Fighters[] FightersArray)
  {

    User = U;
    EnnemyArray = FightersArray;

    setTitle("Welcome to Game Adventure !");
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);


    panel = new JPanel();
    panel.setBackground(Color.BLACK);

    HomeTitle = new JLabel("Adventure Game");
    HomeTitle.setForeground(Color.WHITE);
    HomeTitle.setFont(new Font("Serif", Font.PLAIN, 100));
    panel.add(HomeTitle);



    // Images ------------------------------------------------------------------

    img1 = new ImageIcon(getClass().getResource("Images/HomePage.jpg"));
    HomeImage = new JLabel(img1);
    panel.add(HomeImage);



    //Button -------------------------------------------------------------------

    StartButton = new JButton("Start");
    StartButton.setForeground(Color.RED);
    StartButton.setPreferredSize(new Dimension(150, 50));
    panel.add(StartButton);

    QuitButton = new JButton("Quit");
    QuitButton.setForeground(Color.RED);
    QuitButton.setPreferredSize(new Dimension(150, 50));
    panel.add(QuitButton);


    //-------------------------------------------------------------------------

    StartButton.addActionListener(new StartButtonValueListener());
    QuitButton.addActionListener(new QuitButtonValueListener());


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(100,50);
    getContentPane().add(panel);
    setVisible(true);
  }

  private class StartButtonValueListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          // close the Home page
          dispose();

          // Go to the next Gui interface
          DisplayStuff dS = new DisplayStuff(User);
          GUI Game =new GUI(User, EnnemyArray,dS);
      }
   }

   private class QuitButtonValueListener implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
       {
           System.exit(0);
       }
    }
}
