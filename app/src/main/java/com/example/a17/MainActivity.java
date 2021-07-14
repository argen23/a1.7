package com.example.a17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.a17.databinding.ActivityMainBinding;
import com.example.a17.fragments.AllInboxesFragment;
import com.example.a17.fragments.DoneFragment;
import com.example.a17.fragments.DraftsFragment;
import com.example.a17.fragments.HelpFragment;
import com.example.a17.fragments.HistoryFragment;
import com.example.a17.fragments.HomeFragment;
import com.example.a17.fragments.InboxFragment;
import com.example.a17.fragments.ProfileFragment;
import com.example.a17.fragments.RemindFragment;
import com.example.a17.fragments.SendFragment;
import com.example.a17.fragments.SettingsFragment;
import com.example.a17.fragments.ShoozedFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setupNavView();
        toggle = new ActionBarDrawerToggle(this, binding.getRoot(), R.string.drawer_open, R.string.drawer_close);
        toggle.syncState();
        binding.getRoot().addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    private void setupNavView() {
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment = null;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.box:
                        fragment = new AllInboxesFragment();
                        break;
                    case R.id.inbox:
                        fragment = new InboxFragment();
                        break;
                    case R.id.shoozed:
                        fragment = new ShoozedFragment();
                        break;
                                   case R.id.done:
                        fragment = new DoneFragment();
                        break;
                                   case R.id.drafts:
                        fragment = new DraftsFragment();
                        break;
                                   case R.id.sent:
                        fragment = new SendFragment();
                        break;
                                   case R.id.reminders:
                        fragment = new RemindFragment();
                        break;
                                   case R.id.settings:
                        fragment = new SettingsFragment();
                        break;
                                   case R.id.h_f:
                        fragment = new HelpFragment();
                        break;

                }
                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.mContainer, fragment).addToBackStack(null).commit();
                setTitle(item.getTitle());
                binding.getRoot().closeDrawers();

                return false;
            }
        });
    }

}