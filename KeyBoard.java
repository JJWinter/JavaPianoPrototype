package prototype.v2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLayeredPane;

public class KeyBoard extends JLayeredPane{

    public Key[] keys = new Key[37];
    public Key[] getKeys(){
        return keys;
    }

    String[] note = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};

    

    public KeyBoard() {
        int octave = 1;

        int keyPosition = 0;

        for (int i = 0; i <= 8; i++) {
            Key key = new Key(note[i + 3] + octave);
            keys[keyPosition] = key;
            keyPosition++;
        }
        for (int i = 0; i < 3; i++) {
            octave++;
            for (int j = 0; j < note.length; j++) {
                Key key = new Key(note[j] + octave);
                keys[keyPosition] = key;
                if(keyPosition == 36){
                    break;            
                }
                keyPosition++;
            }
        }
        
        setPreferredSize(new Dimension(1000,200));
        displayKeyboard();
    } 
    
    public void displayKeyboard() {
        int i = 1;
        for (Key k : keys) {
            k.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    k.toggleHighlighted();
                }
            });
            if (k.getNote().charAt(1) == '#') {
                k.setBackground(Color.BLACK);
                k.setLocation((i * 40) - 14, 0);
                k.setSize(28, 100);
                this.add(k, 1, -1);
            } else {
                k.setBackground(Color.WHITE);
                k.setLocation(i * 40, 0);
                k.setSize(40, 170);
                this.add(k, 0, -1);
                i++;
            }
        }
    }

}
