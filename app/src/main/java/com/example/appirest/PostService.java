package com.example.appirest;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostService {
    String API_ROUTE = "/posts";
    String API_ROUTE2 = "/posts/{id}";
    String API_ROUTE3 = "/posts/new";
   @GET(API_ROUTE)
    Call<List<Post>> getPost();
    @GET(API_ROUTE2)
    Call<Post> getOnePosts(@Path("id") int id);

    @POST(API_ROUTE3)
    Call<Post> createPost(@Body Post post);
    // @POST(API_ROUTE3)
   // Call<Post> addPost(@Body Post post);
    @FormUrlEncoded
    @POST(API_ROUTE3)
            Call<Post> createPost(
                    @Field("userId") int userId,
                    @Field("title") String title,
                    @Field("body") String text

    );

    @FormUrlEncoded
    @POST(API_ROUTE3)
    Call<Post> createPost(@FieldMap Map<String,String> fields);
}
