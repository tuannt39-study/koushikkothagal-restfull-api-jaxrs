package org.koushik.javabrains.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.koushik.javabrains.model.Message;
import org.koushik.javabrains.service.MessageService;

@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    //http://localhost:8080/webapi/messages/
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //http://localhost:8080/webapi/messages/
    public String addMessage(){
        return "POST works";
    }

    @GET
    @Path("/{messageId}")
    //http://localhost:8080/webapi/messages/1
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
    }
}
