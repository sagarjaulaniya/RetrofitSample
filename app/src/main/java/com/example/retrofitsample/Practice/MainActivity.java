package com.example.retrofitsample.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitsample.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiServices apiServices;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    EditText etEmail, etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiServices = NetworkHelper.getInstance().create(ApiServices.class);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEmail.setText(" ");
                etPassword.setText(" ");
//                createPost();
//                updatePost();
                deletePost();

            }
        });
//        postType();
//        getComment();
    }

    private void deletePost() {
        apiServices.deletePost(5).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("deleteCode", "onResponse: " + response.code());
                    Log.d("deleteResponse", "onResponse() returned: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("deleteFail", "onResponse: " + t.getMessage());
            }
        });
    }

    private void updatePost() {
        Post post = new Post("New Title", "New Text", 15);
        apiServices.patchPost(5, post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Log.d("putCode", "onResponse: " + response.code());
                    Log.d("PutResponse", "onResponse() returned: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("putFail", "onResponse: " + t.getMessage());
            }
        });
    }

    private void createPost() {
        Post post = new Post(etEmail.getText().toString().trim(), etPassword.getText().toString().trim(), 2);
        Map<String, String> postMap = new HashMap<>();
        postMap.put("userId", "33");
        postMap.put("title", "My post title");
        postMap.put("body", "This is my post body in the map");

        Call<Post> postCall = apiServices.createPost(postMap);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", "onResponse: " + response.code());
                    Log.d("PostTAG", "onResponse() returned: " + response.body());
                    Post post1 = response.body();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "hello: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getComment() {
        Map<String, String> map = new HashMap<>();
        map.put("postId", "3");
        map.put("_sort", "name");
        map.put("_order", "desc");

        Call<List<Comment>> getComment = apiServices.getComment(new Integer[]{1, 3, 4}, "email", "desc");
        getComment.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    Log.d("comment", "onResponse: " + response.body());
                    List<Comment> titleList = response.body();

                    adapter = new RecyclerViewAdapter(getApplicationContext(), titleList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.d("errorcomment: ", "onError: " + t.getMessage());
                Toast.makeText(MainActivity.this, "errorcomment: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void postType() {
        Call<List<Post>> call = apiServices.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {

                    Log.d("Result", "onResponse: " + response.body());

                    List<Post> titleList = response.body();

                    String[] title = new String[titleList.size()];
                    for (int i = 0; i < titleList.size(); i++) {
                        title[i] = titleList.get(i).getBody();
                    }
//                    listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, title));
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("tag", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "errorMsg" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
