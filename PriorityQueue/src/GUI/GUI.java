package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import MyPriorityQueue.Call;
import MyPriorityQueue.Benchmark;
import MyPriorityQueue.MyPriorityQueue;


public class GUI extends JFrame implements Serializable, ActionListener {

    private static final int RECORDS_NUMBER = 15;
    
    ArrayList<Call> primaryData    = new ArrayList<>();
    MyPriorityQueue mainQueue      = new MyPriorityQueue();

    JButton addBtn              =   new JButton("Add to queue");
    JButton removeBtn           =   new JButton("Remove from queue");
    JButton getMostImportantBtn =   new JButton("Get most important element");
    JButton generateQueueBtn    =   new JButton("Generate random queue");
    JButton speedTestBtn        =   new JButton("Speedtest - Main");
    JButton speedTestMiddleBtn  =   new JButton("Speedtest - Add middle");
    
    JPanel dataBlock        =  new JPanel();
    JPanel buttonsBlock     =  new JPanel();
    
    JTextArea leftTextarea          = new JTextArea(20,40);    
    JTextArea rightTextarea         = new JTextArea(20,40);
    JScrollPane addScrollForLeft    = new JScrollPane(leftTextarea);
    JScrollPane addScrollForRight   = new JScrollPane(rightTextarea);
    
    
    public GUI()
    {
        Container inside = getContentPane();  
        inside.setLayout(new BoxLayout(inside, BoxLayout.Y_AXIS));
        
        inside.add(dataBlock);
        inside.add(buttonsBlock);
        
        addBtn.addActionListener(this);
        removeBtn.addActionListener(this);
        getMostImportantBtn.addActionListener(this);
        generateQueueBtn.addActionListener(this);
        speedTestBtn.addActionListener(this);
        speedTestMiddleBtn.addActionListener(this);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        arrangement();
        appereance();
        setVisible(true);    
        pack();
    }
    
    private void arrangement() {
        setLocation(0, 0);
   
        dataBlock.add(addScrollForLeft);
        dataBlock.add(addScrollForRight);     
        buttonsBlock.setLayout(new BoxLayout(buttonsBlock, BoxLayout.X_AXIS));      
        buttonsBlock.add(addBtn);
        buttonsBlock.add(removeBtn);
        buttonsBlock.setLayout(new BoxLayout(buttonsBlock, BoxLayout.X_AXIS)); 
        buttonsBlock.add(getMostImportantBtn);
        buttonsBlock.add(generateQueueBtn);
        buttonsBlock.add(speedTestBtn);
        buttonsBlock.add(speedTestMiddleBtn);
    }

    private void appereance() {
        dataBlock.setBorder(new TitledBorder("Queue Control Window"));
     
        dataBlock.setBackground(Color.lightGray);
        buttonsBlock.setBackground(Color.lightGray);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object clickedBtn = e.getSource();
       if(clickedBtn == addBtn) {
           this.addElementToQueue();
       }
       else if(clickedBtn == removeBtn) {
           this.removeQeueElement();
       }
       else if(clickedBtn == getMostImportantBtn) {
           int elementId = 8;
           this.getMostImportantElement();
       }
       else if(clickedBtn == generateQueueBtn) {
           this.generateData();
       }
       else if(clickedBtn == speedTestBtn) {
           this.speedTest();
       }
       else if(clickedBtn == speedTestMiddleBtn) {
           this.speedMiddleTest();
       }
    }
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        GUI gui = new GUI();
    }
    
    private void generateData() {
       primaryData.clear();
       mainQueue.clear();
       leftTextarea.setText("");
       rightTextarea.setText("");
        
       Benchmark speedTest = new Benchmark(); 
       primaryData = speedTest.generateData(RECORDS_NUMBER);
       
       for(int i = 0; i < RECORDS_NUMBER; i++) {
           leftTextarea.append(primaryData.get(i).toString());
       }
    }

    private void removeQeueElement() {
        if(mainQueue.getLength() != 0) {
            mainQueue.poll();
            this.reprintLeftTextArea();
            this.reprintRightTextArea(); 
        }
        else {
            JOptionPane.showMessageDialog(null, "There are no elements in queue!");
        }
    }

    private void getMostImportantElement() {
        if(mainQueue.getLength() != 0) {
            JOptionPane.showMessageDialog(null, mainQueue.peek().toString());
        }
        else {
            JOptionPane.showMessageDialog(null, "There are no elements in queue!");
        }
    }

    private void addElementToQueue() {
        if (!primaryData.isEmpty()) {
            mainQueue.add(primaryData.get(0));
            primaryData.remove(0);

            this.reprintLeftTextArea();
            this.reprintRightTextArea(); 
        }
        else {
            JOptionPane.showMessageDialog(null, "Data list is empty");
        }
    }

    private void speedTest() { 
       primaryData.clear();
       mainQueue.clear();
       this.reprintLeftTextArea();
       //this.reprintRightTextArea();
       new Benchmark().SystemicTest(leftTextarea, false);
    }
    
    private void speedMiddleTest() {
       primaryData.clear();
       mainQueue.clear();
       //this.reprintLeftTextArea();
       this.reprintRightTextArea();
       new Benchmark().SystemicTest(rightTextarea, true);
    }
    
    private void reprintLeftTextArea() {
        leftTextarea.setText("");
            for(int i = 0; i < primaryData.size(); i++) {
               leftTextarea.append(primaryData.get(i).toString());
            }
    }
    
    private void reprintRightTextArea() {
        rightTextarea.setText("");
            for(int i = 0; i < mainQueue.getLength(); i++) {
                rightTextarea.append(mainQueue.getCallObject(i).toString());
            }
    }
}
    
