package com.tvgsoft.arc;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.tvgsoft.core.view.BaseRecyclerViewAdapter;
import java.util.List;

/**
 * Created by TVG on 7/27/16.
 */
public class AppBindingAdapter {

    @BindingAdapter(value = {"items"})
    public static <T> void setAdapter(RecyclerView recyclerView, List<T> items) {
        if (recyclerView.getAdapter() instanceof BaseRecyclerViewAdapter) {
            BaseRecyclerViewAdapter adapter = (BaseRecyclerViewAdapter) recyclerView.getAdapter();
            if (adapter != null) {
                adapter.setData(items);
            }
        }
    }

    @BindingAdapter(value = {"imageUrl", "placeHolder"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.with(view.getContext())
                .load(url)
                .error(error)
                .into(view);
    }

    @BindingAdapter(value = {"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .into(view);
    }

}
