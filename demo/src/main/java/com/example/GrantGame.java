package com.example;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.Random;
 import java.awt.Toolkit;
 
 // create a class that represents the main game panel where the game is played
 public class GrantGame extends JPanel {
     private JButton button1;
     private JButton button2;
     private JLabel statusLabel;
     private int currentRound = 0;
     private int totalRounds = 10;
     private Random random = new Random();
     private Golfer[] golfers = new Golfer[10];
     private Golfer currentGolfer1;
     private Golfer currentGolfer2;
 
     public GrantGame() {
         //set up grid bag layout and background color 
         setLayout(new GridBagLayout());
         setBackground(new Color(0, 153, 0));
         GridBagConstraints gbc = new GridBagConstraints();
         
         // Initialize golfer array with fedex points correlating to each golfer's name
         golfers[0] = new Golfer("Tiger Woods", 8);
         golfers[1] = new Golfer("Rory McIlroy", 549);
         golfers[2] = new Golfer("Jordan Spieth", 568);
         golfers[3] = new Golfer("Tony Finau", 496);
         golfers[4] = new Golfer("Justin Thomas", 580);
         golfers[5] = new Golfer("Tommy Fleetwood", 627);
         golfers[6] = new Golfer("Adam Scott", 394);
         golfers[7] = new Golfer("Matt Fitzpatrick", 652);
         golfers[8] = new Golfer("Scottie Scheffler", 3215);
         golfers[9] = new Golfer("Rickie Fowler", 127);
 
         //create buttons for two answer choices and add game text title
         button1 = new JButton("Golfer 1");
         button2 = new JButton("Golfer 2");
         statusLabel = new JLabel("Pick the golfer with higher FedEx points!");
         statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
 
         // When button1 is clicked it then goes to evaluateRound method to determine if the golferlabeled with button1 has more FedEx points than the golfer labeled with button2
         button1.addActionListener(new ActionListener() {
           
             public void actionPerformed(ActionEvent e) {
                 evaluateRound(currentGolfer1, currentGolfer2);
             }
         });
 
         button2.addActionListener(new ActionListener() {
           
             public void actionPerformed(ActionEvent e) {
                 evaluateRound(currentGolfer2, currentGolfer1);
             }
         });
 
         // how the functions will look and where they will be placed 
         gbc.gridwidth = GridBagConstraints.REMAINDER; 
         gbc.fill = GridBagConstraints.HORIZONTAL; 
         gbc.insets = new Insets(10, 10, 10, 10); 
 
         // size of buttons
         button1.setSize(new Dimension(200, 50));
         button2.setSize(new Dimension(200, 50));
 
         //add labels and buttons
         add(statusLabel, gbc); 
         add(button1, gbc);     
         add(button2, gbc);     
         
         //start game
         nextRound(); 
     }
 
     //this will determine if user guessed the correct golfer
     private void evaluateRound(Golfer selectedGolfer, Golfer otherGolfer) {
         // Checks if the selected golfer has more points than the other golfer and makes a ding noise if correct
         if (selectedGolfer.points > otherGolfer.points) {
             Toolkit.getDefaultToolkit().beep();
             currentRound++;
             //win method 
             if (currentRound >= totalRounds) {
                 int response = JOptionPane.showConfirmDialog(null, "You Win! Want to play again?", "Victory!",
                         JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                 if (response == JOptionPane.YES_OPTION) {
                     currentRound = 0;
                 } else {
                     statusLabel.setText("Thanks for playing! Close the window to exit.");
                     return;
                 }
             } else {
                 statusLabel.setText("Correct! Round " + currentRound + " of " + totalRounds + ".");
             }
             nextRound();
         } else {
             // if answered incorrectly show a message with the correct FedEx points
             JOptionPane.showMessageDialog(null,"Incorrect! " + selectedGolfer.name + " had " + selectedGolfer.points + " points, " + otherGolfer.name + " had " + otherGolfer.points + " points.", "Oops!", JOptionPane.ERROR_MESSAGE);
             currentRound = 0;
             nextRound();
         }
         
      }
     
      // new round in game
     private void nextRound() {
         
         // Choose two random golfers for the next round and makes sure they are not the same golfer
         int index1 = random.nextInt(golfers.length);
         int index2;
         do {
             index2 = random.nextInt(golfers.length);
         } while (index1 == index2);
 
         // Update the current golfers for new round 
         currentGolfer1 = golfers[index1];
         currentGolfer2 = golfers[index2];
 
         //show the names of the new golfers on buttons
         button1.setText(currentGolfer1.name);
         button2.setText(currentGolfer2.name);
     }
 
     //holds a golfers names and the number of FedEx points they have
     class Golfer {
         String name;
         int points;
 
         Golfer(String name, int points) {
             this.name = name;
             this.points = points;
         }
     }
 }
 
 
 
