package org.leftbrained.sixthtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {
    private int rate;
    private String url;

    public InfoFragment(int rate, String url) {
        this.rate = rate;
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_info, container, false);
        RatingBar rating = view.findViewById(R.id.ratingBar);
        WebView web = view.findViewById(R.id.web);
        web.loadUrl(url);
        rating.setRating(rate);
        return view;
    }
}
