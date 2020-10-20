package com.example.appirest;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private static PostService service;

    private ArrayList<String> tittles=new ArrayList<>();

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayAdapter
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tittles);
        list = findViewById(R.id.list);

        list.setAdapter(arrayAdapter);
         getOnePosts();
         //  getPosts();


      //  addPost();
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service= retrofit2.create(PostService.class);
        createPost();

    }


    private void createPost()
    {
        Post post =new Post(23232,"asdas","asds");
        Map<String, String> fields= new HashMap<>();
        fields.put("userId","25");
        fields.put("title","new");

        Call<Post>call=service.createPost(fields);
        call.enqueue(new Callback<Post>(){
            public void onResponse(Call <Post> call, Response <Post> response){


             if(!response.isSuccessful())
             {
              //   tittles.add("Code:"+response.code());
                 return;
             }
             Post postResponse = response.body();
             String content ="";
                content+="Code "+response.code()+"\n";
                content+="ID "+postResponse.getId()+"\n";
                content+="User ID "+postResponse.getUserId()+"\n";
                content+="Title "+postResponse.getTittle()+"\n";
                content+="Text "+postResponse.getBody()+"\n";
            //    tittles.add(content);
            }
            public void onFailure(Call <Post> call, Throwable t){

            }
        });
    }
    private void getOnePosts()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<Post> call = postService.getOnePosts(2);
        call.enqueue(new Callback<Post>(){
            public void onResponse(Call <Post> call, Response <Post> response){


                    tittles.add(String.valueOf(response.body().getBody()));

                arrayAdapter.notifyDataSetChanged();
            }
            public void onFailure(Call <Post> call, Throwable t){

            }
        });

    }
    private void getPosts()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<List<Post>> call = postService.getPost();
        call.enqueue(new Callback<List<Post>>(){
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response){
                for(Post post: response.body()){
                    tittles.add(post.getBody());
                }
                arrayAdapter.notifyDataSetChanged();
            }
            public void onFailure(Call<List<Post>> call, Throwable t){

            }
        });

    }
}