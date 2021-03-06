package api;

import models.Comment;
import models.Post;
import models.Todos;
import models.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface IApiClient {

    @GET("public/v2/users")
    Call<List<Map<String, String>>> getUsers(@Header("Authorization") String token);

    @GET("public/v2/users/{userId}")
    Call<Map<String, String>> getUserDetail(@Header("Authorization") String token, @Path("userId") String userId);

    @POST("public/v2/users")
    Call<User> createUser(@Header("Authorization") String token, @Body User user);

    @DELETE("public/v2/users/{userId}")
    Call<Void> deleteUser(@Header("Authorization") String token, @Path("userId") String userId);

    @PUT("public/v2/users/{userId}")
    Call<User> updateUser(@Header("Authorization") String token, @Path("userId") String userId, @Body User user);

    @POST("public/v2/users/{userId}/posts")
    Call<Post> createPost(@Header("Authorization") String token, @Path("userId") String userId, @Body Post post);

    @GET("public/v2/users/{userId}/posts")
    Call<List<Post>> getPost(@Header("Authorization") String token, @Path("userId") String userId);

    @POST("public/v2/comments")
    Call<Comment> createComment(@Header("Authorization") String token, @Body Comment comment);

    @GET("public/v2/posts/{postId}/comments")
    Call<List<Comment>> getComment(@Header("Authorization") String token, @Path("postId") int postId);

    @POST("public/v2/users/{userId}/todos")
    Call<Todos> createUserTodo(@Header("Authorization") String token, @Path("userId") String userId, @Body Todos todos);

    @GET("public/v2/users/{userId}/todos")
    Call<List<Todos>> getTodo(@Header("Authorization") String token, @Path("userId") String userId);

}
