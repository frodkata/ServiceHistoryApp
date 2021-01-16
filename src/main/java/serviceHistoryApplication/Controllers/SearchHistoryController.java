package serviceHistoryApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import serviceHistoryApplication.Services.HistoryService;
import serviceHistoryApplication.Services.SearchHistoryService;

@Controller
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @Autowired
    private HistoryService historyService;


    @PostMapping("/search")
    public String searchHistory(Model model, @RequestParam String vin){

        //search repository for records by given VIN number
        if(searchHistoryService.searchHistory(vin) != null){ //if entry for VIN exists..
            model.addAttribute("searchedHistory", searchHistoryService.searchHistory(vin));
        }else{
            return "redirect:/searchHistory?error";

        }



        return "search";
    }




}
