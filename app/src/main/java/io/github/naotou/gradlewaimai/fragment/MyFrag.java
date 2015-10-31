package io.github.naotou.gradlewaimai.fragment;

import io.github.naotou.gradlewaimai.R;
import io.github.naotou.gradlewaimai.framework.BaseFrag;

/**
 * Create by Android Studio
 * User: FuQiang(fuqiang@uniqueway.com)
 * Date: 2015-10-27
 * Time: 15-14
 */
public class MyFrag extends BaseFrag {

    @Override public int createViewById() {
        return R.layout.frag_my;
    }

    @Override protected void initViews() {
        super.initViews();
//        //设置返回箭头不显示
//        Observer<String> observer = new Observer<String>() {
//            @Override public void onCompleted() {
//                ToastUtils.showShort("completed");
//            }
//
//            @Override public void onError(Throwable e) {
//
//            }
//
//            @Override public void onNext(String s) {
//                ToastUtils.showShort(s);
//            }
//
//        };
//        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
//            @Override public void onCompleted() {
//
//            }
//
//            @Override public void onError(Throwable e) {
//
//            }
//
//            @Override public void onNext(Integer integer) {
//
//            }
//
//            @Override public void onStart() {
//                super.onStart();
//            }
//        };
//
//        Observable<String> stringObservable = Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("hello");
//                subscriber.onNext("rx");
//                subscriber.onNext("java");
//                subscriber.onCompleted();
//            }
//        });


    }
}
