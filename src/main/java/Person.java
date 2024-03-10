public class Person {
    // Represents a person in the queue
    public final String name;
    public int timeToComplete;
    Person(String name, int timeToComplete) {
        this.name = name;
        this.timeToComplete = timeToComplete;
    }
}