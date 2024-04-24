package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BryanQuiz extends JFrame {
    private JPanel panel;
    private JButton[] answerButtons;
    private JLabel questionLabel, statusLabel;
    private JButton retakeButton, closeButton;
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;

    // Correct answers for each question
    private int[] correctAnswerIndices = {0, 0, 0, 0, 1, 0};  

    // Questions and answers
    private String[][] questions = {
        {"Which country won the 2018 FIFA World Cup?", "France", "Brazil", "Germany", "Italy"},
        {"What is the nickname of the Brazilian national team?", "Canarinho", "Los Cafeteros", "Les Bleus", "Die Mannschaft"},
        {"Which player has won the most World Cups?", "Pelé", "Maradona", "Zidane", "Ronaldo"},
        {"In what year was the first World Cup held?", "1930", "1950", "1960", "1920"},
        {"Which country will host the 2026 FIFA World Cup?", "Qatar", "USA, Mexico, & Canada", "England", "Australia"},
        {"How many teams competed in the 2018 FIFA World Cup?", "32", "16", "24", "48"}
    };

    public BryanQuiz() {
        setTitle("FIFA World Cup Quiz");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridLayout(7, 1));
        panel.setBackground(new Color(224, 255, 255));

        questionLabel = new JLabel("Question: " + questions[currentQuestionIndex][0], JLabel.CENTER);
        questionLabel.setForeground(Color.BLUE);
        panel.add(questionLabel);

        answerButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            if(questions[currentQuestionIndex].length > i + 1){
                answerButtons[i] = new JButton(questions[currentQuestionIndex][i+1]);
                answerButtons[i].setBackground(new Color(255, 228, 225));
                answerButtons[i].addActionListener(new AnswerButtonListener());
                panel.add(answerButtons[i]);  
            }
           
        }

        statusLabel = new JLabel("Select your answer", JLabel.CENTER);
        statusLabel.setForeground(Color.RED);
        panel.add(statusLabel);

        retakeButton = new JButton("Retake Quiz");
        retakeButton.addActionListener(e -> restartQuiz());
        retakeButton.setVisible(false);

        closeButton = new JButton("Close Quiz");
        closeButton.addActionListener(e -> dispose());
        closeButton.setVisible(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(retakeButton);
        buttonPanel.add(closeButton);
        panel.add(buttonPanel);

        add(panel);
    }

    private void restartQuiz() {
        currentQuestionIndex = 0;
        correctAnswers = 0;
        updateQuestionView();
        retakeButton.setVisible(false);
        closeButton.setVisible(false);
        statusLabel.setText("Select your answer");
    }

    private void updateQuestionView() {
        questionLabel.setText("Question: " + questions[currentQuestionIndex][0]);
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(questions[currentQuestionIndex][i + 1]);
        }
    }

    private class AnswerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int selectedAnswerIndex = -1;
    
            // Loop to find which button was clicked
            for (int i = 0; i < answerButtons.length; i++) {
                if (clickedButton == answerButtons[i]) {
                    selectedAnswerIndex = i;  // Find the index of the clicked button
                    break;  // Important to break after finding the index
                }
            }
    
            // After finding which button was clicked, check if the answer is correct
            if (selectedAnswerIndex == correctAnswerIndices[currentQuestionIndex]) {
                correctAnswers++;  // Increment correct answer count if correct
                statusLabel.setText("Correct!");
            } else {
                statusLabel.setText("Wrong!");
            }
    
            // Move to the next question or finish the quiz
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                updateQuestionView(); // Load the next question
            } else {
                // End of the quiz
                statusLabel.setText("End of the quiz! You answered " + correctAnswers + " correctly out of " + questions.length + ".");
                closeButton.setVisible(true);
                retakeButton.setVisible(true);
            }
        }
    }
    
}
