/* Jacob Kimball
 * 4/20/24
 * CSCE 111
 * Final Project
 * NFL Team Guessing Game GUI
 */

package com.example;



import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class nflGui extends JFrame implements ActionListener {
    
    private JLabel stateLabel;
    private JLabel mascotLabel;
    private JLabel playerLabel;
    private JLabel guessLabel;
    private JTextField stateField;
    private JTextField mascotField;
    private JTextField playerField;
    private JTextField guessField;
    private JButton checkButton;
    private JButton newButton;
    private nflTeamInfo cardinals;
    private nflTeamInfo falcons;
    private nflTeamInfo ravens;
    private nflTeamInfo bills;
    private nflTeamInfo panthers;
    private nflTeamInfo bears;
    private nflTeamInfo bengals;
    private nflTeamInfo browns;
    private nflTeamInfo cowboys;
    private nflTeamInfo broncos;
    private nflTeamInfo lions;
    private nflTeamInfo packers;
    private nflTeamInfo texans;
    private nflTeamInfo colts;
    private nflTeamInfo jaguars;
    private nflTeamInfo chiefs;
    private nflTeamInfo raiders;
    private nflTeamInfo chargers;
    private nflTeamInfo rams;
    private nflTeamInfo dolphins;
    private nflTeamInfo vikings;
    private nflTeamInfo patriots;
    private nflTeamInfo saints;
    private nflTeamInfo giants;
    private nflTeamInfo jets;
    private nflTeamInfo eagles;
    private nflTeamInfo steelers;
    private nflTeamInfo niners;
    private nflTeamInfo seahawks;
    private nflTeamInfo buccaneers;
    private nflTeamInfo titans;
    private nflTeamInfo commanders;
    private int num;

    nflGui() {

        GridBagConstraints positionConst = null;

        setTitle("NFL Team Guesser");
        ImageIcon nflLogo = new ImageIcon("nflLogo.png"); 

        getContentPane().setBackground(Color.LIGHT_GRAY);

        setIconImage(nflLogo.getImage());

        stateLabel = new JLabel("State Nickname: ");
        mascotLabel = new JLabel("Hint about mascot: ");
        playerLabel = new JLabel("Famous player: ");

        guessLabel = new JLabel("What team do you think it is?");

        stateField = new JTextField(25);
        stateField.setEditable(false);
        stateField.setHorizontalAlignment(JTextField.CENTER);

        mascotField = new JTextField(40);
        mascotField.setEditable(false);
        mascotField.setHorizontalAlignment(JTextField.CENTER);

        playerField = new JTextField(15);
        playerField.setEditable(false);
        playerField.setHorizontalAlignment(JTextField.CENTER);

        guessField = new JTextField(15);
        guessField.setEditable(true);
        

        checkButton = new JButton("Check");
        checkButton.addActionListener(this);

        newButton = new JButton("New Team");
        newButton.addActionListener(this);

        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();

        // adds image label
        // positionConst.gridx = 0;
        // positionConst.gridy = 0;
        // positionConst.insets = new Insets(10, 10, 10, 10);
        // add(allLogo, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 0;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(stateLabel, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(mascotLabel, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 2;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(playerLabel, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 3;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(guessLabel, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 0;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(stateField, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(mascotField, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 2;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(playerField, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 3;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(guessField, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 4;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(checkButton, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 4;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(newButton, positionConst);

        

        num = random(32);

        initializeTeams();

        setTeam(num);

        

        



    }

    @Override
    public void actionPerformed(ActionEvent event) {

        


        if (event.getSource() == checkButton) {

            // need to: 
            // 1. create a way to randomly select 1 of the 32 teams
            // 2. access the three pieces of information for that team
            // 3. check if wrong/right
            // 4. new team
            if (checkGuess(num) == true) {
                guessField.setText("Correct!");
                
            } else {
                
                guessField.setText("Incorrect! Try Again.");

            }
            


        } else if (event.getSource() == newButton) {
            
            num = random(32);

            setTeam(num);

            guessField.setText("");

        }



    }
    
    public static void main(String[] args) {

    
        
        nflGui gui = new nflGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.pack();
        gui.setVisible(true);


    }

    public static int random(int s) {

        return (int) (Math.random() * s) + 1;

    }

    public void initializeTeams(){

        cardinals = new nflTeamInfo("Arizona Cardinals", "A type of small, red bird", 
        "The Grand Canyon State", "Larry Fitzgerald Jr.");

        falcons = new nflTeamInfo("Atlanta Falcons", "A bird of prey", 
        "The Peach State", "Julio Jones");

        ravens = new nflTeamInfo("Baltimore Ravens", "A type of bird, a group of these is called an unkindness",
        "The Oyster State", "Ray Lewis");

        bills = new nflTeamInfo("Buffalo Bills", "A baby _____ is called a red dog", 
        "The Empire State", "Jim Kelly");

        panthers = new nflTeamInfo("Carolina Panthers", "A large feline known for its dark colored fur", 
        "The Tar Heel State" ,"Luke Kuechly");

        bears = new nflTeamInfo("Chicago Bears", "A large mammal that hibernates during the winter", 
        "Known as the Land of Lincoln", "Brian Urlacher");

        bengals = new nflTeamInfo("Cincinnati Bengals", "A large feline, known for its orange fur, black and white stripes", 
        "Known as the birthplace of Aviation", "A.J. Green");

        browns = new nflTeamInfo("Cleveland Browns", "A color", 
        "Known as the birthplace of Aviation", "Jim Brown");

        cowboys = new nflTeamInfo("Dallas Cowboys", "A profession known for herding and tending to cattle",
        "The Lone Star State", "Troy Aikman");

        broncos = new nflTeamInfo("Denver Broncos", "A wild horse", 
        "The Centennial State", "Shannon Sharpe");

        lions = new nflTeamInfo("Detroit Lions", "Known as the king of the jungle", 
        "The Great Lakes State", "Barry Sanders");

        packers = new nflTeamInfo("Green Bay Packers", "Fans are called cheese heads", 
        "Badger State", "Clay Matthews");

        texans = new nflTeamInfo("Houston Texans", "People who live in Texas are _____", 
        "The Lone Star State", "Andre Johnson");

        colts = new nflTeamInfo("Indianapolis Colts", "A young male horse", 
        "The Crossroads of America", "Peyton Manning");

        jaguars = new nflTeamInfo("Jacksonville Jaguars", "A large feline known for its spots",
        "The Sunshine State", "Mark Brunell");

        chiefs = new nflTeamInfo("Kansas City Chiefs", "The leader of a native american tribe",
        "Show-Me State", "Dontari Poe");

        raiders = new nflTeamInfo("Las Vegas Raiders", "A type of pirate", 
        "The Silver State", "Bo Jackson");

        chargers = new nflTeamInfo("Los Angeles Chargers", "Similar to a lightning bolt", 
        "The Golden State", "LaDainian Tomlinson");

        rams = new nflTeamInfo("Los Angeles Rams", "A male sheep", 
        "The Golden State", "Kurt Warner");
        
        dolphins = new nflTeamInfo("Miami Dolphins", "An aquatic mammal",
        "The Sunshine State", "Dan Marino");

        vikings = new nflTeamInfo("Minnesota Vikings", "An ancient group of people, of Scandinavian decent",
        "Land of 10,000 lakes", "John Randle");

        patriots = new nflTeamInfo("New England Patriots", "A person who is proud of their country",
        "Pilgrim State", "Vince Wilfork");

        saints = new nflTeamInfo("New Orleans Saints", "A holy person",
        "Bayou State", "Cameron Jordan");

        giants = new nflTeamInfo("New York Giants", "A big person",
        "The Empire State", "Lawrence Taylor");

        jets = new nflTeamInfo("New York Jets", "A fast military plane",
        "The Empire State", "Joe Namath");

        eagles = new nflTeamInfo("Philadelphia Eagles", "America's bird", 
        "The Keystone State", "Brian Dawkins");

        steelers = new nflTeamInfo("Pittsburgh Steelers", "A hard working person who works at the mills",
        "The Keystone State", "Troy Polamalu");

        niners = new nflTeamInfo("San Francisco 49ers", "A person who mines gold",
        "The Golden State", "Jerry Rice");

        seahawks = new nflTeamInfo("Seattle Seahawks", "A bird of prey",
        "The Evergreen State", "Bobby Wagner");

        buccaneers = new nflTeamInfo("Tampa Bay Buccaneers", "Another word for pirate", 
        "The Sunshine State", "Warren Sapp");

        titans = new nflTeamInfo("Tennessee Titans", "The predecessors to the gods in Greek mythology",
        "Volunteer State", "Steve McNair");

        commanders = new nflTeamInfo("Washington Commanders", "The leader of a military unit",
        "The Nation's Capital", "Terry McLaurin");

    }

    public boolean checkGuess(int num) {

        switch(num) {

            case 1:
            if (guessField.getText().toLowerCase().equals(cardinals.getName().toLowerCase())) {
                return true;
            } 
            break;
            case 2:
            if (guessField.getText().toLowerCase().equals(falcons.getName().toLowerCase())) {
                return true;
            }
            break;
            case 3:
            if (guessField.getText().toLowerCase().equals(ravens.getName().toLowerCase())) {
                return true;
            }
            break;
            case 4:
            if (guessField.getText().toLowerCase().equals(bills.getName().toLowerCase())) {
                return true;
            }
            break;
            case 5:
            if (guessField.getText().toLowerCase().equals(panthers.getName().toLowerCase())) {
                return true;
            }
            break;
            case 6:
            if (guessField.getText().toLowerCase().equals(bears.getName().toLowerCase())) {
                return true;
            }
            break;
            case 7:
            if (guessField.getText().toLowerCase().equals(bengals.getName().toLowerCase())) {
                return true;
            }
            break;
            case 8:
            if (guessField.getText().toLowerCase().equals(browns.getName().toLowerCase())) {
                return true;
            }
            break;
            case 9:
            if (guessField.getText().toLowerCase().equals(cowboys.getName().toLowerCase())) {
                return true;
            }
            break;
            case 10:
            if (guessField.getText().toLowerCase().equals(broncos.getName().toLowerCase())) {
                return true;
            }
            break;
            case 11:
            if (guessField.getText().toLowerCase().equals(lions.getName().toLowerCase())) {
                return true;
            }
            break;
            case 12:
            if (guessField.getText().toLowerCase().equals(packers.getName().toLowerCase())) {
                return true;
            }
            break;
            case 13:
            if (guessField.getText().toLowerCase().equals(texans.getName().toLowerCase())) {
                return true;
            }
            break;
            case 14:
            if (guessField.getText().toLowerCase().equals(colts.getName().toLowerCase())) {
                return true;
            }
            break;
            case 15:
            if (guessField.getText().toLowerCase().equals(jaguars.getName().toLowerCase())) {
                return true;
            }
            break;
            case 16:
            if (guessField.getText().toLowerCase().equals(chiefs.getName().toLowerCase())) {
                return true;
            }
            break;
            case 17:
            if (guessField.getText().toLowerCase().equals(raiders.getName().toLowerCase())) {
                return true;
            }
            break;
            case 18:
            if (guessField.getText().toLowerCase().equals(chargers.getName().toLowerCase())) {
                return true;
            }
            break;
            case 19:
            if (guessField.getText().toLowerCase().equals(rams.getName().toLowerCase())) {
                return true;
            }
            break;
            case 20:
            if (guessField.getText().toLowerCase().equals(dolphins.getName().toLowerCase())) {
                return true;
            }
            break;
            case 21:
            if (guessField.getText().toLowerCase().equals(vikings.getName().toLowerCase())) {
                return true;
            }
            break;
            case 22:
            if (guessField.getText().toLowerCase().equals(patriots.getName().toLowerCase())) {
                return true;
            }
            break;
            case 23:
            if (guessField.getText().toLowerCase().equals(saints.getName().toLowerCase())) {
                return true;
            }
            break;
            case 24:
            if (guessField.getText().toLowerCase().equals(giants.getName().toLowerCase())) {
                return true;
            }
            break;
            case 25:
            if (guessField.getText().toLowerCase().equals(jets.getName().toLowerCase())) {
                return true;
            }
            break;
            case 26:
            if (guessField.getText().toLowerCase().equals(eagles.getName().toLowerCase())) {
                return true;
            }
            break;
            case 27:
            if (guessField.getText().toLowerCase().equals(steelers.getName().toLowerCase())) {
                return true;
            }
            break;
            case 28:
            if (guessField.getText().toLowerCase().equals(niners.getName().toLowerCase())) {
                return true;
            }
            break;
            case 29:
            if (guessField.getText().toLowerCase().equals(seahawks.getName().toLowerCase())) {
                return true;
            }
            break;
            case 30:
            if (guessField.getText().toLowerCase().equals(buccaneers.getName().toLowerCase())) {
                return true;
            }
            break;
            case 31:
            if (guessField.getText().toLowerCase().equals(titans.getName().toLowerCase())) {
                return true;
            }
            break;
            case 32:
            if (guessField.getText().toLowerCase().equals(commanders.getName().toLowerCase())) {
                return true;
            }
            break;

        }

        return false;
    }

    public void setTeam(int num){

        switch(num) {

            case 1:
            stateField.setText(cardinals.getStateHint());
            mascotField.setText(cardinals.getMascotHint());
            playerField.setText(cardinals.getPlayer());
            break;
            case 2:
            stateField.setText(falcons.getStateHint());
            mascotField.setText(falcons.getMascotHint());
            playerField.setText(falcons.getPlayer());
            break;
            case 3:
            stateField.setText(ravens.getStateHint());
            mascotField.setText(ravens.getMascotHint());
            playerField.setText(ravens.getPlayer());
            break;
            case 4:
            stateField.setText(bills.getStateHint());
            mascotField.setText(bills.getMascotHint());
            playerField.setText(bills.getPlayer());
            break;
            case 5:
            stateField.setText(panthers.getStateHint());
            mascotField.setText(panthers.getMascotHint());
            playerField.setText(panthers.getPlayer());
            break;
            case 6:
            stateField.setText(bears.getStateHint());
            mascotField.setText(bears.getMascotHint());
            playerField.setText(bears.getPlayer());
            break;
            case 7:
            stateField.setText(bengals.getStateHint());
            mascotField.setText(bengals.getMascotHint());
            playerField.setText(bengals.getPlayer());
            break;
            case 8:
            stateField.setText(browns.getStateHint());
            mascotField.setText(browns.getMascotHint());
            playerField.setText(browns.getPlayer());
            break;
            case 9:
            stateField.setText(cowboys.getStateHint());
            mascotField.setText(cowboys.getMascotHint());
            playerField.setText(cowboys.getPlayer());
            break;
            case 10:
            stateField.setText(broncos.getStateHint());
            mascotField.setText(broncos.getMascotHint());
            playerField.setText(broncos.getPlayer());
            break;
            case 11:
            stateField.setText(lions.getStateHint());
            mascotField.setText(lions.getMascotHint());
            playerField.setText(lions.getPlayer());
            break;
            case 12:
            stateField.setText(packers.getStateHint());
            mascotField.setText(packers.getMascotHint());
            playerField.setText(packers.getPlayer());
            break;
            case 13:
            stateField.setText(texans.getStateHint());
            mascotField.setText(texans.getMascotHint());
            playerField.setText(texans.getPlayer());
            break;
            case 14:
            stateField.setText(colts.getStateHint());
            mascotField.setText(colts.getMascotHint());
            playerField.setText(colts.getPlayer());
            break;
            case 15:
            stateField.setText(jaguars.getStateHint());
            mascotField.setText(jaguars.getMascotHint());
            playerField.setText(jaguars.getPlayer());
            break;
            case 16:
            stateField.setText(chiefs.getStateHint());
            mascotField.setText(chiefs.getMascotHint());
            playerField.setText(chiefs.getPlayer());
            break;
            case 17:
            stateField.setText(raiders.getStateHint());
            mascotField.setText(raiders.getMascotHint());
            playerField.setText(raiders.getPlayer());
            break;
            case 18:
            stateField.setText(chargers.getStateHint());
            mascotField.setText(chargers.getMascotHint());
            playerField.setText(chargers.getPlayer());
            break;
            case 19:
            stateField.setText(rams.getStateHint());
            mascotField.setText(rams.getMascotHint());
            playerField.setText(rams.getPlayer());
            break;
            case 20:
            stateField.setText(dolphins.getStateHint());
            mascotField.setText(dolphins.getMascotHint());
            playerField.setText(dolphins.getPlayer());
            break;
            case 21:
            stateField.setText(vikings.getStateHint());
            mascotField.setText(vikings.getMascotHint());
            playerField.setText(vikings.getPlayer());
            break;
            case 22:
            stateField.setText(patriots.getStateHint());
            mascotField.setText(patriots.getMascotHint());
            playerField.setText(patriots.getPlayer());
            break;
            case 23:
            stateField.setText(saints.getStateHint());
            mascotField.setText(saints.getMascotHint());
            playerField.setText(saints.getPlayer());
            break;
            case 24:
            stateField.setText(giants.getStateHint());
            mascotField.setText(giants.getMascotHint());
            playerField.setText(giants.getPlayer());
            break;
            case 25:
            stateField.setText(jets.getStateHint());
            mascotField.setText(jets.getMascotHint());
            playerField.setText(jets.getPlayer());
            break;
            case 26:
            stateField.setText(eagles.getStateHint());
            mascotField.setText(eagles.getMascotHint());
            playerField.setText(eagles.getPlayer());
            break;
            case 27:
            stateField.setText(steelers.getStateHint());
            mascotField.setText(steelers.getMascotHint());
            playerField.setText(steelers.getPlayer());
            break;
            case 28:
            stateField.setText(niners.getStateHint());
            mascotField.setText(niners.getMascotHint());
            playerField.setText(niners.getPlayer());
            break;
            case 29:
            stateField.setText(seahawks.getStateHint());
            mascotField.setText(seahawks.getMascotHint());
            playerField.setText(seahawks.getPlayer());
            break;
            case 30:
            stateField.setText(buccaneers.getStateHint());
            mascotField.setText(buccaneers.getMascotHint());
            playerField.setText(buccaneers.getPlayer());
            break;
            case 31:
            stateField.setText(titans.getStateHint());
            mascotField.setText(titans.getMascotHint());
            playerField.setText(titans.getPlayer());
            break;
            case 32:
            stateField.setText(commanders.getStateHint());
            mascotField.setText(commanders.getMascotHint());
            playerField.setText(commanders.getPlayer());
            break;

        }

    }
    
}
