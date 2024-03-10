import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue[] queues = new Queue[4];
        Thread[] threads = new Thread[4];
        @SuppressWarnings("unchecked")
        LinkedList<Person>[] queueList = (LinkedList<Person>[]) new LinkedList[4];


        // Create 4 queues, starts them, and adds them to the queueList to be compared to
        for (int i = 0; i < threads.length; i++) {
            queues[i] = new Queue(i + 1);
            queueList[i] =(LinkedList<Person>) queues[i].getQueue().clone();
            threads[i] = new Thread(queues[i]);
            threads[i].start();
        }

        // Runs for a minute
        int count = 0;

        // Main loop
        while (count < 60) {
            count++;
            try {
                // Creates space between the queues
                System.out.println(
                        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                // Checks if the queue has changed and the changes
                for (int i = 0; i < threads.length; i++) {
                    if (!queueList[i].equals(queues[i].getQueue())) {
                        System.out.println(queueList[0].get(0).name + " was removed from queue " + (i + 1));
                        queueList[i] = (LinkedList<Person>) queues[i].getQueue().clone();
                    }
                }
                // Prints out the queues
                System.out.println("Queue 1\t\t\tQueue 2\t\t\tQueue 3\t\t\tQueue 4");
                for (int i = 0; i < 5; i++) {
                    String element1 = queues[0].getQueue().get(i).name + " "
                            + queues[0].getQueue().get(i).timeToComplete;
                    String element2 = queues[1].getQueue().get(i).name + " "
                            + queues[0].getQueue().get(i).timeToComplete;
                    String element3 = queues[2].getQueue().get(i).name + " "
                            + queues[0].getQueue().get(i).timeToComplete;
                    String element4 = queues[3].getQueue().get(i).name + " "
                            + queues[0].getQueue().get(i).timeToComplete;

                    System.out.printf("%-16s\t%-16s\t%-16s\t%-16s%n", element1, element2, element3, element4);
                }

                // Prints out the wait times
                System.out.printf("%-16s\t%-16s\t%-16s\t%-16s%n", queues[0].getWaitTime(), queues[1].getWaitTime(),
                        queues[2].getWaitTime(), queues[3].getWaitTime());
                // Finds the shortest queue
                int shortestQueue = 0;
                int shortestQueueWait = queues[0].getWaitTime();
                for (int i = 1; i < threads.length; i++) {
                    if (queues[i].getWaitTime() < shortestQueueWait) {
                        shortestQueue = i;
                        shortestQueueWait = queues[i].getWaitTime();
                    }
                }

                System.out.println("Shortest Queue: " + (shortestQueue + 1));

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}