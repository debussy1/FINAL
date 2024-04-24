package com.example;
/* Ali Allahwala
 * 4/20/24
 * CSCE 111
 * Final Project
 * NBA Game GUI
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NBAQuiz extends JFrame {
    private JFrame frame;                  // The main window of the application
    private JPanel panel;                  // A panel to hold all UI elements
    private ButtonGroup options;           // Group for radio buttons to allow only one selection
    private JLabel questionLabel;          // Label to display the current question
    private JRadioButton[] radioButtons;   // Array of radio buttons for multiple choice answers
    private JButton nextButton;            // Button to proceed to the next question
    private List<Question> questions;      // List to store all the questions
    private int currentQuestionIndex = 0;  // Index to track the current question
    private int score = 0;                 // Counter to track the user's score

    public NBAQuiz() {
        initializeQuestions();             // Method to initialize all the questions
        setUpGUI();                        // Method to setup the graphical user interface
    }

    // Method to populate the quiz with questions
    private void initializeQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("Who was drafted 1st overall in the 2003 NBA Draft?", new String[]{"LeBron James", "Carmelo Anthony", "Chris Bosh", "Dwyane Wade"}, "LeBron James"));
        questions.add(new Question("Which team won the NBA championship in 2020?", new String[]{"Miami Heat", "Denver Nuggets", "Los Angeles Lakers", "Milwaukee Bucks"}, "Los Angeles Lakers"));
        questions.add(new Question("Who is known as 'The Greek Freak'?", new String[]{"Kevin Durant", "Giannis Antetokounmpo", "James Harden", "Zion Williamson"}, "Giannis Antetokounmpo"));
        questions.add(new Question("Which player scored the highest points in a single game?", new String[]{"Kobe Bryant", "Michael Jordan", "Wilt Chamberlain", "Shaquille O'Neal"}, "Wilt Chamberlain"));
        questions.add(new Question("What is the record for most assists in a single NBA game?", new String[]{"28", "25", "30", "22"}, "30"));
        questions.add(new Question("Who has the most career rebounds in NBA history?", new String[]{"Bill Russell", "Kareem Abdul-Jabbar", "Wilt Chamberlain", "Tim Duncan"}, "Wilt Chamberlain"));
        questions.add(new Question("What number did Michael Jordan wear during his comeback in 1995?", new String[]{"23", "32", "45", "12"}, "45"));
        questions.add(new Question("Which team did Shaquille O'Neal start his NBA career with?", new String[]{"Los Angeles Lakers", "Orlando Magic", "Miami Heat", "Phoenix Suns"}, "Orlando Magic"));
        questions.add(new Question("Which player holds the record for the most points in an NBA Finals game?", new String[]{"LeBron James", "Michael Jordan", "Elgin Baylor", "Jerry West"}, "Elgin Baylor"));
        questions.add(new Question("What year was the three-point line introduced in the NBA?", new String[]{"1979", "1984", "1963", "1990"}, "1979"));
    }


    // Method to set up the GUI components
    private void setUpGUI() {
        frame = new JFrame("NBA Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setBackground(Color.DARK_GRAY);

        questionLabel = new JLabel("Question");
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(questionLabel);

        options = new ButtonGroup();
        radioButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setForeground(Color.WHITE);
            radioButtons[i].setBackground(Color.DARK_GRAY);
            radioButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            options.add(radioButtons[i]);
            panel.add(radioButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.setForeground(Color.DARK_GRAY);
        nextButton.setBackground(Color.LIGHT_GRAY);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();                             // Check the selected answer
                currentQuestionIndex++;                   // Move to the next question
                if (currentQuestionIndex < questions.size()) {
                    setQuestion(currentQuestionIndex);    // Update the display to the next question
                } else {
                    // Display the score when all questions are answered
                    JOptionPane.showMessageDialog(frame, "Your score is " + score + "/" + questions.size(), "Quiz Complete", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();                      // Close the application window
                }
            }
        });
        panel.add(nextButton);

        frame.add(panel);
        setQuestion(0);  // Start with the first question
        frame.setVisible(true);
    }

    // Method to display a new question on the panel
    private void setQuestion(int questionIndex) {
        Question q = questions.get(questionIndex);
        questionLabel.setText(q.getQuestion());
        for (int i = 0; i < 4; i++) {
            radioButtons[i].setText(q.getOptions()[i]);
            radioButtons[i].setSelected(false);
        }
    }

    // Method to check if the selected answer is correct
    private void checkAnswer() {
        String selectedAnswer = "";
        for (JRadioButton radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                selectedAnswer = radioButton.getText();
                break;
            }
        }
        if (selectedAnswer.equals(questions.get(currentQuestionIndex).getAnswer())) {
            score++;  // Increment the score if the answer is correct
        }
    }

    public static void main(String[] args) {
        new NBAQuiz();  // Create an instance of the quiz
    }
}

class Question {
    private String question;
    private String[] options;
    private String answer;

    public Question(String question, String[] options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
}
