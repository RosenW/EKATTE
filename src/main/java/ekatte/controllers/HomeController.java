package ekatte.controllers;

import ekatte.entities.Area;
import ekatte.entities.Municipality;
import ekatte.entities.Settlement;
import ekatte.repository.AreaRepository;
import ekatte.repository.MunicipalityRepository;
import ekatte.repository.SettlementRepository;
import ekatte.utils.DatabaseManager;
import ekatte.utils.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final AreaRepository areaRepository;
    private final MunicipalityRepository municipalityRepository;
    private final SettlementRepository settlementRepository;

    @Autowired
    public HomeController(AreaRepository areaRepository, MunicipalityRepository municipalityRepository, SettlementRepository settlementRepository) {
        this.areaRepository = areaRepository;
        this.municipalityRepository = municipalityRepository;
        this.settlementRepository = settlementRepository;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        ExcelReader excelReader = new ExcelReader();
        DatabaseManager databaseManager = new DatabaseManager();
        String data = excelReader.readExcelFile("Ek_atte");

        return "home";
    }
}