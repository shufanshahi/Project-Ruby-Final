package org.example.rubyfinal;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CubeDisplayer extends JFrame implements ActionListener{

    CubePainter cubePainter; //The JPanel that will handle painting and user input
    JMenuBar menuBar;
    JMenu modes;

    JMenuItem colorSelection, scramble;
    public  void displayCube() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CubeDisplayer();
            }
        });
    }



//     Creates a new CubeDisplayer and initializes it with a new CubePainter for the user
//     to interact with.

    public CubeDisplayer() {
        setTitle("Cube Displayer");
        setLayout(new BorderLayout());

        setSize(700, 770);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIgnoreRepaint(true);

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(31,	40	,51));
        modes = new JMenu("Mode Selection");
        modes.setForeground(new Color(31,	40	,51));
        colorSelection = new JMenuItem("Color Selection Mode");
        scramble = new JMenuItem("Text Scramble Mode");

        modes.add(colorSelection);
        modes.add(scramble);
        colorSelection.addActionListener(this);
        scramble.addActionListener(this);
        menuBar.add(modes);
        setJMenuBar(menuBar);

        //Create a new CubePainter JPanel
        cubePainter = new CubePainter();
        add(cubePainter);
        cubePainter.setVisible(true);
        cubePainter.setEnabled(true);

        menuBar.setVisible(true);
        setVisible(true);
        this.repaint();


    }


//    Toggles between color selection mode and text scramble mode in the cubePainter instance.

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == colorSelection) {
            cubePainter.setInSolution(false);
            cubePainter.updateMode(CubePainter.COLOR_SELECTION);
        }
        else if(e.getSource() == scramble) {
            cubePainter.setInSolution(true);
            cubePainter.updateMode(CubePainter.TEXT_SCRAMBLE);
        }
    }
}

