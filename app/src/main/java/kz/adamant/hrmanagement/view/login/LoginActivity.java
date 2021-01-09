package kz.adamant.hrmanagement.view.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.viewmodel.SharedLoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private SharedLoginViewModel sharedLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();
        sharedLoginViewModel = new ViewModelProvider(this).get(SharedLoginViewModel.class);
        sharedLoginViewModel.getRole().observe(this, role -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            LoginFragment fragment = new LoginFragment(role);
            fragmentTransaction.replace(R.id.fragment_container_login, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RoleFragment fragment = new RoleFragment();
        fragmentTransaction.add(R.id.fragment_container_login, fragment);
        fragmentTransaction.commit();
    }
}