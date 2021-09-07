package ua.GoIT.modul13;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class Main2 {
    private static final String URL_NAME = "https://jsonplaceholder.typicode.com/users/1/posts";
    private static final String URL_NAME1 = "https://jsonplaceholder.typicode.com/posts/10/comments";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException, InterruptedException {

        //Task 2
        System.out.println(GSON.toJson(HttpUtill.getCommentsByUserId(URL_NAME, URL_NAME1, 0)));

    }

}
