package com.cegeka.leaky;


import android.graphics.Bitmap;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;


public class Model {
    private ImageService imageService;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public Model(ImageService imageService) {
        this.imageService = imageService;
    }

    public void getDrawable(int resourceId, Action1<Bitmap> subscriber) {
        Observable<Bitmap> bitmapObservable = imageService.imagesFromDrawable(resourceId);
        Subscription subscription = bitmapObservable.subscribe(subscriber);
        compositeSubscription.add(subscription);
    }

    public void unsubscribe() {
        compositeSubscription.clear();
    }
}
