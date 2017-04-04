package by.htp.cinema.controller;


import by.htp.cinema.entity.Order;

import by.htp.cinema.service.CanselReservation;
import by.htp.cinema.service.ReservedService;
import by.htp.cinema.service.SeeTimeTableService;
import by.htp.cinema.service.ShowOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class ReservationCinema {
    @Autowired
    ReservedService reservedService;
    @Autowired
    SeeTimeTableService seeTimeTableService;
    @Autowired
    ShowOrderInfoService showOrderInfoService;
    @Autowired
    CanselReservation canselReservation;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView model = new ModelAndView();
        model.setViewName(PageName.INDEX_PAGE);
        return model;
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation(@ModelAttribute Order order) {
        return PageName.RESERVATION;
    }


    @RequestMapping(value = "/see_timetable", method = RequestMethod.GET)
    public ModelAndView see_timetable() throws FileNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        List<String> listTimeTable = seeTimeTableService.seeTimeTable();
        modelAndView.addObject("listFilms", listTimeTable);
        modelAndView.setViewName(PageName.SEE_TIMETABLE);
        return modelAndView;
    }

    @RequestMapping(value = "/reserved", method = RequestMethod.POST)
    public ModelAndView orderOperation(@ModelAttribute("order") Order order) {
        ModelAndView model = new ModelAndView();
        String result = reservedService.reserved(order.getTime(), order.getPlace());
        model.setViewName(PageName.VIEW_INFORMATION);
        model.addObject("result", result);
        return model;
    }

    @RequestMapping(value = "/show_order_info", method = RequestMethod.GET)
    public ModelAndView showOrderInfo(@ModelAttribute("order") Order order) {
        ModelAndView model = new ModelAndView();
        String result = showOrderInfoService.showOrderInfo(order.getId());
        model.setViewName(PageName.SHOW_ORDER_INFO);
        model.addObject("info", result);
        return model;
    }

    @RequestMapping(value = "/cancel_reservation", method = RequestMethod.GET)
    public ModelAndView cansel_reservation(@ModelAttribute("order") Order order) {
        ModelAndView model = new ModelAndView();
        String result = canselReservation.canselReservation(order.getId());
        model.setViewName(PageName.SHOW_ORDER_INFO);
        model.addObject("info", result);
        return model;
    }
}
