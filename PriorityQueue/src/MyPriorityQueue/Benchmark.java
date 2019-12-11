package MyPriorityQueue;
import SourceClasses.Timekeeper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;
import javax.swing.JTextArea;

public class Benchmark extends Thread {
    static int[] testingQuantitiesMiddle = {1000, 2000, 3000, 4000};
    static int[] testingQuantities = {10000, 20000, 40000, 50000};
    JTextArea outputSource;
    static ArrayList<Call> listOfCalls = new ArrayList<>();
    static MyPriorityQueue queue = new MyPriorityQueue();
    static PriorityQueue<Call> pQueue = new PriorityQueue();

    
    Call[] baseObject;
    Random ag = new Random();
    public ArrayList generateData(int quantity){
       String[] titlesArray = {"Gaisras", "Nuzudymas", "Apiplesimas", "Avarija", "Triuksmas", "Mustynes"};
       Boolean[] lifeImportanceArray = {true, false};
       
        baseObject= new Call[quantity];
        ag.setSeed(2017);
        for(int i = 0; i < quantity; i++){
            int titleValueIndex = ag.nextInt(titlesArray.length);
            int lifeValueIndex = ag.nextInt(lifeImportanceArray.length);
            baseObject[i]= new Call(
                    titlesArray[titleValueIndex], 
                    lifeImportanceArray[lifeValueIndex],
                    1 + ag.nextInt(100)
            );
        }
        Collections.shuffle(Arrays.asList(baseObject));
        listOfCalls.clear();
        for(Call a: baseObject) listOfCalls.add(a);
        return listOfCalls;
    }
    
    
    public void SystemicTest(JTextArea resultsArea, boolean addToMiddle) {
        this.outputSource = resultsArea;
        
        if(addToMiddle == true) {
            Timekeeper tk = new Timekeeper(testingQuantitiesMiddle, outputSource);
            for (int count : testingQuantitiesMiddle) {
                generateData(count);

                pQueue.clear();
                queue.clear();
                
                tk.start();

                for(int i = 0; i < count; i++) {
                    queue.add(listOfCalls.get(i));
                }
                tk.finish("OPQA+");
                tk.seriesFinish();
            }
        }
        else {    
            Timekeeper tk = new Timekeeper(testingQuantities, outputSource);
            for (int count : testingQuantities) {
                generateData(count);

                pQueue.clear();
                queue.clear();

                //---------------------------------------------

                tk.start();
                for(int i = 0; i < count; i++) {
                    queue.add2(listOfCalls.get(i));
                }
                tk.finish("OPQA");

                for(int i = 0; i < count; i++) {
                    pQueue.add(listOfCalls.get(i));
                }
                tk.finish("JPQA");

                //---------------------------------------------

                for(int i = 0; i < count; i++) {
                    queue.remove();
                }
                tk.finish("OPQR");

                for(int i = 0; i < count; i++) {
                    pQueue.remove();
                }
                tk.finish("JPQR");
                tk.seriesFinish();
            }
        }
    }
}
