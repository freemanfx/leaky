package com.cegeka.leaky;


import android.content.Context;

public class BeanProvider {
    private static Context context;
    private static ImageService imageService;

    public static void init(Context context) {
        BeanProvider.context = context;
    }

    public static ImageService imageService() {
        if (imageService == null) {
            imageService = new ImageService(context);
        }
        return imageService;
    }
}
