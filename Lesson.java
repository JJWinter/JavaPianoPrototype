/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype.v2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author jw468
 */
public class Lesson extends JPanel {

    KeyBoard keyboard;

    ArrayList<String> passNotes = new ArrayList<String>();
    boolean passed = false;
    ArrayList<Key> notesPlayed = new ArrayList<Key>();

    JPanel topBar;
    protected JLabel topBarText = new JLabel();
    JPanel botBar;
    protected JLabel botBarText = new JLabel();

    public Lesson() {
        keyboard = new KeyBoard();
        
        //Text Styling
        topBarText.setFont(new Font("Courier New", Font.BOLD, 25));
        topBarText.setForeground(Color.WHITE);
        botBarText.setFont(new Font("Courier New", Font.BOLD, 25));
        botBarText.setForeground(Color.WHITE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(1100, 600));
        panel.setBackground(Color.LIGHT_GRAY);

        topBar = new JPanel();
        topBar.setBackground(Color.GRAY);
        topBar.add(topBarText);
        topBar.setPreferredSize(new Dimension(1000, 200));
        botBar = new JPanel();
        botBar.setBackground(Color.GRAY);
        botBar.add(botBarText);
        botBar.setPreferredSize(new Dimension(1000, 200));

        JButton playButton = new JButton("Play Notes");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Key k : keyboard.getKeys()) {
                    if (k.isHighlighted()) {
                        notesPlayed.add(k);
                        k.playNote();
                        //confirmPass();
                    }
                }
            }
        });
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Key k : keyboard.getKeys()) {
                    k.setHighlighted(false);
                    notesPlayed.clear();
                }
            }
        });
        
        for(Key k: keyboard.getKeys()){
            k.keyNameToggle(true);
        }

        // adding button to the black JPanel
        panel.add(topBar, BorderLayout.PAGE_START);
        panel.add(botBar, BorderLayout.PAGE_END);
        panel.add(playButton, BorderLayout.LINE_END);
        panel.add(resetButton, BorderLayout.LINE_START);
        panel.add(keyboard, BorderLayout.CENTER);

        // adding blackJPanel
        add(panel);
    }

    public Lesson(String displayImg) {

    }

    private void confirmPass() {
        ArrayList<String> nPlayed = new ArrayList<String>();
        for (Key k : notesPlayed) {
            nPlayed.add(k.note);
        }

        if (passNotes.containsAll(nPlayed)) {
            passed = true;
            System.out.println("XXX");

            botBarText.setText("You did it, you can move on");
        }
    }

}
