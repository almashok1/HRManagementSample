package kz.adamant.hrmanagement.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.Admin;
import kz.adamant.hrmanagement.models.Role;
import kz.adamant.hrmanagement.models.UsernamePassword;
import kz.adamant.hrmanagement.view.hrmenu.admin.AdminPanelActivity;
import kz.adamant.hrmanagement.view.hrmenu.employee.OverviewActivity;
import kz.adamant.hrmanagement.viewmodel.AdminPanelViewModel;
import kz.adamant.hrmanagement.viewmodel.LoginFragmentViewModel;

public class LoginFragment extends Fragment {
    private LoginFragmentViewModel loginFragmentViewModel;
    private EditText etUsername;
    private EditText etPassword;
    private Button signInBtn;

    private Role role;

    private MutableLiveData<UsernamePassword> etEmployee;
    private MutableLiveData<Admin> etAdmin;

    public LoginFragment(Role role) {
        this.role = role;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginFragmentViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(LoginFragmentViewModel.class);

        if (role == Role.Admin) {
            etAdmin = loginFragmentViewModel.getEtAdmin();
            loginFragmentViewModel.getCountOfAdmin().observe(this, (count) -> {
                if (count == 1) {
                    Intent intent = new Intent(getActivity(), AdminPanelActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                    intent.putExtra("role", role);
                    startActivity(intent);
                    this.getActivity().finish();
                }
            });
        }
        else if (role == Role.Employee) {

            etEmployee = loginFragmentViewModel.getEtEmployee();
            loginFragmentViewModel.getCountOfEmployee().observe(this, (count) -> {
                if (count == 1) {
                    Intent intent = new Intent(getActivity(), OverviewActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                    intent.putExtra("id", etEmployee.getValue().getEmployeeID());
                    startActivity(intent);
                    this.getActivity().finish();
                }
            });
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUsername = view.findViewById(R.id.username);
        etPassword = view.findViewById(R.id.password);
        signInBtn = view.findViewById(R.id.login);

        signInBtn.setOnClickListener(v -> {
            try {
                if(role == Role.Admin) {
                    etAdmin.setValue(new Admin(etUsername.getText().toString(), etPassword.getText().toString()));
                }
                else if (role == Role.Employee) {
                    etEmployee.setValue(new UsernamePassword(Integer.parseInt(etUsername.getText().toString()), etPassword.getText().toString()));
                }
            } catch (Exception e) {
            }
        });
    }
}
