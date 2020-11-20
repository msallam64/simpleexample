package com.alyndroid.facebookv2.data;

import com.alyndroid.facebookv2.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Observable<List<PostModel>> getPosts();
}
