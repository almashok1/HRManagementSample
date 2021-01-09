package kz.adamant.hrmanagement.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kz.adamant.hrmanagement.models.Role;

public class SharedLoginViewModel extends ViewModel {
    private MutableLiveData<Role> role = new MutableLiveData<>();

    public void setRole(Role role) {
        this.role.postValue(role);
    }

    public MutableLiveData<Role> getRole() {
        return role;
    }
}
