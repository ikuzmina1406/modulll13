package ua.GoIT.modul13;

import java.util.Objects;

public class Comments {
    private int id;
    private int postId;
    private String name;
    private String body;
    private String email;


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", postId=" + postId +
                ", name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
