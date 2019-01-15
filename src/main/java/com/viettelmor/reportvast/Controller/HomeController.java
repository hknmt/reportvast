package com.viettelmor.reportvast.Controller;

import com.viettelmor.reportvast.BusinessObject.ChargeLog;
import com.viettelmor.reportvast.Service.ChargeLogServiceImpl;
import com.viettelmor.reportvast.Service.ServiceConfigImpl;
import com.viettelmor.reportvast.ViewModel.DataTable;
import com.viettelmor.reportvast.ViewModel.EditAccount;
import com.viettelmor.reportvast.ViewModel.FormSearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class HomeController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private ChargeLogServiceImpl chargeLogService;

    @Autowired
    private ServiceConfigImpl serviceConfig;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/")
    public String getIndex(Model model){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        FormSearch formSearch = new FormSearch();
        formSearch.setTo(Date.from(now.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        formSearch.setFrom(Date.from(now.minusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        model.addAttribute("serviceCode", serviceConfig.getAll());
        model.addAttribute("formSearch", formSearch);
        return "index";
    }

    @PostMapping("/")
    @Transactional(readOnly = true)
    public String postIndex(@ModelAttribute("formSearch") @Valid FormSearch formSearch, BindingResult result, Model model){
        if(result.hasErrors()) {
            LOGGER.error(result.getAllErrors());
            return "redirect:/";
        }else{
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            List<ChargeLog> chargeLog = chargeLogService.getAllChargeLogByServicesCodeAndDate(formSearch.getServiceCode(), dateFormat.format(formSearch.getFrom()), dateFormat.format(formSearch.getTo()));
            if(chargeLog.size() > 0) {
                List<DataTable> dataTables = new ArrayList<>();
                chargeLog.forEach(item -> {
                    dataTables.add(new DataTable(item));
                });
                model.addAttribute("dataTable", dataTables);
            }else{
                LOGGER.error(formSearch);
            }
            model.addAttribute("formSearch", formSearch);
            model.addAttribute("serviceCode", serviceConfig.getAll());

            return "index";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse res){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(req, res, authentication);
        }
        return "redirect:/login?logout";
    }

//    @GetMapping(value = "/export",params = {"type"})
//    @Transactional(readOnly = true)
//    public void export(HttpServletResponse response, @RequestParam("type") String type){
//        response.addHeader("Content-Type", "application/csv");
//        response.addHeader("Content-Disposition", "attachment; filename=todos.csv");
//        response.setCharacterEncoding("UTF-8");
//        try(Stream<ChargeLog> getSteam = chargeLogService.export()) {
//            PrintWriter out = response.getWriter();
//            getSteam.forEach(todo -> {
//                String line = todo.toString();
//                out.write(line);
//                out.write("\n");
//                entityManager.detach(todo);
//            });
//            out.flush();
//        } catch (IOException e) {
//            throw new RuntimeException("Exception occurred while exporting results", e);
//        }
//
//    }

}
