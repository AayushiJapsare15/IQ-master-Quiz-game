package mains;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.JFrame;

public class IQmaster implements ActionListener {
    JLabel title, name, age, profession, questionNo, question, result, scorelb;
    JTextField namet, aget;
    JComboBox professionList;
    JButton start, b1, b2, ans1, b4, b5, b6, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9, ans10, ans11, ans12, ans13, ans14, ans15, next, next2, previous2, next3, previous3, next4, previous4, next5, previous5, next6, previous6, next7, previous7, next8, previous8, next9, previous9, next10, previous10, next11, previous11, next12, previous12, next13, previous13, next14, previous14, next15, previous15,restart,exit;
    JFrame frame;
    JFrame frameOfLP;
    JScrollPane jScrollPane;
    JPanel panel;
    String nameLP;
    int score = 0;
    int ageNum = 0;
    int iq , avgIq;

    public IQmaster() throws IOException {
        frame = new JFrame("IQ MASTER");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(185, 185, 185));
        frame.setBounds(350, 135, 874, 670);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new JLabel("IQ Master");
        title.setForeground(new Color(0, 8, 252));
        title.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 57));
        title.setBounds(270, 20, 800, 70);
        frame.add(title);

        name = new JLabel("NAME : ");
        name.setForeground(new Color(0, 13, 255, 255));
        name.setFont(new Font("verdana", Font.PLAIN, 23));
        name.setBounds(160, 150, 150, 50);
        frame.add(name);

        age = new JLabel("AGE : ");
        age.setForeground(new Color(0, 13, 255, 255));
        age.setFont(new Font("verdana", Font.PLAIN, 23));
        age.setBounds(160, 220, 100, 50);
        frame.add(age);

        profession = new JLabel("PROFESSION : ");
        profession.setForeground(new Color(0, 13, 255, 255));
        profession.setFont(new Font("verdana", Font.PLAIN, 23));
        profession.setBounds(160, 290, 190, 50);
        frame.add(profession);

        namet = new JTextField();
        namet.setBounds(370, 162, 300, 33);
        namet.setFont(new Font("verdana", Font.PLAIN, 20));
        frame.add(namet);

        aget = new JTextField();
        aget.setBounds(370, 232, 300, 33);
        aget.setFont(new Font("verdana", Font.PLAIN, 20));
        frame.add(aget);

        professionList = new JComboBox();
        File file = new File("D:\\java Projects\\IQpoject\\src\\professionList.txt");
        Scanner scanner2 = new Scanner(file);

        // calculating the file lines
        int lineCount = 0;
        while (scanner2.hasNextLine()) {
            lineCount++;
            scanner2.nextLine();
        }

        // putting the movies names into array
        Scanner scanner = new Scanner(file);
        String[] list = new String[lineCount];
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextLine();
        }

        professionList = new JComboBox(list);
        professionList.setBounds(370, 290, 300, 33);
        professionList.setFont(new Font("verdana", Font.PLAIN, 18));
        frame.add(professionList);

        start = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\b2.PNG"));
            start.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        start.setBackground(new Color(33, 0, 65));
        start.setBounds(314, 430, 220, 50);
        frame.add(start);

        //activeListeners
        start.addActionListener(this);

    }

    //DATASETS of charts
    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("CORRECT", score);
        dataset.setValue("INCORRECT", 15 - score);
        return dataset;
    }

    private CategoryDataset createDataset2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(iq, "YOUR IQ          ", " ");
        dataset.addValue(avgIq, "AVERAGE IQ", " ");
        return dataset;
    }


    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            try {
                IQmaster obj = new IQmaster();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void ques1(JFrame frame) {

        frame = new JFrame("question 1");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(210, 210, 210));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 1 ");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 150, 30);
        frame.add(questionNo);

        question = new JLabel("<html>\n" +
                "Mary had several cookies. After eating one, she gave half the remainder to her sister. After eating another cookie, she gave half of what was left to her brother. Mary now had only five cookies left. How many cookies did she start with?");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next = new JButton(">");
        next.setFont(new Font("verdana", Font.BOLD, 18));
        next.setForeground(new Color(17, 17, 17));
        next.setBackground(new Color(255, 255, 255, 255));
        next.setBounds(827, 260, 50, 90);
        frame.add(next);

        b1 = new JButton("11");
        b1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setForeground(new Color(74, 73, 73, 255));
        b1.setBackground(new Color(104, 255, 51, 255));
        b1.setBounds(55, 220, 740, 50);
        frame.add(b1);

        b2 = new JButton("22");
        b2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setForeground(new Color(74, 73, 73, 255));
        b2.setBackground(new Color(104, 255, 51, 255));
        b2.setBounds(55, 285, 740, 50);
        frame.add(b2);

        ans1 = new JButton("23");
        ans1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans1.setHorizontalAlignment(SwingConstants.LEFT);
        ans1.setForeground(new Color(74, 73, 73, 255));
        ans1.setBackground(new Color(104, 255, 51, 255));
        ans1.setBounds(55, 350, 740, 50);
        frame.add(ans1);

        b4 = new JButton("45");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        frame.add(b4);

        b5 = new JButton("46");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        frame.add(b5);

        b6 = new JButton("59");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next.addActionListener(this);
        ans1.addActionListener(this);
    }

    public void ques2(JFrame frame) {
        JLabel questionNo2, question2;
        JButton b102, b202, b302, b402, b502, b602;


        frame = new JFrame("question 2");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(210, 210, 210));
        frame.setBounds(350, 135, 870, 670);

        questionNo2 = new JLabel("Question no 2");
        questionNo2.setForeground(new Color(0, 13, 255, 255));
        questionNo2.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo2.setBounds(55, 25, 100, 30);
        frame.add(questionNo2);

        question2 = new JLabel("<html>Which number should come next in the pattern? <br/> <br/> 37, 34, 31, 28</html>");
        question2.setForeground(new Color(18, 18, 24, 255));
        question2.setFont(new Font("verdana", Font.PLAIN, 20));
        question2.setBounds(55, 85, 740, 100);
        frame.add(question2);

        next2 = new JButton(">");
        next2.setFont(new Font("verdana", Font.BOLD, 18));
        next2.setBackground(new Color(255, 255, 255, 255));
        next2.setForeground(new Color(0, 0, 0));
        next2.setBounds(827, 260, 50, 90);
        frame.add(next2);

        previous2 = new JButton("<");
        previous2.setFont(new Font("verdana", Font.BOLD, 18));
        previous2.setBackground(new Color(255, 255, 255, 255));
        previous2.setForeground(new Color(0, 0, 0));
        previous2.setBounds(-20, 260, 50, 90);
        frame.add(previous2);

        b102 = new JButton("20");
        b102.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b102.setHorizontalAlignment(SwingConstants.LEFT);
        b102.setForeground(new Color(74, 73, 73, 255));
        b102.setBackground(new Color(104, 255, 51, 255));
        b102.setBounds(55, 220, 740, 50);
        frame.add(b102);

        b202 = new JButton("18");
        b202.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b202.setHorizontalAlignment(SwingConstants.LEFT);
        b202.setForeground(new Color(74, 73, 73, 255));
        b202.setBackground(new Color(104, 255, 51, 255));
        b202.setBounds(55, 285, 740, 50);
        frame.add(b202);

        b302 = new JButton("37");
        b302.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b302.setHorizontalAlignment(SwingConstants.LEFT);
        b302.setForeground(new Color(74, 73, 73, 255));
        b302.setBackground(new Color(104, 255, 51, 255));
        b302.setBounds(55, 350, 740, 50);
        frame.add(b302);

        ans2 = new JButton("25");
        ans2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans2.setHorizontalAlignment(SwingConstants.LEFT);
        ans2.setForeground(new Color(74, 73, 73, 255));
        ans2.setBackground(new Color(104, 255, 51, 255));
        ans2.setBounds(55, 415, 740, 50);
        frame.add(ans2);

        b502 = new JButton("40");
        b502.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b502.setHorizontalAlignment(SwingConstants.LEFT);
        b502.setForeground(new Color(74, 73, 73, 255));
        b502.setBackground(new Color(104, 255, 51, 255));
        b502.setBounds(55, 480, 740, 50);
        frame.add(b502);

        b602 = new JButton("24");
        b602.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b602.setHorizontalAlignment(SwingConstants.LEFT);
        b602.setForeground(new Color(74, 73, 73, 255));
        b602.setBackground(new Color(104, 255, 51, 255));
        b602.setBounds(55, 545, 740, 50);
        frame.add(b602);

        next2.addActionListener(this);
        previous2.addActionListener(this);
        ans2.addActionListener(this);

    }


    public void ques3(JFrame panel) {

        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;

        panel = new JFrame("question 3");
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(new Color(210, 210, 210));
        panel.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 3");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 100, 30);
        panel.add(questionNo);

        question = new JLabel("<html>Two people can make 2 bicycles in 2 hours. How many people are needed to make 12 bicycles in 6 hours?<html/>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        panel.add(question);

        next3 = new JButton(">");
        next3.setFont(new Font("verdana", Font.BOLD, 18));
        next3.setForeground(new Color(17, 17, 17));
        next3.setBackground(new Color(255, 255, 255));
        next3.setBounds(827, 260, 50, 90);
        panel.add(next3);

        previous3 = new JButton("<");
        previous3.setFont(new Font("verdana", Font.BOLD, 18));
        previous3.setForeground(new Color(17, 17, 17));
        previous3.setBackground(new Color(255, 255, 255));
        previous3.setBounds(-20, 260, 50, 90);
        panel.add(previous3);

        b1 = new JButton("6");
        b1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setForeground(new Color(74, 73, 73, 255));
        b1.setBackground(new Color(104, 255, 51, 255));
        b1.setBounds(55, 220, 740, 50);
        panel.add(b1);

        ans3 = new JButton("4");
        ans3.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans3.setHorizontalAlignment(SwingConstants.LEFT);
        ans3.setForeground(new Color(74, 73, 73, 255));
        ans3.setBackground(new Color(104, 255, 51, 255));
        ans3.setBounds(55, 285, 740, 50);
        panel.add(ans3);

        b3 = new JButton("2");
        b3.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.setForeground(new Color(74, 73, 73, 255));
        b3.setBackground(new Color(104, 255, 51, 255));
        b3.setBounds(55, 350, 740, 50);
        panel.add(b3);

        b4 = new JButton("1");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        panel.add(b4);

        b5 = new JButton("0");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        panel.add(b5);

        b6 = new JButton("10");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        panel.add(b6);


        next3.addActionListener(this);
        previous3.addActionListener(this);
        ans3.addActionListener(this);
    }

    public void ques4(JFrame frame) {
        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;


        frame = new JFrame("question 4");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 4");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 100, 30);
        frame.add(questionNo);

        question = new JLabel("<html>Which one of the five makes the best comparison?   <br/><br/> CAACCAC is to 3113313 as CACAACAC is to:</html>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next4 = new JButton(">");
        next4.setFont(new Font("verdana", Font.BOLD, 18));
        next4.setForeground(new Color(17, 17, 17));
        next4.setBackground(new Color(255, 255, 255));
        next4.setBounds(827, 260, 50, 90);
        frame.add(next4);

        previous4 = new JButton("<");
        previous4.setFont(new Font("verdana", Font.BOLD, 18));
        previous4.setForeground(new Color(17, 17, 17));
        previous4.setBackground(new Color(255, 255, 255));
        previous4.setBounds(-20, 260, 50, 90);
        frame.add(previous4);

        b1 = new JButton("31313113");
        b1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setForeground(new Color(74, 73, 73, 255));
        b1.setBackground(new Color(104, 255, 51, 255));
        b1.setBounds(55, 220, 740, 50);
        frame.add(b1);

        ans4 = new JButton("31311313");
        ans4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans4.setHorizontalAlignment(SwingConstants.LEFT);
        ans4.setForeground(new Color(74, 73, 73, 255));
        ans4.setBackground(new Color(104, 255, 51, 255));
        ans4.setBounds(55, 285, 740, 50);
        frame.add(ans4);

        b3 = new JButton("31311131");
        b3.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.setForeground(new Color(74, 73, 73, 255));
        b3.setBackground(new Color(104, 255, 51, 255));
        b3.setBounds(55, 350, 740, 50);
        frame.add(b3);

        b4 = new JButton("13133131");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        frame.add(b4);

        b5 = new JButton("13133313");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        frame.add(b5);

        b6 = new JButton("13113133");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next4.addActionListener(this);
        previous4.addActionListener(this);
        ans4.addActionListener(this);
    }

    public void ques5(JFrame frame) {

        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;

        frame = new JFrame("question 5");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 5");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 200, 30);
        frame.add(questionNo);

        question = new JLabel("<html>In a lake, there is a patch of lily pads. Every day, the patch doubles in size. If it takes 48 days for the patch to cover the entire lake, how long would it take for the patch to cover half of the lake? </html>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next5 = new JButton(">");
        next5.setFont(new Font("verdana", Font.BOLD, 18));
        next5.setForeground(new Color(0, 0, 0, 255));
        next5.setBackground(new Color(255, 255, 255));
        next5.setBounds(827, 260, 50, 90);
        frame.add(next5);

        previous5 = new JButton("<");
        previous5.setFont(new Font("verdana", Font.BOLD, 18));
        previous5.setForeground(new Color(0, 0, 0, 255));
        previous5.setBackground(new Color(255, 255, 255));
        previous5.setBounds(-20, 260, 50, 90);
        frame.add(previous5);

        b1 = new JButton("49 days");
        b1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setForeground(new Color(74, 73, 73, 255));
        b1.setBackground(new Color(104, 255, 51, 255));
        b1.setBounds(55, 220, 740, 50);
        frame.add(b1);

        b2 = new JButton("96 days");
        b2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setForeground(new Color(74, 73, 73, 255));
        b2.setBackground(new Color(104, 255, 51, 255));
        b2.setBounds(55, 285, 740, 50);
        frame.add(b2);

        ans5 = new JButton("47 days");
        ans5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans5.setHorizontalAlignment(SwingConstants.LEFT);
        ans5.setForeground(new Color(74, 73, 73, 255));
        ans5.setBackground(new Color(104, 255, 51, 255));
        ans5.setBounds(55, 350, 740, 50);
        frame.add(ans5);

        b4 = new JButton("94 days");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        frame.add(b4);

        b5 = new JButton("20 days");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        frame.add(b5);

        b6 = new JButton("None of these");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next5.addActionListener(this);
        previous5.addActionListener(this);
        ans5.addActionListener(this);
    }

    public void ques6(JFrame frame) throws IOException {
        JLabel questionNo;
        JButton b1, b2, b3, b4, b5;


        frame = new JFrame("question 6");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 6");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 18, 200, 30);
        frame.add(questionNo);

        BufferedImage myPicture = ImageIO.read(new File("D:\\question1.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(75, 68, 700, 230);
        frame.add(picLabel);

        next6 = new JButton(">");
        next6.setFont(new Font("verdana", Font.BOLD, 18));
        next6.setForeground(new Color(0, 0, 0, 255));
        next6.setBackground(new Color(255, 253, 253));
        next6.setBounds(827, 260, 50, 90);
        frame.add(next6);

        previous6 = new JButton("<");
        previous6.setFont(new Font("verdana", Font.BOLD, 18));
        previous6.setForeground(new Color(0, 0, 0, 255));
        previous6.setBackground(new Color(255, 255, 255));
        previous6.setBounds(-20, 260, 50, 90);
        frame.add(previous6);

        ans6 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\11.png"));
            ans6.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        ans6.setBackground(new Color(245, 245, 245));
        ans6.setBounds(37, 390, 153, 185);
        //b1.setBounds(55,350,153,185);
        frame.add(ans6);

        b2 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\22.png"));
            b2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b2.setBackground(new Color(245, 245, 245));
        b2.setBounds(197, 390, 153, 185);
        frame.add(b2);

        b3 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\33.png"));
            b3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b3.setBackground(new Color(245, 245, 245));
        b3.setBounds(357, 390, 153, 185);
        frame.add(b3);

        b4 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\44.png"));
            b4.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b4.setBackground(new Color(245, 245, 245));
        b4.setBounds(517, 390, 153, 185);
        frame.add(b4);

        b5 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\55.png"));
            b5.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b5.setBackground(new Color(245, 245, 245));
        b5.setBounds(677, 390, 153, 185);
        frame.add(b5);

        next6.addActionListener(this);
        previous6.addActionListener(this);
        ans6.addActionListener(this);
    }

    public void ques7(JFrame frame) {

        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;

        frame = new JFrame("question 7");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 7");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 100, 30);
        frame.add(questionNo);

        question = new JLabel("<html>The price of an article was cut by 20% for sale. By what percent must the discounted item be increased to again sell the article at the original price?</html>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next7 = new JButton(">");
        next7.setFont(new Font("verdana", Font.BOLD, 18));
        next7.setForeground(new Color(0, 0, 0, 255));
        next7.setBackground(new Color(255, 254, 254));
        next7.setBounds(827, 260, 50, 90);
        frame.add(next7);

        previous7 = new JButton("<");
        previous7.setFont(new Font("verdana", Font.BOLD, 18));
        previous7.setForeground(new Color(0, 0, 0, 255));
        previous7.setBackground(new Color(255, 255, 255));
        previous7.setBounds(-20, 260, 50, 90);
        frame.add(previous7);

        b1 = new JButton("\n" +
                "15%");
        b1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setForeground(new Color(74, 73, 73, 255));
        b1.setBackground(new Color(104, 255, 51, 255));
        b1.setBounds(55, 220, 740, 50);
        frame.add(b1);

        b2 = new JButton("\n" +
                "20%\n");
        b2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setForeground(new Color(74, 73, 73, 255));
        b2.setBackground(new Color(104, 255, 51, 255));
        b2.setBounds(55, 285, 740, 50);
        frame.add(b2);

        ans7 = new JButton("25%");
        ans7.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans7.setHorizontalAlignment(SwingConstants.LEFT);
        ans7.setForeground(new Color(74, 73, 73, 255));
        ans7.setBackground(new Color(104, 255, 51, 255));
        ans7.setBounds(55, 350, 740, 50);
        frame.add(ans7);

        b4 = new JButton("30%");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        frame.add(b4);

        b5 = new JButton("35%");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        frame.add(b5);

        b6 = new JButton("27%");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next7.addActionListener(this);
        previous7.addActionListener(this);
        ans7.addActionListener(this);
    }

    public void ques8(JFrame frame) {

        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;

        frame = new JFrame("question 8");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 8");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 100, 30);
        frame.add(questionNo);

        question = new JLabel("<html>WWhat starts with \"E\" and ends with \"E\" but only has one letter in it?</html>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next8 = new JButton(">");
        next8.setFont(new Font("verdana", Font.BOLD, 18));
        next8.setForeground(new Color(0, 0, 0, 255));
        next8.setBackground(new Color(255, 255, 255));
        next8.setBounds(827, 260, 50, 90);
        frame.add(next8);

        previous8 = new JButton("<");
        previous8.setFont(new Font("verdana", Font.BOLD, 18));
        previous8.setForeground(new Color(0, 0, 0, 255));
        previous8.setBackground(new Color(255, 255, 255));
        previous8.setBounds(-20, 260, 50, 90);
        frame.add(previous8);

        ans8 = new JButton("Envelope");
        ans8.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans8.setHorizontalAlignment(SwingConstants.LEFT);
        ans8.setForeground(new Color(74, 73, 73, 255));
        ans8.setBackground(new Color(104, 255, 51, 255));
        ans8.setBounds(55, 220, 740, 50);
        frame.add(ans8);

        b2 = new JButton("Eeee");
        b2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setForeground(new Color(74, 73, 73, 255));
        b2.setBackground(new Color(104, 255, 51, 255));
        b2.setBounds(55, 285, 740, 50);
        frame.add(b2);

        b3 = new JButton("Eww");
        b3.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.setForeground(new Color(74, 73, 73, 255));
        b3.setBackground(new Color(104, 255, 51, 255));
        b3.setBounds(55, 350, 740, 50);
        frame.add(b3);

        b4 = new JButton("Erie");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        frame.add(b4);

        b5 = new JButton("Equine");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        frame.add(b5);

        b6 = new JButton("Evidence");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next8.addActionListener(this);
        previous8.addActionListener(this);
        ans8.addActionListener(this);
    }

    public void ques9(JFrame frame) {
        JLabel questionNo;
        JButton b1, b2, b3, b4, b5;

        frame = new JFrame("question 9");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 9");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 18, 200, 30);
        frame.add(questionNo);

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("D:\\question2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(75, 68, 700, 230);
        frame.add(picLabel);

        next9 = new JButton(">");
        next9.setFont(new Font("verdana", Font.BOLD, 18));
        next9.setForeground(new Color(0, 0, 0, 255));
        next9.setBackground(new Color(255, 255, 255));
        next9.setBounds(827, 260, 50, 90);
        frame.add(next9);

        previous9 = new JButton("<");
        previous9.setFont(new Font("verdana", Font.BOLD, 18));
        previous9.setForeground(new Color(0, 0, 0, 255));
        previous9.setBackground(new Color(255, 255, 255));
        previous9.setBounds(-20, 260, 50, 90);
        frame.add(previous9);

        b1 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\1.png"));
            b1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b1.setBackground(new Color(245, 245, 245));
        b1.setBounds(37, 390, 153, 185);
        //b1.setBounds(55,350,153,185);
        frame.add(b1);

        b2 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\2.png"));
            b2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b2.setBackground(new Color(245, 245, 245));
        b2.setBounds(197, 390, 153, 185);
        frame.add(b2);

        b3 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\3.png"));
            b3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b3.setBackground(new Color(245, 245, 245));
        b3.setBounds(357, 390, 153, 185);
        frame.add(b3);

        b4 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\4.png"));
            b4.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b4.setBackground(new Color(245, 245, 245));
        b4.setBounds(517, 390, 153, 185);
        frame.add(b4);

        ans9 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\5.png"));
            ans9.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        ans9.setBackground(new Color(245, 245, 245));
        ans9.setBounds(677, 390, 153, 185);
        frame.add(ans9);

        next9.addActionListener(this);
        previous9.addActionListener(this);
        ans9.addActionListener(this);
    }

    public void ques10(JFrame frame) {
        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;

        frame = new JFrame("question 10");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 10");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 150, 30);
        frame.add(questionNo);

        question = new JLabel("<html>Which one of the five makes the best comparison? <br/><br/> Brother is to sister as niece is to:   </html>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next10 = new JButton(">");
        next10.setFont(new Font("verdana", Font.BOLD, 18));
        next10.setForeground(new Color(0, 0, 0, 255));
        next10.setBackground(new Color(255, 255, 255));
        next10.setBounds(827, 260, 50, 90);
        frame.add(next10);

        previous10 = new JButton("<");
        previous10.setFont(new Font("verdana", Font.BOLD, 18));
        previous10.setForeground(new Color(0, 0, 0, 255));
        previous10.setBackground(new Color(255, 255, 255));
        previous10.setBounds(-20, 260, 50, 90);
        frame.add(previous10);

        b1 = new JButton("Mother");
        b1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setForeground(new Color(74, 73, 73, 255));
        b1.setBackground(new Color(104, 255, 51, 255));
        b1.setBounds(55, 220, 740, 50);
        frame.add(b1);

        b2 = new JButton("Daughter");
        b2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setForeground(new Color(74, 73, 73, 255));
        b2.setBackground(new Color(104, 255, 51, 255));
        b2.setBounds(55, 285, 740, 50);
        frame.add(b2);

        b3 = new JButton("Aunt");
        b3.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.setForeground(new Color(74, 73, 73, 255));
        b3.setBackground(new Color(104, 255, 51, 255));
        b3.setBounds(55, 350, 740, 50);
        frame.add(b3);

        b4 = new JButton("Uncle");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        frame.add(b4);

        ans10 = new JButton("Nephew");
        ans10.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans10.setHorizontalAlignment(SwingConstants.LEFT);
        ans10.setForeground(new Color(74, 73, 73, 255));
        ans10.setBackground(new Color(104, 255, 51, 255));
        ans10.setBounds(55, 480, 740, 50);
        frame.add(ans10);

        b6 = new JButton("Father");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next10.addActionListener(this);
        previous10.addActionListener(this);
        ans10.addActionListener(this);
    }

    public void ques11(JFrame frame) {
        JLabel questionNo;
        JButton b1, b2, b3, b4, b5;

        frame = new JFrame("question 11");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 11");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 18, 200, 30);
        frame.add(questionNo);

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("D:\\question3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(80, 68, 745, 255);
        frame.add(picLabel);

        next11 = new JButton(">");
        next11.setFont(new Font("verdana", Font.BOLD, 18));
        next11.setForeground(new Color(0, 0, 0, 255));
        next11.setBackground(new Color(255, 255, 255));
        next11.setBounds(827, 260, 50, 90);
        frame.add(next11);

        previous11 = new JButton("<");
        previous11.setFont(new Font("verdana", Font.BOLD, 18));
        previous11.setForeground(new Color(0, 0, 0, 255));
        previous11.setBackground(new Color(255, 255, 255));
        previous11.setBounds(-20, 260, 50, 90);
        frame.add(previous11);

        b1 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\111.png"));
            b1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b1.setBackground(new Color(245, 245, 245));
        b1.setBounds(37, 390, 153, 185);
        //b1.setBounds(55,350,153,185);
        frame.add(b1);

        ans11 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\222.png"));
            ans11.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        ans11.setBackground(new Color(245, 245, 245));
        ans11.setBounds(197, 390, 153, 185);
        frame.add(ans11);

        b3 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\333.png"));
            b3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b3.setBackground(new Color(245, 245, 245));
        b3.setBounds(357, 390, 153, 185);
        frame.add(b3);

        b4 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\444.png"));
            b4.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b4.setBackground(new Color(245, 245, 245));
        b4.setBounds(517, 390, 153, 185);
        frame.add(b4);

        b5 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\555.png"));
            b5.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b5.setBackground(new Color(245, 245, 245));
        b5.setBounds(677, 390, 153, 185);
        frame.add(b5);

        next11.addActionListener(this);
        previous11.addActionListener(this);
        ans11.addActionListener(this);
    }

    public void ques12(JFrame frame) {

        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;

        frame = new JFrame("question 12");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 12");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 150, 30);
        frame.add(questionNo);

        question = new JLabel("<html>A bat and a ball cost $1.10 in total. The bat costs $1 more than the ball. How much does the ball cost? </html>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next12 = new JButton(">");
        next12.setFont(new Font("verdana", Font.BOLD, 18));
        next12.setForeground(new Color(0, 0, 0, 255));
        next12.setBackground(new Color(255, 255, 255));
        next12.setBounds(827, 260, 50, 90);
        frame.add(next12);

        previous12 = new JButton("<");
        previous12.setFont(new Font("verdana", Font.BOLD, 18));
        previous12.setForeground(new Color(0, 0, 0, 255));
        previous12.setBackground(new Color(255, 255, 255));
        previous12.setBounds(-20, 260, 50, 90);
        frame.add(previous12);

        ans12 = new JButton("$0.05");
        ans12.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans12.setHorizontalAlignment(SwingConstants.LEFT);
        ans12.setForeground(new Color(74, 73, 73, 255));
        ans12.setBackground(new Color(104, 255, 51, 255));
        ans12.setBounds(55, 220, 740, 50);
        frame.add(ans12);

        b2 = new JButton("$0.10");
        b2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setForeground(new Color(74, 73, 73, 255));
        b2.setBackground(new Color(104, 255, 51, 255));
        b2.setBounds(55, 285, 740, 50);
        frame.add(b2);

        b3 = new JButton("$1.0");
        b3.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.setForeground(new Color(74, 73, 73, 255));
        b3.setBackground(new Color(104, 255, 51, 255));
        b3.setBounds(55, 350, 740, 50);
        frame.add(b3);

        b4 = new JButton("$1.5");
        b4.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setForeground(new Color(74, 73, 73, 255));
        b4.setBackground(new Color(104, 255, 51, 255));
        b4.setBounds(55, 415, 740, 50);
        frame.add(b4);

        b5 = new JButton("$1.05");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        frame.add(b5);

        b6 = new JButton("None of these");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next12.addActionListener(this);
        previous12.addActionListener(this);
        ans12.addActionListener(this);
    }

    public void ques13(JFrame frame) {
        JLabel questionNo;
        JButton b1, b2, b3, b4, b5;

        frame = new JFrame("question 13");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 13");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 18, 200, 30);
        frame.add(questionNo);

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("D:\\question4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(75, 68, 700, 257);
        frame.add(picLabel);

        next13 = new JButton(">");
        next13.setFont(new Font("verdana", Font.BOLD, 18));
        next13.setForeground(new Color(0, 0, 0, 255));
        next13.setBackground(new Color(255, 255, 255));
        next13.setBounds(827, 260, 50, 90);
        frame.add(next13);

        previous13 = new JButton("<");
        previous13.setFont(new Font("verdana", Font.BOLD, 18));
        previous13.setForeground(new Color(0, 0, 0, 255));
        previous13.setBackground(new Color(255, 255, 255));
        previous13.setBounds(-20, 260, 50, 90);
        frame.add(previous13);

        b1 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\01.png"));
            b1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b1.setBackground(new Color(245, 245, 245));
        b1.setBounds(37, 390, 153, 185);
        //b1.setBounds(55,350,153,185);
        frame.add(b1);

        b2 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\02.png"));
            b2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b2.setBackground(new Color(245, 245, 245));
        b2.setBounds(197, 390, 153, 185);
        frame.add(b2);

        b3 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\03.png"));
            b3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b3.setBackground(new Color(245, 245, 245));
        b3.setBounds(357, 390, 153, 185);
        frame.add(b3);

        b4 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\04.png"));
            b4.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b4.setBackground(new Color(245, 245, 245));
        b4.setBounds(517, 390, 153, 185);
        frame.add(b4);

        ans13 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\05.png"));
            ans13.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        ans13.setBackground(new Color(245, 245, 245));
        ans13.setBounds(677, 390, 153, 185);
        frame.add(ans13);

        next13.addActionListener(this);
        previous13.addActionListener(this);
        ans13.addActionListener(this);
    }

    public void ques14(JFrame frame) {
        JLabel questionNo, question;
        JButton b1, b2, b3, b4, b5, b6;

        frame = new JFrame("question 14");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 14  " );
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 25, 200, 30);
        frame.add(questionNo);

        question = new JLabel("<html>If it takes 5 machines 5 minutes to make 5 widgets, how long would it take 100 machines to make 100 widgets?</html>");
        question.setForeground(new Color(18, 18, 24, 255));
        question.setFont(new Font("verdana", Font.PLAIN, 20));
        question.setBounds(55, 85, 740, 100);
        frame.add(question);

        next14 = new JButton(">");
        next14.setFont(new Font("verdana", Font.BOLD, 18));
        next14.setForeground(new Color(0, 0, 0, 255));
        next14.setBackground(new Color(255, 255, 255));
        next14.setBounds(827, 260, 50, 90);
        frame.add(next14);

        previous14 = new JButton("<");
        previous14.setFont(new Font("verdana", Font.BOLD, 18));
        previous14.setForeground(new Color(0, 0, 0, 255));
        previous14.setBackground(new Color(255, 255, 255));
        previous14.setBounds(-20, 260, 50, 90);
        frame.add(previous14);

        b1 = new JButton("15 minutes");
        b1.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setForeground(new Color(74, 73, 73, 255));
        b1.setBackground(new Color(104, 255, 51, 255));
        b1.setBounds(55, 220, 740, 50);
        frame.add(b1);

        b2 = new JButton("12 minutes");
        b2.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setForeground(new Color(74, 73, 73, 255));
        b2.setBackground(new Color(104, 255, 51, 255));
        b2.setBounds(55, 285, 740, 50);
        frame.add(b2);

        b3 = new JButton("2 minutes");
        b3.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.setForeground(new Color(74, 73, 73, 255));
        b3.setBackground(new Color(104, 255, 51, 255));
        b3.setBounds(55, 350, 740, 50);
        frame.add(b3);

        ans14 = new JButton("5 minutes");
        ans14.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        ans14.setHorizontalAlignment(SwingConstants.LEFT);
        ans14.setForeground(new Color(74, 73, 73, 255));
        ans14.setBackground(new Color(104, 255, 51, 255));
        ans14.setBounds(55, 415, 740, 50);
        frame.add(ans14);

        b5 = new JButton("20 minutes");
        b5.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b5.setHorizontalAlignment(SwingConstants.LEFT);
        b5.setForeground(new Color(74, 73, 73, 255));
        b5.setBackground(new Color(104, 255, 51, 255));
        b5.setBounds(55, 480, 740, 50);
        frame.add(b5);

        b6 = new JButton("10 minutes");
        b6.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
        b6.setHorizontalAlignment(SwingConstants.LEFT);
        b6.setForeground(new Color(74, 73, 73, 255));
        b6.setBackground(new Color(104, 255, 51, 255));
        b6.setBounds(55, 545, 740, 50);
        frame.add(b6);

        next14.addActionListener(this);
        previous14.addActionListener(this);
        ans14.addActionListener(this);
    }

    public void ques15(JFrame frame) {
        JLabel questionNo;
        JButton b1, b2, b3, b4, b5;

        frame = new JFrame("question 15" + score);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(121, 121, 121));
        frame.setBounds(350, 135, 870, 670);

        questionNo = new JLabel("Question no 15");
        questionNo.setForeground(new Color(0, 13, 255, 255));
        questionNo.setFont(new Font("Agency FB", Font.BOLD, 22));
        questionNo.setBounds(55, 18, 200, 30);
        frame.add(questionNo);

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("D:\\question5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(75, 68, 700, 267);
        frame.add(picLabel);

        next15 = new JButton(">");
        next15.setFont(new Font("verdana", Font.BOLD, 18));
        next15.setForeground(new Color(0, 0, 0, 255));
        next15.setBackground(new Color(255, 255, 255));
        next15.setBounds(827, 260, 50, 90);
        frame.add(next15);

        previous15 = new JButton("<");
        previous15.setFont(new Font("verdana", Font.BOLD, 18));
        previous15.setForeground(new Color(0, 0, 0, 255));
        previous15.setBackground(new Color(255, 255, 255));
        previous15.setBounds(-20, 260, 50, 90);
        frame.add(previous15);

        b1 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\51.png"));
            b1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b1.setBackground(new Color(245, 245, 245));
        b1.setBounds(37, 390, 153, 185);
        //b1.setBounds(55,350,153,185);
        frame.add(b1);

        b2 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\52.png"));
            b2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b2.setBackground(new Color(245, 245, 245));
        b2.setBounds(197, 390, 153, 185);
        frame.add(b2);

        b3 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\53.png"));
            b3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b3.setBackground(new Color(245, 245, 245));
        b3.setBounds(357, 390, 153, 185);
        frame.add(b3);

        b4 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\54.png"));
            b4.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b4.setBackground(new Color(245, 245, 245));
        b4.setBounds(517, 390, 153, 185);
        frame.add(b4);

        ans15 = new JButton();
        try {
            Image img = ImageIO.read(new FileInputStream("D:\\55 (2).png"));
            ans15.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        ans15.setBackground(new Color(245, 245, 245));
        ans15.setBounds(677, 390, 153, 185);
        frame.add(ans15);

        next15.addActionListener(this);
        previous15.addActionListener(this);
        ans15.addActionListener(this);
    }

    JFrame frame1 = new JFrame();
    JFrame frame2 = new JFrame();
    JFrame frame3 = new JFrame();
    JFrame frame4 = new JFrame();
    JFrame frame5 = new JFrame();
    JFrame frame6 = new JFrame();
    JFrame frame7 = new JFrame();
    JFrame frame8 = new JFrame();
    JFrame frame9 = new JFrame();
    JFrame frame10 = new JFrame();
    JFrame frame11 = new JFrame();
    JFrame frame12 = new JFrame();
    JFrame frame13 = new JFrame();
    JFrame frame14 = new JFrame();
    JFrame frame15 = new JFrame();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start) {
            ques1(frame1);
            frame.setVisible(false);
        }
        if (e.getSource() == next) {
            ques2(frame2);
        }
        if (e.getSource() == next2) {
            ques3(frame3);
        }
        if (e.getSource() == previous2) {
            ques1(frame1);
        }
        if (e.getSource() == next3) {
            ques4(frame4);
        }
        if (e.getSource() == previous3) {
            ques2(frame2);
        }
        if (e.getSource() == next4) {
            ques5(frame5);
        }
        if (e.getSource() == previous4) {
            ques3(frame3);
        }
        if (e.getSource() == next5) {
            try {
                ques6(frame6);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == previous5) {
            ques4(frame4);
        }
        if (e.getSource() == next6) {
            ques7(frame7);
        }
        if (e.getSource() == previous6) {
            ques5(frame5);
        }
        if (e.getSource() == next7) {
            ques8(frame8);
        }
        if (e.getSource() == previous7) {
            try {
                ques6(frame7);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == next8) {
            ques9(frame9);
        }
        if (e.getSource() == previous8) {
            ques7(frame7);
        }
        if (e.getSource() == next9) {
            ques10(frame10);
        }
        if (e.getSource() == previous9) {
            ques8(frame8);
        }
        if (e.getSource() == next10) {
            ques11(frame11);
        }
        if (e.getSource() == previous10) {
            ques9(frame9);
        }
        if (e.getSource() == next11) {
            ques12(frame12);
        }
        if (e.getSource() == previous11) {
            ques10(frame10);
        }
        if (e.getSource() == next12) {
            ques13(frame13);
        }
        if (e.getSource() == previous12) {
            ques11(frame11);
        }
        if (e.getSource() == next13) {
            ques14(frame14);
        }
        if (e.getSource() == previous13) {
            ques12(frame12);
        }
        if (e.getSource() == next14) {
            ques15(frame15);
        }
        if (e.getSource() == previous14) {
            ques13(frame13);
        }

        if (e.getSource() == previous15) {
            ques14(frame14);
        }

        if (e.getSource() == ans1) {
            score++;

        }
        if (e.getSource() == ans2) {
            score++;

        }
        if (e.getSource() == ans3) {
            score++;

        }
        if (e.getSource() == ans4) {
            score++;

        }
        if (e.getSource() == ans5) {
            score++;

        }
        if (e.getSource() == ans6) {
            score++;

        }
        if (e.getSource() == ans7) {
            score++;

        }
        if (e.getSource() == ans8) {
            score++;

        }
        if (e.getSource() == ans9) {
            score++;

        }
        if (e.getSource() == ans10) {
            score++;

        }
        if (e.getSource() == ans11) {
            score++;

        }
        if (e.getSource() == ans12) {
            score++;

        }
        if (e.getSource() == ans13) {
            score++;

        }
        if (e.getSource() == ans14) {
            score++;

        }
        if (e.getSource() == ans15) {
            score++;

        }

        if (e.getSource() == next15) {
            ageNum = Integer.parseInt(aget.getText());

            iq = 0;
            avgIq = 0;
            if (score>=12){
                iq = 120;
            }
            if (score>=9&& score<=12){
                iq = 119;
            }
            if (score>=7&& score<=9){
                iq = 94;
            }
            if (score>=5&& score<=7){
                iq = 80;
            }
            if (score>=3&& score<=5){
                iq = 75;
            }

            if (ageNum<=17){
                avgIq=108;
            }
            if (ageNum<=19&&ageNum >=18){
                avgIq=105;
            }
            if (ageNum<=24&&ageNum >=20){
                avgIq=99;
            }
            if (ageNum<=34&&ageNum >=25){
                avgIq=97;
            }
            if (ageNum<=44&&ageNum >=35){
                avgIq=101;
            }
            if (ageNum<=54&&ageNum >=45){
                avgIq=106;
            }
            if (ageNum<=64&&ageNum >=55){
                avgIq=109;
            }
            if (ageNum<=69&&ageNum >=65){
                avgIq=114;
            }
            if (ageNum<=70&&ageNum >=74){
                avgIq=119;
            }

            try {
                nameLP = namet.getText();
            }catch (Exception ae){
                System.out.println("Please Enter your name" );
            }


            frameOfLP = new JFrame("RESULT");
            frameOfLP.setVisible(true);
            frameOfLP.setBounds(350, 135, 870, 670);
            frameOfLP.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            panel = new JPanel();
            panel.setLayout(null);
            panel.setPreferredSize(new Dimension(10, 2000));

            result = new JLabel("RESULT");
            result.setForeground(new Color(11, 0, 255));
            result.setFont(new Font("Agency FB", Font.BOLD, 60));
            result.setBounds(350, 10, 700, 100);
            panel.add(result);

            scorelb = new JLabel(nameLP + " your IQ is approximately " + iq);
            scorelb.setForeground(Color.DARK_GRAY);
            scorelb.setFont(new Font("Agency FB", Font.PLAIN, 35));
            scorelb.setBounds(150,85,700,100);
            panel.add(scorelb);

            restart = new JButton("RESTART");
            restart.setBounds(80,1800,170,60);
            restart.setBackground(new Color(138, 255, 138));
            restart.setForeground(new Color(60, 60, 60));
            restart.setFont(new Font("verdana",Font.BOLD,15));
            panel.add(restart);

            exit = new JButton("EXIT");
            exit.setBounds(600,1800,170,60);
            exit.setBackground(new Color(255, 65, 65));
            exit.setForeground(new Color(60, 60, 60));
            exit.setFont(new Font("verdana",Font.BOLD,15));
            panel.add(exit);

            PieDataset dataset = createDataset();

            JFreeChart chart = ChartFactory.createPieChart(
                    "Graphical Analysis of your IQ",
                    dataset,
                    true,
                    true,
                    false);

            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                    "Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setSectionPaint(1, Color.red);
            plot.setSectionPaint(0, Color.green);

            ChartPanel cp = new ChartPanel(chart);
            cp.setBounds(70,250,700,550);
            panel.add(cp);
            panel.validate();

            CategoryDataset dataset2 = createDataset2();

            //Create chart
            JFreeChart chart2=ChartFactory.createBarChart(
                    "comparison of average IQ (According to age) and your IQ", //Chart Title
                    "COMPARISON OF", // Category axis
                    "IQs", // Value axis
                    dataset2,
                    PlotOrientation.VERTICAL,
                    true,true,false
            );
            CategoryPlot topPlot = chart2.getCategoryPlot();
            NumberAxis topAxis = (NumberAxis) topPlot.getRangeAxis();
            topAxis.setLowerBound(60);
            topAxis.setUpperBound(150);
            BarRenderer br = (BarRenderer) topPlot.getRenderer();
            br.setMaximumBarWidth(.10);


            ChartPanel p3=new ChartPanel(chart2);
            p3.setBounds(70,950,700,700);
            panel.add(p3);
            panel.validate();

            jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(panel);
            frameOfLP.add(jScrollPane, BorderLayout.CENTER);

            exit.addActionListener(this);
            restart.addActionListener(this);
        }

if (e.getSource()==restart){
    frameOfLP.setVisible(false);
    frame.setVisible(true);
}
if (e.getSource()==exit){

        int a=JOptionPane.showConfirmDialog(null,
                "Are you sure you wish to exit application?",null, JOptionPane.YES_NO_OPTION);

    if(a==JOptionPane.YES_OPTION){
            System.exit(0);
    }

}

    }
}