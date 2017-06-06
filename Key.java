package prototype.v2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingConstants;

/**
 *
 * @author jw468
 */
public class Key extends JButton {

    boolean highlighted;

    public boolean isHighlighted() {
        return highlighted;
    }

    String note;

    public String getNote() {
        return note;
    }

    public Key(String note) {
        this.note = note;
        this.setMargin(new Insets(1, 1, 1, 1));
        this.setVerticalAlignment(SwingConstants.BOTTOM);
        this.setFont(new Font("Courier New", Font.PLAIN, 30));
    }

    public void setHighlighted(boolean b) {

        if (highlighted) {
            toggleHighlighted();
        }
        highlighted = b;
    }

    public void toggleHighlighted() {
        highlighted = !highlighted;

        if (note.charAt(1) == '#') {
            if (highlighted) {
                this.setBackground(new Color(220, 220, 0));
                playNote();
            } else {
                this.setBackground(Color.BLACK);
            }
        } else if (highlighted) {
            this.setBackground(Color.YELLOW);
            playNote();
        } else {
            this.setBackground(Color.WHITE);
        }
    }

    void playNote() {
        {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds\\" + note + ".wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }
    }

    public void keyNameToggle(boolean b) {
        String displayNote = note.substring(0, note.length() - 1);
        if (b) {
            this.setText(displayNote);
            if (note.charAt(1) == '#') {
                this.setFont(new Font("Courier New", Font.PLAIN, 17));
            }
            switch (note.charAt(note.length() - 1)) {
                case '1':
                    this.setForeground(Color.ORANGE);
                    break;
                case '2':
                    this.setForeground(Color.GREEN);
                    break;
                case '3':
                    this.setForeground(Color.MAGENTA);
                    break;
                case '4':
                    this.setForeground(Color.BLUE);
                    break;
            }
        } else {
            this.setText("");
        }
    }

}
