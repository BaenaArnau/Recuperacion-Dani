package com.example.leagueofchamps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    protected final int home = 1;
    protected final int profile = 2;
    protected final int chat = 3;
    private NavController navController;
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    static MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        bottomNavigation = findViewById(R.id.meowBottomNavigation);

        // Adding items to the bottom navigation
        bottomNavigation.add(new MeowBottomNavigation.Model(home, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(profile, R.drawable.baseline_contacts_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(chat, R.drawable.baseline_comment_24));

        // Setting up the listener for item click
        bottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case home:
                    navController.navigate(R.id.homeFragment);
                    break;
                case profile:
                    navController.navigate(R.id.profileFragment);
                    break;
                case chat:
                    navController.navigate(R.id.socialFragment);
                    break;
                default:
                    Toast.makeText(MainActivity.this, "Unknown item clicked", Toast.LENGTH_SHORT).show();
            }
            return null;
        });

        // Optionally set the initial selected item
        bottomNavigation.show(home, true);
    }
}
