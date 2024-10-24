package com.sparta.homeoffice.controllers;

import com.sparta.homeoffice.dto.TicketDTO;
import com.sparta.homeoffice.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sparta.homeoffice.entities.Ticket;
import java.util.List;


@Controller
@RequestMapping("/tickets")
public class WebController {

    private final TicketService ticketService;

    @Autowired
    public WebController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping
    public String getHome(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "home";
    }

    @PostMapping()
    public String postTicket(@ModelAttribute TicketDTO ticketDTO, Model model) {
        int ticketId = ticketService.createNewTicket(
                ticketDTO.getCategory(),
                ticketDTO.getPriority(),
                ticketDTO.getState(),
                ticketDTO.getAssigned(),
                ticketDTO.getShortDesc(),
                ticketDTO.getDesc(),
                ticketDTO.getType()
        );
        Ticket ticket = ticketService.getTicketById(ticketId);
        model.addAttribute("ticket", ticket);
        return "redirect:/tickets";
    }
}
