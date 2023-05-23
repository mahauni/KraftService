package javaBeans;

import java.sql.Date;

public class Action {
        private int id;
        private String name;
        private String description;
        private Date start = null;
        private Date finish = null;

    public Action() {
    }

    public Action(String name, String description, Date start, Date finish) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
    }

    public Action(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Action(int id, String name, String description, Date start, Date finish) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Action { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                " }";
    }
}
