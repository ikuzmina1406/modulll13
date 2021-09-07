package ua.GoIT.modul13;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class Main {
    private static final String URL_NAME = "https://jsonplaceholder.typicode.com/users";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException, InterruptedException {
        //Task 1.1
        //System.out.println(GSON.toJson(HttpUtill.createUser(URL_NAME, setUser())));
        //Task 1.2
        //System.out.println(GSON.toJson(HttpUtill.updateUser(URL_NAME,setUser())));
        //Task 1.3
        //System.out.println(GSON.toJson(HttpUtill.getDeleteStatus(URL_NAME,setUser())));
        //Task 1.4
        //System.out.println(GSON.toJson(HttpUtill.getUsers(URL_NAME)));
        //Task 1.5
        //System.out.println(GSON.toJson(HttpUtill.getUserById(URL_NAME, setUser())));
        //Task 1.6
        //System.out.println(GSON.toJson(HttpUtill.getUserByUserName(URL_NAME, setUser())));

    }

    private static User setUser() {
        User user = new User();
        user.setId(11);
        user.setName("VARVARA");
        user.setUsername("Inna");
        user.setEmail("inna_varvara.gmail.com");

        return user;
    }


}
