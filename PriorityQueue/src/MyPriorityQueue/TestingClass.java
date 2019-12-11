package MyPriorityQueue;

public class TestingClass {
    public static void main(String args[])
    {
      MyPriorityQueue priorityQueue = new MyPriorityQueue();
      Call call1 = new Call("Gaisras", true, 1);
      Call call2 = new Call("Vagyste", false, 15);
      Call call3 = new Call("Vagyste", true, 100);
      Call call4 = new Call("Gaisras", false, 1);
      Call call5 = new Call("Gaisras", true, 55);
      Call call6 = new Call("Gaisras", false, 13);
      Call call7 = new Call("Gaisras", true, 100);
      Call call8 = new Call("Gaisras", false, 15);
      Call call9 = new Call("Gaisras", true, 101);
      priorityQueue.add(call1);
      priorityQueue.add(call2);
      priorityQueue.add(call3);
      priorityQueue.add(call4);
      priorityQueue.add(call5);
      priorityQueue.add(call6);
      priorityQueue.add(call7);
      priorityQueue.add(call8);
      priorityQueue.add(call9);
      System.out.println("==============================Add===================================");     
      for(int i = 0; i < priorityQueue.getLength(); i++)
      {
          Call call = priorityQueue.getCallObject(i);
          System.out.println(call.getEvent()+ " " + call.getDangerPropery()+ " " + call.getDangerLevel());
      }
      System.out.println("=================================Poll========================================");
      Call removedCall = priorityQueue.poll();
      System.out.println(removedCall.getEvent()+ " " + removedCall.getDangerPropery()+ " " + removedCall.getDangerLevel());
      
      System.out.println("=================================Offer========================================");     
      priorityQueue.offer(new Call("OfferTest", true, 1));
      for(int i = 0; i < priorityQueue.getLength(); i++)
      {
          Call call = priorityQueue.getCallObject(i);
          System.out.println(call.getEvent()+ " " + call.getDangerPropery()+ " " + call.getDangerLevel());
      }
      
      System.out.println("=================================Clear=======================================");
      priorityQueue.clear();
      for(int i = 0; i < priorityQueue.getLength(); i++)
      {
          Call call = priorityQueue.getCallObject(i);
          System.out.println(call.getEvent()+ " " + call.getDangerPropery()+ " " + call.getDangerLevel());
      }
      
    }
}
