package com.infinixsoft.hotandcoldobservables;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;

public class ColdActivity extends Activity {
    private int value = 5;
    private Button mButtonAddSubscriber;
    private Observable<Integer> observableFrio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold);
        getActionBar().setTitle("Cold Observable");

        mButtonAddSubscriber = findViewById(R.id.mButtonAddSubscriber);

        createObservable();

    }

    private void createObservable(){
        observableFrio = Observable.create(subscriber -> {
            for (int i = 0; i <= value; i++) {
                subscriber.onNext(i);
            }
        });
    }
}
    /*private static Action1<Integer> subscriber1 = new Action1<Integer>()
    {
        @Override
        public void call(Integer integer)
        {
            System.out.println("Subscriber 1 :" + integer);
        }
    };

    private static Action1<Integer> subscriber2 = new Action1<Integer>()
    {
        @Override
        public void call(Integer integer)
        {
            System.out.println("Subscriber 2 :" + integer);
        }
    };*/
