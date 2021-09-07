package ua.GoIT.modul13;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


class Json {

    public static <json> void createJson(List<Comments> result, int x, int y) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        String s = gson.toJson(result);


        writeToJsonFile(s,x,y);


    }

    private static void writeToJsonFile(String s, int x, int y) throws IOException {
        try (FileWriter writer = new FileWriter("user-"+x+"-post-"+y+"-comments.json")) {
            writer.write(s);
            writer.flush();
        }
    }


}