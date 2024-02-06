package org.leftbrained;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.leftbrained.sixthtask.InfoFragment;
import org.leftbrained.sixthtask.ItemViewModel;
import org.leftbrained.sixthtask.R;
import org.leftbrained.sixthtask.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ActivityInfoBinding binding = ActivityInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ItemViewModel viewModel = new ItemViewModel();
        viewModel.itemList.forEach(
                item -> {
                    if (item.name.equals(getIntent().getStringExtra("name"))) {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction trans = manager.beginTransaction();
                        InfoFragment info = new InfoFragment(item.stars, item.link);
                        trans.replace(R.id.host, info);
                        trans.commit();
                    }
                }
        );
    }
}