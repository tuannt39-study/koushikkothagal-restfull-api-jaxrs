package org.koushik.javabrains.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.koushik.javabrains.model.Message;
import org.koushik.javabrains.service.MessageService;

@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }
}
