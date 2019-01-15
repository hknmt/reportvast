package com.viettelmor.reportvast.ViewModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditAccount {
    @NotNull
    @Size(min = 6)
    private String oldPass;

    @NotNull
    @Size(min = 6)
    private String newPass;

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
