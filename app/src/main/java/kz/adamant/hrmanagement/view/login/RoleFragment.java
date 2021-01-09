package kz.adamant.hrmanagement.view.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.Role;
import kz.adamant.hrmanagement.viewmodel.SharedLoginViewModel;

public class RoleFragment extends Fragment {
    private CardView adminRoleCard;
    private CardView employeeRoleCard;
    private SharedLoginViewModel sharedLoginViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedLoginViewModel = new ViewModelProvider(requireActivity()).get(SharedLoginViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_role, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adminRoleCard = view.findViewById(R.id.role_admin);
        employeeRoleCard = view.findViewById(R.id.role_employee);
        adminRoleCard.setOnClickListener(v -> {
            onClickRole(Role.Admin);
        });
        employeeRoleCard.setOnClickListener(v -> {
            onClickRole(Role.Employee);
        });
    }

    private void onClickRole(Role role) {
        sharedLoginViewModel.setRole(role);
    }

}
