package us.jakesystems.newfile;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

class NewFile{
    public static void main(String[] args){

        final String version = "2.0.0";
        final String phrase = "Open to Misinterpretation";


        JFrame root = new JFrame("Text Editor: Open to Misinterpretation");
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setSize(500,350);

        //menubar items
        JMenuBar mb = new JMenuBar();
        JMenu op1 = new JMenu("File");
        JMenu op2 = new JMenu("About");
        JMenu op3 = new JMenu("Settings");
        mb.add(op1);
        mb.add(op2);
        mb.add(op3);
        JMenuItem openOption = new JMenuItem("Open");
        JMenuItem op22 = new JMenuItem("Save");
        JMenuItem opB = new JMenuItem("About this software");
        JMenuItem opWeb = new JMenuItem("Website");
        JMenuItem whiteTheme = new JMenuItem("Light Theme");
        JMenuItem darkTheme = new JMenuItem("Dark Theme");
        op1.add(openOption);
        op1.add(op22);
        op2.add(opB);
        op2.add(opWeb);
        op3.add(whiteTheme);
        op3.add(darkTheme);
        root.getContentPane().add(mb);


        //bottom menu items
        JPanel btmpanel = new JPanel();
        JLabel fileNamer = new JLabel("File Name: ");
        JTextField fileName = new JTextField(10);
        btmpanel.add(fileNamer);
        btmpanel.add(fileName);
        btmpanel.setBackground(Color.BLACK);
        btmpanel.setForeground(Color.WHITE);
        fileNamer.setForeground(Color.WHITE);


        //sorta by itself... I didnt know where else to put it
        JTextArea textb = new JTextArea();
        textb.setBackground(Color.BLACK);
        textb.setForeground(Color.WHITE);

        //second window
        JFrame about_win = new JFrame("About Text Editor");
        about_win.setSize(375, 400);
        about_win.setResizable(false);
        JTextArea contents = new JTextArea();
        contents.setText("This software was developed by Jacob Cornelison.\nDeveloped in 2021.\nVersion: " + version + ", " + phrase + " edition" + "\n\nVisit https://jakesystems.us/ for information about the developer\n\nThis software runs in the Java Virtual Machine (JVM) which\nallows it to operate universally on any device.\n\nThis software should remain free under all\ncircumstances\nThis software should always credit Jacob Cornelison as the\noriginal creator.");
        contents.setEditable(false);
        contents.setForeground(Color.WHITE);
        contents.setBackground(Color.BLACK);
        about_win.add(contents);


        //gives buttons a purpose

        op22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String boxContent = textb.getText();
                String contentFileName = fileName.getText();
                try {
                    FileWriter logFile = new FileWriter(contentFileName + ".txt");
                    logFile.write(boxContent);
                    logFile.close();
                    System.out.println("Wrote to file " + contentFileName + ".txt");
                } catch (IOException a) {
                    System.out.println("an error occurred.");
                    a.printStackTrace();
                }
            }
        });

        opB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                about_win.setVisible(true);
            }
        });

        opWeb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(root, "This option is currently disabled. VERSION: " + version, "'Website','opWeb' disabled", JOptionPane.WARNING_MESSAGE);
            }
        });

        openOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(root, "This option is currently disabled. VERSION: " + version, "'Open','openOption' disabled", JOptionPane.WARNING_MESSAGE);
            }
        });

        whiteTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textb.setBackground(Color.WHITE);
                textb.setForeground(Color.BLACK);
                btmpanel.setBackground(Color.WHITE);
                btmpanel.setForeground(Color.BLACK);
                fileNamer.setForeground(Color.BLACK);
                contents.setForeground(Color.BLACK);
                contents.setBackground(Color.WHITE);
            }
        });

        darkTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textb.setBackground(Color.BLACK);
                textb.setForeground(Color.WHITE);
                btmpanel.setBackground(Color.BLACK);
                btmpanel.setForeground(Color.WHITE);
                fileNamer.setForeground(Color.WHITE);
                contents.setForeground(Color.WHITE);
                contents.setBackground(Color.BLACK);
            }
        });


        root.getContentPane().add(BorderLayout.NORTH, mb);
        root.getContentPane().add(BorderLayout.SOUTH, btmpanel);
        root.getContentPane().add(BorderLayout.CENTER, textb);
        root.setVisible(true);
    }

}

//FIXME
// - add support for file dialog
