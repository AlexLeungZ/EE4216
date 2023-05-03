
package ee4216.springdata.jdbc;

/**
 * A model class representing the 'courses' table.
 * @author vanting
 */
public class Course {
    
    private int id;
    private String name;
    private int teacherId;
    
    // Constructors, getters, and setters

    public Course(int id, String name, int teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}