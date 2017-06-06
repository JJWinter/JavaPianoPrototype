package prototype.v2;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jw468
 */
public class LessonDemo extends Lesson{
    
    
    
    public LessonDemo(String displayImg) {
        super(displayImg);
        
        JLabel demoImg = new JLabel();
        demoImg.setIcon(new ImageIcon("demos/" + displayImg + ".png"));
        
        add(demoImg);
    }
    
}
