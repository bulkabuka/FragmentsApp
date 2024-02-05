package org.leftbrained.taskfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnItemSelectedListener(onItemSelectedListener);
        loadFragment(HomeFragment.newInstance());
    }

    private NavigationBarView.OnItemSelectedListener onItemSelectedListener = item -> {
        if (item.getItemId() == R.id.navigation_home) {
            loadFragment(HomeFragment.newInstance());
            return true;
        } else if (item.getItemId() == R.id.navigation_dashboard) {
            loadFragment(DashboardFragment.newInstance());
            return true;
        } else if (item.getItemId() == R.id.navigation_notifications) {
            loadFragment(NotificationsFragment.newInstance());
            return true;
        }
        return false;
    };

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
    }
}