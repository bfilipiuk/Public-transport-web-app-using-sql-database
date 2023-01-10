package bdbt_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private PracownikDAO dao;
    @Autowired
    private PrzystanekDAO daoPrzystanek;
    @Autowired
    private LiniaDAO daoLinia;
    @Autowired
    private PrzystankiNaLiniiDAO daoPrzystankiNaLinii;
    @Autowired
    private KlientDAO daoKlient;

//    @RequestMapping("/")
//    public String viewHomePage(Model model) {
//        List<Pojazd> listPojazd = dao.list();
//        System.out.println(Arrays.toString(listPojazd.toArray()));
//        model.addAttribute("listPojazd", listPojazd);
//
//        return "index";
//    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
//        registry.addViewController("/emp_management").setViewName("admin/emp_management");
//        registry.addViewController("/routes_management").setViewName("admin/routes_management");
//        registry.addViewController("/vehicle_management").setViewName("admin/vehicle_management");
//        registry.addViewController("/stops_list").setViewName("admin/stops_list");
//        registry.addViewController("/routes_list").setViewName("admin/routes_list");
    }

    @Controller
    public class DashboardController
    {
        @RequestMapping("/")
        public String viewIndex(Model model) {

            return "index";
        }

        @RequestMapping
                ("/main"
                )


        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user/1";
            }
            else
            {
                return "redirect:/index";
            }
        }
        @RequestMapping(value={"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }
//        @RequestMapping(value={"/main_user/{idKlienta}"})
//        public String showUserPage(Model model, @PathVariable(name = "idKlienta") int id) {
//            Klient klient = daoKlient.get(id);
//            model.addAttribute();
//
//            return "user/main_user";
//        }

        @RequestMapping(value = "/main_user/{idKlienta}")
        public ModelAndView showUserPage(Model model, @PathVariable(name = "idKlienta") int id) {
            ModelAndView mav = new ModelAndView("user/main_user");

            Klient klient = daoKlient.get(id);
            mav.addObject(klient);

            return mav;
        }

        @RequestMapping(value={"/emp_management"})
        public String showEmpManagementPage(Model model) {
            List<Pracownik> listPracownik = dao.list();
            model.addAttribute("listPracownik", listPracownik);
            return "admin/emp_management";
        }

        @RequestMapping(value={"/new"})
        public String showNewEmpPage(Model model) {
            Pracownik pracownik = new Pracownik();
            model.addAttribute("pracownik", pracownik);
            return "admin/new_form";
        }

        @RequestMapping(value = "/new_stop")
        public String showNewStopPage(Model model) {
            Przystanek przystanek = new Przystanek();
            model.addAttribute("przystanek", przystanek);

            return "admin/new_stop_form";
        }

        @RequestMapping(value = "/new_route")
        public String showNewRoutePage(Model model) {
            Linia linia = new Linia();
            model.addAttribute("linia", linia);

            return "admin/new_route_form";
        }

//        @RequestMapping(value = "/new_stop_on_route")
//        public String showNewStopOnRouteForm(Model model) {
//            PrzystankiNaLinii przystankiNaLinii = new PrzystankiNaLinii();
//            model.addAttribute("przystankiNaLinii", przystankiNaLinii);
//
//            return "admin/new_stop_on_route_form";
//        }

        @RequestMapping(value = "/inspect_route/{idLinii}/new_stop_on_route")
        public ModelAndView showNewStopOnRoutePage(Model model, @PathVariable(name = "idLinii") int id) {
            ModelAndView mav = new ModelAndView("admin/new_stop_on_route_form");
            List<Przystanek> listPrzystanek = daoPrzystanek.list();
            model.addAttribute("listPrzystanek", listPrzystanek);

            List<Przystanek> listTypePrzystanek = daoPrzystanek.listType(daoLinia.get(id).getRodzajLinii());
            model.addAttribute("listTypePrzystanek", listTypePrzystanek);

            Linia linia = daoLinia.get(id);
            mav.addObject("linia", linia);

            return mav;
        }

        @RequestMapping(value="/inspect_route/{idLinii}/save_przystanek_na_linii", method = RequestMethod.POST)
        public String saveStopOnRoute(@PathVariable(name = "idLinii") int idLinii, @RequestParam(name = "idPrzystanku") int idPrzystanku) {
            System.out.println("idLinii: " + idLinii);
            System.out.println("idPrzystanku" + idPrzystanku);

            PrzystankiNaLinii przystanek = new PrzystankiNaLinii(idPrzystanku, idLinii);

            daoPrzystankiNaLinii.savePrzystankiNaLinii(przystanek);

            return "redirect:/inspect_route/{idLinii}";
        }

        @RequestMapping(value="/save", method = RequestMethod.POST)
        public String saveEmp(@ModelAttribute("pracownik") Pracownik pracownik) {
            dao.save(pracownik);

            return "redirect:/emp_management";
        }

        @RequestMapping(value = "/choose_route_type")
        public String showChooseRouteTypePage() {
            return "user/choose_route_type";
        }

        @RequestMapping(value="/savePrzystanek", method = RequestMethod.POST)
        public String saveStop(@ModelAttribute("przystanek") Przystanek przystanek) {
            daoPrzystanek.savePrzystanek(przystanek);

            return "redirect:/stops_list";
        }

        @RequestMapping(value="/save_linia", method = RequestMethod.POST)
        public String saveLinia(@RequestParam boolean czyAktywna, @RequestParam char rodzajLinii, @RequestParam int idBazy) {
            System.out.println(czyAktywna);
            System.out.println(rodzajLinii);
            System.out.println(idBazy);

            Linia linia = new Linia(czyAktywna, rodzajLinii, idBazy);

            daoLinia.saveLinia(linia);

            return "redirect:/routes_list";
        }

        @RequestMapping("/edit/{idPracownika}")
        public ModelAndView showEditEmpPage(@PathVariable(name = "idPracownika") int id) {
            ModelAndView mav = new ModelAndView("admin/edit_form");
            Pracownik pracownik = dao.get(id);
            mav.addObject("pracownik", pracownik);

            return mav;
        }

        @RequestMapping("/edit_user_data/{idKlienta}")
        public ModelAndView showEditUserDataPage(@PathVariable(name = "idKlienta") int id) {
            ModelAndView mav = new ModelAndView("user/edit_user_data_form");

            Klient klient = daoKlient.get(id);
            mav.addObject("klient", klient);

            return mav;
        }

        @RequestMapping("/edit_stop/{idPrzystanku}")
        public ModelAndView showEditStopPage(@PathVariable(name = "idPrzystanku") int id) {
            ModelAndView mav = new ModelAndView("admin/edit_stop_form");
            Przystanek przystanek = daoPrzystanek.get(id);
            mav.addObject("przystanek", przystanek);

            return mav;
        }

        @RequestMapping("/edit_route/{idLinii}")
        public ModelAndView showEditRoutePage(@PathVariable(name = "idLinii") int id) {
            ModelAndView mav = new ModelAndView("admin/edit_route_form");
            Linia linia = daoLinia.get(id);
            mav.addObject("linia", linia);

            return mav;
        }

        @RequestMapping("/inspect_route/{idLinii}")
        public ModelAndView showInspectRoutePage(Model model, @PathVariable(name = "idLinii") int id) {
            ModelAndView mav = new ModelAndView("admin/inspect_route");
            Linia linia = daoLinia.get(id);
            mav.addObject("linia", linia);

            List<PrzystankiNaLinii> listPrzystankiNaLinii = daoPrzystankiNaLinii.list(id);
            model.addAttribute("listPrzystankiNaLinii", listPrzystankiNaLinii);

            return mav;
        }

        @RequestMapping("/inspect_route_user/{idLinii}")
        public ModelAndView showInspectRouteUserPage(Model model, @PathVariable(name = "idLinii") int id) {
            ModelAndView mav = new ModelAndView("user/inspect_route_user");
            Linia linia = daoLinia.get(id);
            mav.addObject("linia", linia);

            List<PrzystankiNaLinii> listPrzystankiNaLinii = daoPrzystankiNaLinii.list(id);
            model.addAttribute("listPrzystankiNaLinii", listPrzystankiNaLinii);

            return mav;
        }

        @RequestMapping("/choose_route_type/{rodzajLinii}")
        public String showRoutesTypePage(Model model, @PathVariable (name = "rodzajLinii") char rodzajLinii) {
            List<Linia> listLiniaType = daoLinia.listType(rodzajLinii);
            model.addAttribute("listLiniaType", listLiniaType);

            return "user/routes_list_type";
        }

        @RequestMapping(value="/update", method = RequestMethod.POST)
        public String updateEmp(@ModelAttribute("pracownik") Pracownik pracownik) {
            dao.update(pracownik);

            return "redirect:/emp_management";
        }

        @RequestMapping(value="/update_stop", method = RequestMethod.POST)
        public String updateStop(@ModelAttribute("przystanek") Przystanek przystanek) {
            daoPrzystanek.update(przystanek);

            return "redirect:/stops_list";
        }

        @RequestMapping(value="/update_route", method = RequestMethod.POST)
        public String updateRoute(@ModelAttribute("linia") Linia linia) {
            daoLinia.update(linia);

            return "redirect:/routes_list";
        }

        @RequestMapping(value = "/update_user_data", method = RequestMethod.POST)
        public String updateUserData(@ModelAttribute("klient") Klient klient) {
            daoKlient.update(klient);

            String idString = Integer.toString(klient.getIdKlienta());

            return "redirect:/main_user/" + idString;
        }

        @RequestMapping("/delete/{idPracownika}")
        public String deleteEmp(@PathVariable(name = "idPracownika") int id) {
            dao.delete(id);

            return "redirect:/emp_management";
        }

        @RequestMapping("/delete_stop/{idPrzystanku}")
        public String deleteStop(@PathVariable(name = "idPrzystanku") int id) {
            daoPrzystanek.deleteStop(id);

            return "redirect:/stops_list";
        }

        @RequestMapping("/delete_route/{idLinii}")
        public String deleteRoute(@PathVariable(name = "idLinii") int id) {
            daoLinia.delete(id);

            return "redirect:/routes_list";
        }

        @RequestMapping("/inspect_route/{idLinii}/delete_stop_from_route/{idPrzystanku}")
        public String deleteStopFromRoute(@PathVariable(name = "idPrzystanku") int idPrzystanku, @PathVariable(name = "idLinii") int idLinii) {
            daoPrzystankiNaLinii.deletePrzystanekNaLinii(idPrzystanku);
            String idLiniiString = Integer.toString(idLinii);
            return "redirect:/inspect_route/" + idLiniiString;
        }

        @RequestMapping(value={"/routes_management"})
        public String showRoutesManagementPage(Model model) { return "admin/routes_management"; }

        @RequestMapping(value={"/stops_list"})
        public String showStopsListPage(Model model) {
            List<Przystanek> listPrzystanek = daoPrzystanek.list();
            model.addAttribute("listPrzystanek", listPrzystanek);

            return "admin/stops_list";
        }

        @RequestMapping(value={"/routes_list"})
        public String showRoutesListPage(Model model) {
            List<Linia> listLinia = daoLinia.list();
            model.addAttribute("listLinia", listLinia);

            return "admin/routes_list";
        }

        @RequestMapping(value={"/vehicles_management"})
        public String showVehiclesManagementPage(Model model) { return "admin/vehicles_management"; }
    }
    }
