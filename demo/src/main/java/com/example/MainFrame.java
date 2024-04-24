package com.example;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;

public class MainFrame {
    public static void main(String[] args) {
    GridBagConstraints positionConst = new GridBagConstraints();

    JFrame frame = new JFrame("Looper Troopers");

    // initialize each person's class
    Grant grant = new Grant();
    Bryan bryan = new Bryan();
    Jacob jacob = new Jacob();
    Ali ali = new Ali();
    Kenton kenton = new Kenton();
    Video video = new Video();

    // gets the images for each person's button and reshapes them to 100x100 pixels
    URL grantUrl = MainFrame.class.getResource("PGAlogo.png");
    ImageIcon grantIcon = new ImageIcon(grantUrl);
    Image grantImage = grantIcon.getImage();
    grantImage = grantImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    grantIcon = new ImageIcon(grantImage);
    JLabel grantPicture = new JLabel(grantIcon);

    URL bryanUrl = MainFrame.class.getResource("worldcup.jpeg");
    ImageIcon bryanIcon = new ImageIcon(bryanUrl);
    Image bryanImage = bryanIcon.getImage();
    bryanImage = bryanImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    bryanIcon = new ImageIcon(bryanImage);
    JLabel bryanPicture = new JLabel(bryanIcon);

    URL jacobUrl = MainFrame.class.getResource("nflLogo.png");
    ImageIcon jacobIcon = new ImageIcon(jacobUrl);
    Image jacobImage = jacobIcon.getImage();
    jacobImage = jacobImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    jacobIcon = new ImageIcon(jacobImage);
    JLabel jacobPicture = new JLabel(jacobIcon);

    URL aliUrl = MainFrame.class.getResource("NBAlogo.jpeg");
    ImageIcon aliIcon = new ImageIcon(aliUrl);
    Image aliImage = aliIcon.getImage();
    aliImage = aliImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    aliIcon = new ImageIcon(aliImage);
    JLabel aliPicture = new JLabel(aliIcon);

    URL kentonUrl = MainFrame.class.getResource("sportsdata.png");
    ImageIcon kentonIcon = new ImageIcon(kentonUrl);
    Image kentonImage = kentonIcon.getImage();
    kentonImage = kentonImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    kentonIcon = new ImageIcon(kentonImage);
    JLabel kentonPicture = new JLabel(kentonIcon);

    // set the positions for the 6 buttons and 5 pictures
    frame.setLayout(new GridBagLayout());

    positionConst.gridx = 0;
    positionConst.gridy = 0;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(grant, positionConst);

    positionConst.gridx = 0;
    positionConst.gridy = 1;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(grantPicture, positionConst);

    positionConst.gridx = 1;
    positionConst.gridy = 0;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(bryan, positionConst);

    positionConst.gridx = 1;
    positionConst.gridy = 1;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(bryanPicture, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 0;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(jacob, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 1;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(jacobPicture, positionConst);

    positionConst.gridx = 3;
    positionConst.gridy = 0;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(ali, positionConst);

    positionConst.gridx = 3;
    positionConst.gridy = 1;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(aliPicture, positionConst);

    positionConst.gridx = 4;
    positionConst.gridy = 0;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(kenton, positionConst);

    positionConst.gridx = 4;
    positionConst.gridy = 1;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(kentonPicture, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 4;
    positionConst.insets = new Insets(10, 10, 10, 10);
    frame.add(video, positionConst);

    // setting up the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
    }
}

// each member's individual class



class Grant extends JPanel {
    public Grant() {
        JButton button = new JButton("Grant"); 
        button.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e) {
                // Open my game (GrantGame) when my button is clicked
                JFrame gameFrame = new JFrame("Grant's Game: PGA FedEx Points Guessing Game (2024)");
                gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gameFrame.setSize(1000, 1000);

                GrantGame gamePanel = new GrantGame(); 
                gameFrame.add(gamePanel);
                gameFrame.setVisible(true);
            }
        });
        add(button); 
    }
}

class Bryan extends JPanel {
    public Bryan() {
        JButton bryanButton = new JButton("Bryan");
        bryanButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // Open the FIFA World Cup Quiz when Bryan's button is clicked
                BryanQuiz quiz = new BryanQuiz();
                quiz.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                quiz.setLocationRelativeTo(null);
                quiz.setVisible(true);
            }
        });
        add(bryanButton);
    }
}

class Jacob extends JPanel {
    public Jacob() {
        JButton jacobButton = new JButton("Jacob");
        jacobButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                nflGui gui = new nflGui();
                gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                gui.setLocationRelativeTo(null);
                gui.pack();
                gui.setVisible(true);

            }
        });
        add(jacobButton);
    }

    
}

class Ali extends JPanel {
    public Ali() {
        JButton button = new JButton("Ali"); 
        button.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e) {
                // Open game (NBAGame) when my button is clicked
                JFrame gameFrame = new JFrame("Ali's NBA Quiz");
                gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gameFrame.setSize(1000, 1000);

                NBAQuiz gamePanel = new NBAQuiz(); 
                gameFrame.add(gamePanel);
                gameFrame.setVisible(true);
            }
        });
        add(button); 
    }
}

class Kenton extends JPanel {
    public Kenton() {
        JButton kentonButton = new JButton("Kenton");
        kentonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a new window with StatsPanel when the Kenton button is clicked
                JFrame kentonFrame = new JFrame("Stat Lookup");
                kentonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                kentonFrame.setSize(1000, 1000);

                // Add the StatsPanel to the new window
                StatsPanel statsPanel = new StatsPanel(); 
                kentonFrame.add(statsPanel);
                kentonFrame.setVisible(true);
            }
        });
        add(kentonButton);
    }
}

class Video extends JPanel {
    public Video() {
        JButton videoButton = new JButton("Video");
        videoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    URI uri = new URI("https://www.youtube.com/watch?v=zq5lal8L2SU&ab_channel=CoachGunns");
                    Desktop.getDesktop().browse(uri);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        add(videoButton);
    }
}
