package com.viettelmor.reportvast.Controller;

import com.viettelmor.reportvast.Service.UserServiceImpl;
import com.viettelmor.reportvast.ViewModel.EditAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users/editaccount")
    public String getEditAccount(Model model){
        model.addAttribute("userForm", new EditAccount());
        return "users/editaccount";
    }

    @PostMapping("/users/editaccount")
    public String postEditAccount(@ModelAttribute("userForm") @Valid EditAccount userForm, BindingResult result){
        if(result.hasErrors()){
            LOGGER.error(result.getAllErrors());
            return "users/editaccount";
        }
        if(userService.updatePassword(userForm.getOldPass(), userForm.getNewPass()))
            return "redirect:/";
        else {
            result.rejectValue("oldPass", "1", "Wrong password");
            LOGGER.error(result.getAllErrors());
            return "users/editaccount";
        }
    }
}
