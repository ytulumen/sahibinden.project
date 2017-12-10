package com.yasin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getWelcomePage() {
        return "welcomePage";
    }

    @RequestMapping(path = "/tickerpage", method = RequestMethod.GET)
    public String getTickerPage() {
        return "TickerManagement";
    }

    @RequestMapping(path = "/historypage", method = RequestMethod.GET)
    public String getHistoricalPage() {
        return "HistoricalManagement";
    }
}