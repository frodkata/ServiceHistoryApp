package serviceHistoryApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import serviceHistoryApplication.Entities.History;
import serviceHistoryApplication.Services.HistoryService;
import serviceHistoryApplication.Services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private UserService userService;


    // display list of service history
    @GetMapping("/")
    public String viewHomePage(Model model) {


        //fetch history by user id
        List<History> listHistory = historyService.getByUserId(userService.getCurrentUser().getId());
        model.addAttribute("listHistory", listHistory);

        return "index";
    }

    @GetMapping("/showNewHistoryForm")
    public String showNewHistoryForm(Model model) {
        // create model attribute to bind form data
        History history = new History();
        model.addAttribute("history", history);
        return "new_history";
    }



    @PostMapping("/saveHistory")
    public String saveHistory(@Valid @ModelAttribute("history") History history,  BindingResult bindingResult ) {

        //VALIDATE FORM
        if (bindingResult.hasErrors()) {  //check if entity constraints are satisfied

            return "new_history";
        }else{    //Set valid history to match creator user id
            history.setUserID(userService.getCurrentUser().getId());
            historyService.saveHistory(history);
            return "redirect:/";
        }



    }



    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get history from the service
        History history = historyService.getHistoryById(id);

        // set history as a model attribute to pre-populate the form
        model.addAttribute("history", history);
        return "update_history";


    }

    @GetMapping("/deleteHistory/{id}")
    public String deleteHistory(@PathVariable (value = "id") long id) {

        //  delete history
        this.historyService.deleteHistoryById(id);
        return "redirect:/";
    }




}
