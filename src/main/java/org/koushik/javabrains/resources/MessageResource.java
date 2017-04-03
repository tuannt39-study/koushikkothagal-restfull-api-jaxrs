package org.koushik.javabrains.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.model.Message;
import org.koushik.javabrains.resources.bean.MessageFilterBean;
import org.koushik.javabrains.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//http://localhost:8080/webapi/messages/
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYear() > 0) {
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }
        if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
            return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        }
        return messageService.getAllMessages();
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException{
        System.out.print(uriInfo.getAbsolutePath());
        Message newMessage = messageService.addMessage(message);
        return Response.created(new URI("/webapi/messages/" + newMessage.getId()))
                .entity(newMessage)
                .build();
        //return messageService.addMessage(message);
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

    @Path("/{messageId}/comments")
    //http://localhost:8080/webapi/messages/1/comments
    public CommentResource getCommentResource() {
        return new CommentResource();
    }
}
