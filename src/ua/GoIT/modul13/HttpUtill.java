package ua.GoIT.modul13;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HttpUtill {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    //Task1
    public static User createUser(String url, User user) throws IOException, InterruptedException {
        String requestBody = GSON.toJson(user);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .headers("Content-Type", "application/json")
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(send.body(), User.class);

    }

    public static User updateUser(String url, User user) throws IOException, InterruptedException {
        String newUrl = url + "/" + user.getId();
        String requestBody = GSON.toJson(user);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(newUrl))
                .headers("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(send.body(), User.class);

    }

    public static int getDeleteStatus(String url, User user) throws IOException, InterruptedException {
        String newUrl = url + "/" + user.getId();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(newUrl))
                .DELETE()
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return send.statusCode();

    }

    public static List<User> getUsers(String url) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(send.body(), new TypeToken<List<User>>() {
        }.getType());

    }

    public static User getUserById(String url, User user) throws IOException, InterruptedException {
        String newUrl = url + "/" + user.getId();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(newUrl))
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(send.body(), User.class);


    }

    public static List<User> getUserByUserName(String url, User user) throws IOException, InterruptedException {
        String newUrl = url + "?username=" + user.getUsername();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(newUrl))
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(send.body(), new TypeToken<List<User>>() {
        }.getType());
    }

    //Task2
    public static List<Comments> getCommentsByUserId(String urlPosts, String urlComments, int userId) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(urlPosts))
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        List<Posts> list = GSON.fromJson(send.body(), new TypeToken<List<Posts>>() {
        }.getType());

        int maxPostId = 0;
        for (Posts l : list) {
            if (l.getUserid() == userId) {
                int id = l.getId();
                if (maxPostId <= id) maxPostId = id;
            }
        }

        HttpRequest httpRequest2 = HttpRequest.newBuilder()
                .uri(URI.create(urlComments))
                .build();
        HttpResponse<String> send2 = HTTP_CLIENT.send(httpRequest2, HttpResponse.BodyHandlers.ofString());
        List<Comments> list2 = GSON.fromJson(send2.body(), new TypeToken<List<Comments>>() {
        }.getType());
        List<Comments> result = new ArrayList<>();
        for (Comments l2 : list2) {
            if (l2.getPostId() == maxPostId) {
                result.add(l2);
            }
        }

        Json.createJson(result, userId, maxPostId);

        return result;
    }

    //Task3
    public static List<User3> getTitleUserById(String url, int userId) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> send = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        List<User3> list = GSON.fromJson(send.body(), new TypeToken<List<User3>>() {
        }.getType());
        List<User3> result = new ArrayList<>();
        for (User3 l : list) {
            int id = l.getUserid();
            boolean comp = l.getCompleted();
            if (id == userId && comp == false) {
                result.add(l);
            }
        }
        return result;
    }

}

