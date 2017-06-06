package prototype.v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class UI extends JFrame {

    public static void main(String[] args) {
        UI ui = new UI();
    }

    public UI() {
        homePage();
    }

    ArrayList<Lesson> lessons = new ArrayList<Lesson>();
    Lesson currentLesson;
    int lessonIndex = 0;
    
      public void homePage(){
        JPanel homePage = new JPanel(new GridLayout(7,1));
        JButton lesson1 = new JButton("Lesson 1: Notes and Keys");
        lesson1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(homePage);
                startLessons(0);
                currentLesson.revalidate();
                currentLesson.repaint();
            }
        });
        JButton lesson2 = new JButton("Lesson 2: Major Chords");
        lesson2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(homePage);
                startLessons(2);
                currentLesson.revalidate();
                currentLesson.repaint();
            }
        });
        JButton lesson3 = new JButton("Lesson 3: Major Scales");
        lesson3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(homePage);
                startLessons(7);
                currentLesson.revalidate();
                currentLesson.repaint();
            }
        });
        JButton lesson4 = new JButton("Lesson 4: Minor Chords ");
        JButton lesson5 = new JButton("Lesson 5: ..... ");
        
        
        homePage.add(lesson1);
        homePage.add(lesson2);
        homePage.add(lesson3);
        homePage.add(lesson4);
        homePage.add(lesson5);
        
        add(homePage);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
    }

    public void startLessons(int selection) {
        lessonIndex = selection;
        //Set Up Lesson 1
        String[] pNotes = new String[]{};
        ArrayList<String> passNotes = new ArrayList<>();
        passNotes.addAll(Arrays.asList(pNotes));
        Lesson lesson1demo = new LessonDemo("lesson1demo1");
        lessons.add(lesson1demo);
        Lesson lesson1exercise = new Lesson1();
        lessons.add(lesson1exercise);

        //Set Up Lesson 2
        pNotes = new String[]{"C2", "E2", "G3"};
        passNotes = new ArrayList<>();
        passNotes.addAll(Arrays.asList(pNotes));
        Lesson lesson2demo1 = new LessonDemo("lesson2demo1");
        lessons.add(lesson2demo1);
        Lesson lesson2demo2 = new LessonDemo("lesson2demo2");
        lessons.add(lesson2demo2);
        Lesson lesson2exercise = new Lesson2();
        lessons.add(lesson2exercise);
        Lesson lesson2demo3 = new LessonDemo("lesson2demo3");
        lessons.add(lesson2demo3);
        Lesson lesson2exercise2 = new Lesson3();
        lessons.add(lesson2exercise2);
        
        //Set Up Lesson 3
        Lesson lesson3demo1 = new LessonDemo("lesson3demo1");
        lessons.add(lesson3demo1);
        Lesson lesson3demo2 = new LessonDemo("lesson3demo2");
        lessons.add(lesson3demo2);
        Lesson lesson3exercise = new Lesson4();
        lessons.add(lesson3exercise);
        
        
        
        currentLesson = lessons.get(lessonIndex);

        JPanel topBar = new JPanel(new GridLayout(1, 3));
        topBar.setPreferredSize(new Dimension(1280, 50));
        topBar.setBackground(Color.lightGray);
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (lessonIndex > 0) {
                    lessonIndex--;
                    remove(currentLesson);
                    currentLesson = lessons.get(lessonIndex);
                    add(currentLesson, BorderLayout.CENTER);
                    currentLesson.revalidate();
                    currentLesson.repaint();
                }
            }
        });
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(backButton);
        JLabel topBarText = new JLabel("Music Theory Teacher");
        topBarText.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(topBarText);
        JButton forwardButton = new JButton("Forward");
        forwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (lessonIndex < lessons.size()-1) {
                    lessonIndex++;
                    remove(currentLesson);
                    currentLesson = lessons.get(lessonIndex);
                    add(currentLesson, BorderLayout.CENTER);
                    currentLesson.revalidate();
                    currentLesson.repaint();
                }
            }
        });
        forwardButton.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(forwardButton);

        add(topBar, BorderLayout.PAGE_START);
        add(currentLesson, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
    }

}
