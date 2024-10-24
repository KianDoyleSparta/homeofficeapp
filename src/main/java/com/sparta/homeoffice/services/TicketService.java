package com.sparta.homeoffice.services;

import com.sparta.homeoffice.dto.TicketDTO;
import com.sparta.homeoffice.entities.Ticket;
import com.sparta.homeoffice.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createNewTicket(String category, String priority, String state, String assigned, String shortDesc, String desc, String type) {
        Ticket ticket = new Ticket();
        ticket.setCategory(category);
        ticket.setPriority(priority);
        ticket.setState(state);
        ticket.setAssigned(assigned);
        ticket.setShortDesc(shortDesc);
        ticket.setDesc(desc);
        ticket.setType(type);
        ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public boolean updateTicketById(Integer id, TicketDTO ticketUpdateDetails) {
        Optional<Ticket> ticketToUpdate = ticketRepository.findById(id);
        if (ticketToUpdate.isPresent()) {
            if (ticketUpdateDetails.getCategory() != null) {
                ticketToUpdate.get().setCategory(ticketUpdateDetails.getCategory());
            }
            if (ticketUpdateDetails.getPriority() != null) {
                ticketToUpdate.get().setPriority(ticketUpdateDetails.getPriority());
            }
            if (ticketUpdateDetails.getState() != null) {
                ticketToUpdate.get().setState(ticketUpdateDetails.getState());
            }
            if (ticketUpdateDetails.getAssigned() != null) {
                ticketToUpdate.get().setAssigned(ticketUpdateDetails.getAssigned());
            }
            if (ticketUpdateDetails.getShortDesc() != null) {
                ticketToUpdate.get().setShortDesc(ticketUpdateDetails.getShortDesc());
            }
            if (ticketUpdateDetails.getDesc() != null) {
                ticketToUpdate.get().setDesc(ticketUpdateDetails.getDesc());
            }
            if (ticketUpdateDetails.getType() != null) {
                ticketToUpdate.get().setType(ticketUpdateDetails.getType());
            }
            ticketRepository.save(ticketToUpdate.get());
            return true;
        }
        return false;
    }

    public void deleteTicket(Integer id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        ticket.ifPresent(ticketRepository::delete);
    }

}
