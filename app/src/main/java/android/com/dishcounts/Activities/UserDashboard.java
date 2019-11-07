package android.com.dishcounts.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.com.dishcounts.Fragments.AddNewFragment;
import android.com.dishcounts.Fragments.CouponFragment;
import android.com.dishcounts.Fragments.FriendsFragment;
import android.com.dishcounts.Fragments.ProfileFragment;
import android.os.Bundle;
import android.com.dishcounts.R;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserDashboard extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        Bundle extras = getIntent().getExtras();
        Boolean showToast;

        if (extras != null){
            showToast =  extras.getBoolean("showToast");
            if (showToast){
                Toast.makeText(this, "Coupon Added Succesfully!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Post Added Succesfully!", Toast.LENGTH_SHORT).show();
            }
        }

        toolbar = getSupportActionBar();
        toolbar.hide();
        toolbar.setTitle("Coupon");


        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CouponFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.coupons:
                    toolbar.setTitle("Coupon");
                    fragment = new CouponFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.add_new:
                    toolbar.setTitle("Add New");
                    fragment = new AddNewFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.friends:
                    toolbar.setTitle("Friends");
                    fragment = new FriendsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.profile:
                    toolbar.setTitle("Profile");
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
