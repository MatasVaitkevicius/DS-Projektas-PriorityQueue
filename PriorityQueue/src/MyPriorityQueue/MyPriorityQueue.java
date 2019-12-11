package MyPriorityQueue;

import java.util.LinkedList;

public class MyPriorityQueue implements MyQueueInterface {

    LinkedList<Call> queue = new LinkedList<>();

    /**
     * Returns length of queue
     * 
     * @return returns true if operation was successful
     */
    public int getLength() {
        return queue.size();
    }
    
    /**
     * Returns object form queue by index
     * 
     * @param i - the index to search object by
     * @return returns object from queue by index
     */
    public Call getCallObject(int i)
    {
        return queue.get(i);
    }
   
    /**
     * Checks if queue is empty
     * 
     * @return returns true if queue is empty
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Enqueues an object by evaluating on two parameters: dangerProperty
     * and dangerLevel and decides where to put it in queue
     * 
     * @param e - object that is being enqueued
     * @return true if operation was successful
     */
    @Override
    public boolean add(Call e) {
        int queueLength = queue.size();
        
        if(queueLength == 0)
        {
            return queue.add(e); 
        }
        
        if(e.getDangerPropery() == true)
        {
            int index1 = 1;
            Call current = queue.getFirst();
            while(current.getDangerPropery() == true 
                    && (current.compareTo(e) == 0 
                    || current.compareTo(e) > 0) 
                    && index1 < queueLength)
            {
                current = queue.get(index1);
                index1++;
                
            }
            queue.add(index1 - 1, e);
            return true;
        }
        else
        {
            Call current = queue.getLast();
            int index1 = queueLength;
            while(current.getDangerPropery() == false 
                    && current.compareTo(e) < 0 
                    && index1 != 0)
            {
                index1--;
                current = queue.get(index1);                
            }
            if(index1 == queue.size())
            {
                queue.addLast(e);
                return true;
            }
            else
            {
                queue.add(index1 + 1, e);
                return true;
            }
        }
            
    }
    
    /**
     * Enqueues object just by using default comparator
     * 
     * @param e - object that is being enqueued
     */
    public void add2(Call e)
    {
        if(queue.size() == 0)
        {
             queue.add(e); 
        }
        Call current = queue.getFirst();
        if((current.compareTo(e) == 0 || current.compareTo(e) > 0))
            queue.addFirst(e);
        else
            queue.addLast(e);
    }
        
    /**
     * Dequeues all objects from queue
     */
    public void clear() {
        queue.clear();
    }

    /**
     * Dequeues first object from queue and returns it
     * 
     * @return returns removed object
     */
    @Override
    public Call remove() {
        return queue.remove();
    }

    /**
     * Enqueues object to the beginning of the queue
     * 
     * @param callObject 
     */
    @Override
    public void addFirst(Call callObject) {
        queue.addFirst(callObject);
    }
  
    /**
     * Enqueues object to the end of the queue
     * 
     * @param callObject 
     */
    @Override
    public void addLast(Call callObject) {
        queue.addLast(callObject);
    }

    /**
     * Dequeues and returns first object from queue
     * 
     * @return returns first object from queue
     */
    @Override
    public Call poll() {
        return queue.poll();
    }
    
    /**
     * Enqueues element to the end of the list
     * 
     * @param callObject object that is being enqueued
     * @return returns true if operation was successful
     */
    @Override
    public boolean offer(Call callObject)
    {
        return queue.offer(callObject);
    }
    
    /**
     * Returns first object from queue
     * 
     * @return returns first object from queue
     */
    @Override
    public Call element()
    {
        return queue.element();
    }
    
    /**
     * Retrieves but does not remove first element from queue
     * 
     * @return returns first object from queue
     */
    @Override
    public Call peek()
    {
        return queue.peek();
    }
    
}
