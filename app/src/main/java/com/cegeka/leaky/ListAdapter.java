package com.cegeka.leaky;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import rx.functions.Action1;

import static java.util.Arrays.asList;


public class ListAdapter extends ArrayAdapter<Integer> {
    private List<Integer> images = asList(R.drawable.i1, R.drawable.i2, R.drawable.i1, R.drawable.i2, R.drawable.i1, R.drawable.i2, R.drawable.i1, R.drawable.i2, R.drawable.i1, R.drawable.i2);

    public ListAdapter(Context context) {
        super(context, R.layout.list_fragment_item);
        addAll(images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_fragment_item, parent, false);
        }

        int currentItem = images.get(position);
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        imageView.setOnClickListener(getOnclickListener());

        BeanProvider.imageService().imagesFromDrawable(currentItem)
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                });

        return convertView;
    }

    private View.OnClickListener getOnclickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity context = (MainActivity) getContext();
                context.switchFragment();
            }
        };
    }
}
