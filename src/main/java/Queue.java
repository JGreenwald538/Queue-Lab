import java.util.*;
import java.util.Random;

class Queue implements Runnable {
    private LinkedList<Person> queueList = new LinkedList<Person>();
    private final int queueNumber;
    String[] names = new String[]{"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace",    "Henry", "Ivy", "Jack", "Kate", "Liam", "Mia", "Nathan", "Olivia", "Peter" ,"Quinn", "Rachel", "Sophia", "Thomas", "Ursula", "Victor", "William", "Xavier", "Yara", "Zoe"};
    Random rand = new Random();
    
    // Constructor that creates 5 people and adds them
    Queue(int queueNumber) {
        this.queueNumber = queueNumber;
        Random rand = new Random();
        for(int i = 0; i < 5; i++) {
            queueList.add(new Person(names[rand.nextInt(names.length)], rand.nextInt(1, 6)));
        }
    }

    // Getters
    public LinkedList<Person> getQueue() {
        return this.queueList;
    }

    public int getWaitTime() {
        int waitTime = 0;
        for(Person person : queueList) {
            waitTime += person.timeToComplete;
        }
        
        return waitTime;
    }

    // Run method that runs the queue
    public void run() {
        while(true) {
            // If the first person in the queue is done, remove them and add a new person
            try {
                if (this.queueList.get(0).timeToComplete <= 0) {
                    this.queueList.remove(0);
                    Person person = new Person(names[rand.nextInt(names.length)], rand.nextInt(1, 6));
                    queueList.add(person);
                }
                Thread.sleep(1000);
                this.queueList.get(0).timeToComplete--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}