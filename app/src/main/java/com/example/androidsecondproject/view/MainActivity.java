package com.example.androidsecondproject.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidsecondproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginFragmentInterface, RegisterFragment.RegisterFragmentInterface {

    private  final  String LOGIN_FRAGMENT="login_fragment";
    private  final  String REGISTER_FRAGMENT="register_fragment";
    private  final  String ACCOUNT_SETUP_FRAGMENT="account_setup_fragment";

    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        loginFragment = loginFragment.newInstance();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.main_activity_id,loginFragment,LOGIN_FRAGMENT);
        transaction.addToBackStack(null);
        transaction.commit();
     //   loginFragment.setCancelable(false);

       /* loginFragment=loginFragment.newInstance();
        loginFragment.show(getSupportFragmentManager(),null);
        loginFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFragmentTheme);*/

    }


    @Override
    public void onClickMoveToRegister() {
        registerFragment=RegisterFragment.newInstance();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.main_activity_id,registerFragment,REGISTER_FRAGMENT);
        transaction.addToBackStack(null);
        transaction.commit();

    /*    loginFragment.dismiss();
        registerFragment=registerFragment.newInstance();
        registerFragment.show(getSupportFragmentManager(),null);
        registerFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFragmentTheme);*/
    }

    @Override
    public void onClickMoveToLogin() {
        loginFragment=LoginFragment.newInstance();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.main_activity_id,loginFragment,LOGIN_FRAGMENT);
        transaction.addToBackStack(null);
        transaction.commit();

        /*registerFragment.dismiss();
        loginFragment=loginFragment.newInstance();
        loginFragment.show(getSupportFragmentManager(),null);
        loginFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFragmentTheme);*/
    }

    @Override
    public void onMoveToNameSetup(String uid) {
        Fragment accountSetupFragment=AccountSetupFragment.newInstance();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.main_activity_id,accountSetupFragment,ACCOUNT_SETUP_FRAGMENT);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            drawerLayout.openDrawer(Gravity.START);
        }
        return super.onOptionsItemSelected(item);
    }
}