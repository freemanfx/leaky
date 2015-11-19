package com.cegeka.leaky;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import rx.Observable;
import rx.Subscriber;

import static rx.android.schedulers.AndroidSchedulers.mainThread;
import static rx.schedulers.Schedulers.computation;

public class ImageService {

    private Context context;

    public ImageService(Context context) {
        this.context = context;
    }

    public Observable<Bitmap> imagesFromDrawable(final int resourceId) {
        return Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8;
                Bitmap icon = BitmapFactory.decodeResource(context.getResources(), resourceId, options);
                subscriber.onNext(icon);
                subscriber.onCompleted();
            }
        }).subscribeOn(computation()).observeOn(mainThread());
    }
}
