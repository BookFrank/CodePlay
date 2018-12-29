package com.tazine.third.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * RxJava Demo
 *
 * @author frank
 * @date 2018/02/26
 */
public class App {

    public static void main(String[] args) {

        // 第一步，创建被观察者
        Observable subject = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                // 在此期间，被观察者可以执行一些任务
                // ...
                // 这些任务导致被观察者发生改变，触发回调，通知观察者
                observableEmitter.onNext("Hello World");
                observableEmitter.onComplete();
            }
        });

        // 第二步，创建观察者
        Observer observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            /**
             * 观察者接收到通知，执行某些变更
             * @param s
             */
            @Override
            public void onNext(String s) {
                System.out.println("收到信息：" + s);
            }


            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        // 第三步，将 Observer 订阅至 Subject
        subject.subscribe(observer);




    }
}
