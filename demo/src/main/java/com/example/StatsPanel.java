package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;


public class StatsPanel extends JPanel {
    private JTextField playerNameField;
    private JLabel fullNameData;
    private JLabel positionData;
    private JLabel heightData;
    private JLabel weightData;
    private JLabel draftYearData;
    private JLabel draftNumberData;
    private JLabel draftTeamData;
    private final HttpClient httpClient = HttpClient.newHttpClient();

    private JPanel createStatRow(String headerText, JLabel dataLabel) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rowPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel headerLabel = new JLabel(headerText);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setPreferredSize(new Dimension(100, headerLabel.getPreferredSize().height)); 
        rowPanel.add(headerLabel);
    
        dataLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        dataLabel.setHorizontalAlignment(JLabel.LEFT); 
        rowPanel.add(dataLabel);
    
        return rowPanel;
    }
    

    

    public StatsPanel() {

        
        
        setLayout(new BorderLayout());
    
        // UI components
        JButton fetchButton = new JButton("Fetch Stats");
        playerNameField = new JTextField(20); 
    
        // Initialize data labels
        fullNameData = new JLabel();
        positionData = new JLabel();
        heightData = new JLabel();
        weightData = new JLabel();
        draftYearData = new JLabel();
        draftNumberData = new JLabel();
        draftTeamData = new JLabel();
    
        // Layout for input
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Enter NBA Player's Name:"));
        inputPanel.add(playerNameField);
        inputPanel.add(fetchButton);
    
        // Styling inputPanel
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(inputPanel, BorderLayout.NORTH);
    
        // Stats display panel with 2 columns: headers on the left, data on the right
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.add(Box.createVerticalGlue());
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Adding each stat as a row with a header and data label
        statsPanel.add(createStatRow("Full Name:", fullNameData));
        statsPanel.add(createStatRow("Position:", positionData));
        statsPanel.add(createStatRow("Height:", heightData));
        statsPanel.add(createStatRow("Weight:", weightData));
        statsPanel.add(createStatRow("Draft Year:", draftYearData));
        statsPanel.add(createStatRow("Draft Number:", draftNumberData));
        statsPanel.add(createStatRow("Draft Team:", draftTeamData));
    
        // Scroll pane in case the content is too long
        JScrollPane scrollPane = new JScrollPane(statsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        
    
        // Action on button click
        fetchButton.addActionListener(this::fetchPlayerStats);
    }
    

    private void fetchPlayerStats(ActionEvent e) {
        String playerName = playerNameField.getText();
        fetchPlayerStatsFromAPI(playerName);
    }


    private void fetchPlayerStatsFromAPI(String playerName) {
        String url;
        try {
            // Using trim to remove any leading or trailing spaces
            playerName = playerName.trim();
            
            if (playerName.contains(" ")) {
                // Split the name into first and last names if a space is present
                String[] nameParts = playerName.split("\\s+"); // Enhanced to split on any whitespace
                if (nameParts.length >= 2) { // Make sure there are at least two parts
                    String firstName = URLEncoder.encode(nameParts[0], StandardCharsets.UTF_8.toString());
                    String lastName = URLEncoder.encode(nameParts[1], StandardCharsets.UTF_8.toString());
                    url = "https://api.balldontlie.io/v1/players?first_name=" + firstName + "&last_name=" + lastName;
                } else {
                    // Fallback to search if not enough parts
                    String encodedPlayerName = URLEncoder.encode(playerName, StandardCharsets.UTF_8.toString());
                    url = "https://api.balldontlie.io/v1/players?search=" + encodedPlayerName;
                }
            } else {
                // If the player name doesn't contain a space, use the search parameter
                String encodedPlayerName = URLEncoder.encode(playerName, StandardCharsets.UTF_8.toString());
                url = "https://api.balldontlie.io/v1/players?search=" + encodedPlayerName;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }

        // Create the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Authorization", "0da4b1ff-7b07-4db5-bdb0-0eb74ca42d3e")
            .build();

        // Send the request and handle the response
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            updatePlayerStats(response.body());
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Failed to fetch stats: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePlayerStats(String response) {
        try {
            // Parsing the JSON response
            JSONObject jsonObject = new JSONObject(response);
        JSONArray players = jsonObject.getJSONArray("data");

        // Checking if any players were found
        if (players.length() == 0) {
            JOptionPane.showMessageDialog(this, "No players found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Getting the first player
        JSONObject player = players.getJSONObject(0);
            
            // Extracting the player's stats
            String fullName = player.getString("first_name") + " " + player.getString("last_name");
            String position = player.getString("position");
            String height = player.getString("height");
            String weight = player.getString("weight");
            String draftYear = player.isNull("draft_year") ? "N/A" : Integer.toString(player.getInt("draft_year"));
            String draftNumber = player.isNull("draft_number") ? "N/A" : Integer.toString(player.getInt("draft_number"));
            String draftTeam = player.getJSONObject("team").getString("full_name");
    
            
    
            // Displaying the player's stats
            SwingUtilities.invokeLater(() -> {
                fullNameData.setText(fullName);
                positionData.setText(position);
                heightData.setText(height);
                weightData.setText(weight);
                draftYearData.setText(draftYear);
                draftNumberData.setText(draftNumber);
                draftTeamData.setText(draftTeam);
            });
    
            
        } catch (JSONException e) {
            // Handling errors
            JOptionPane.showMessageDialog(this, "Failed to parse stats: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void display() {
        JFrame frame = new JFrame("Player Lookup");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setPreferredSize(new Dimension(400, 300)); // Set the preferred size for the window
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}