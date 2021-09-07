package ua.GoIT.modul13;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class Main3 {
    private static final String URL_NAME = "https://jsonplaceholder.typicode.com/users/1/todos";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException, InterruptedException {

        //Task 3
        //System.out.println(GSON.toJson(HttpUtill.getTitleUserById(URL_NAME, 0)));

    }


}
