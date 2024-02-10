package org.leftbrained.sixthtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import org.leftbrained.sixthtask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ItemViewModel model = new ItemViewModel(getSharedPreferences("prefs", MODE_PRIVATE));
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ItemAdapter adapter = new ItemAdapter(model.itemList);
        binding.mainView.setAdapter(adapter);
        binding.mainView.setLayoutManager(new LinearLayoutManager(this));
    }
}