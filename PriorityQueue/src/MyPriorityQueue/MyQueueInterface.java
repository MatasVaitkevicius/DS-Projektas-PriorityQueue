package MyPriorityQueue;

public interface MyQueueInterface {
    
    /**
     * Enqueues an object by evaluating on two parameters: dangerProperty
     * and dangerLevel and decides where to put it in queue
     * 
     * @param callObject - object that is being enqueued
     * @return true if operation was successful
     */
    public boolean add(Call callObject);

    /**
     * Dequeues first object from queue and returns it
     * 
     * @return returns removed object
     */
    public Call remove();

    /**
     * Enqueues object to the beginning of the queue
     * 
     * @param callObject 
     */
    public void addFirst(Call callObject);

    /**
     * Enqueues object to the end of the queue
     * 
     * @param callObject 
     */
    public void addLast(Call callObject);
    
    /**
     * Dequeues and returns first object from queue
     * 
     * @return returns first object from queue
     */
    public Call poll();

    /**
     * Enqueues element to the end of the list
     * 
     * @param callObject object that is being enqueued
     * @return returns true if operation was successful
     */
    public boolean offer(Call callObject);

    /**
     * Returns first object from queue
     * 
     * @return returns first object from queue
     */
    public Call element();

    /**
     * Retrieves but does not remove first element from queue
     * 
     * @return returns first object from queue
     */
    public Call peek();

}
