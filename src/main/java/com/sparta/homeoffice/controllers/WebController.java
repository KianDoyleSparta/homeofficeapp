package com.sparta.homeoffice.controllers;

import com.sparta.homeoffice.entities.Ticket;
import com.sparta.homeoffice.services.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class WebController {

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("tickets", TicketService.getTickets());
//        model.addAttribute("tickets", List.of(new Ticket()));
        return "home";
    }

    @PostMapping
    public String postHome(@ModelAttribute Ticket ticket) {
//        TicketService.createTicket(ticket);
        return "redirect:/tickets";
    }
}
