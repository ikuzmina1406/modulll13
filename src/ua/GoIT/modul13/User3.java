package ua.GoIT.modul13;

public class User3 {
    private int userid;
    private boolean completed;
    private int id;
    private String title;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "User1{" +
                "userid=" + userid +
                ", completed='" + completed + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}