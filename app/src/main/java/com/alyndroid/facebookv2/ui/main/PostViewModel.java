package com.alyndroid.facebookv2.ui.main;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.facebookv2.data.PostsClient;
import com.alyndroid.facebookv2.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    //MutableLiveData<String> posts = new MutableLiveData<>();

    public void getPosts() {
        Observable observable = PostsClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        Observer<List<PostModel>> observer = new Observer<List<PostModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<PostModel> postModels) {

                postsMutableLiveData.setValue(postModels);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);


    }
}
