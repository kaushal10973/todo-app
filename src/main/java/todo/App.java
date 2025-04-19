package todo;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public static void main(String[] args) {
        App app = new App();
        app.addTask("Learn DevOps");
        app.addTask("Build a CI/CD Pipeline");

        for (String task : app.getTasks()) {
            System.out.println(task);
        }
    }
}
