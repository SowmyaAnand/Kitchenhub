package com.example.kitchenhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public final class ImageAdapter extends BaseAdapter {
    private LayoutInflater mContext;
    public Integer[] mThumbIds = {R.drawable.cakes, R.drawable.snacks, R.drawable.beverages, R.drawable.biriyani, R.drawable.vegetarian, R.drawable.nonveg};
    private final List<Item> mItems = new ArrayList<Item>();
    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    public ImageAdapter(Context c) {
        mContext = LayoutInflater.from(c);
        mItems.add(new Item("CAKES RECIPES",R.drawable.cakes));
        mItems.add(new Item("SNACKS RECIPES",R.drawable.snacks));
        mItems.add(new Item("BEVERAGES RECIPES",R.drawable.beverages));
        mItems.add(new Item("BIRIYANI RECIPES",R.drawable.biriyani));
        mItems.add(new Item("VEGETARIAN RECIPES",R.drawable.vegetarian));
        mItems.add(new Item("NON-VEGETARIAN RECIPES",R.drawable.nonveg));
        mItems.add(new Item("CAKES RECIPES",R.drawable.cakes));
        mItems.add(new Item("SNACKS RECIPES",R.drawable.snacks));
        mItems.add(new Item("BEVERAGES RECIPES",R.drawable.beverages));
    }

    @Override
    public Item getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//
//        if (convertView == null) {
//
//           // imageView = new ImageView(mContext);
//          //  imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//          //  imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            //imageView.setPadding(8, 8, 8, 8);
//
//        }
//        else
//        {
//            imageView = (ImageView) convertView;
//        }
//        imageView.setImageResource(mThumbIds[position]);
//        return imageView;

        // }
        View v = convertView;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mContext.inflate(R.layout.fragment_1, parent, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item it = getItem(position);

        picture.setImageResource(it.drawableId);
        name.setText(it.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }

}