package org.koushik.javabrains.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.koushik.javabrains.model.Message;
import org.koushik.javabrains.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//http://localhost:8080/webapi/messages/
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year) {
        if (year > 0) {
            return messageService.getAllMessagesForYear(year);
        }
        return messageService.getAllMessages();
    }

    @POST
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    //http://localhost:8080/webapi/messages/1
    public Message updateMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    //http://localhost:8080/webapi/messages/1
    public void deleteMessage(@PathParam("messageId") long id) {
        messageService.removeMessage(id);
    }

    @GET
    @Path("/{messageId}")
    //http://localhost:8080/webapi/messages/1
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
    }
}
