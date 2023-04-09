package ee4216.asg2.jdbc;

public class Todo {
    private int id;
    private String name;
    private Boolean done;
    private int timer;

    // Data structure of todo list
    public Todo(int id, String name, Boolean done, int timer) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.timer = timer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getDone() {
        return done;
    }

    public int getTimer() {
        return timer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
