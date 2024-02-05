package org.leftbrained.fragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentGeneric extends Fragment {
    private int background;
    private String title;

    private static final String FRAGMENT_COLOR = "FRAGMENT_COLOR";
    private static final String FRAGMENT_TITLE = "FRAGMENT_TITLE";

    public static FragmentGeneric getInstance(int color, String data) {
        FragmentGeneric fragmentGeneric = new FragmentGeneric();

        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_COLOR, color);
        bundle.putString(FRAGMENT_TITLE, data);

        fragmentGeneric.setArguments(bundle);
        return fragmentGeneric;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args == null) return;
        if (args.containsKey(FRAGMENT_TITLE)) {
            title = args.getString(FRAGMENT_TITLE);
        }
        if (args.containsKey(FRAGMENT_COLOR)) {
            background = args.getInt(FRAGMENT_COLOR);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generic, container, false);
        RelativeLayout relativeLayout = view.findViewById(R.id.relative);
        TextView text = view.findViewById(R.id.text);
        relativeLayout.setBackgroundColor(background);
        text.setText(title);
        return view;
    }
}
