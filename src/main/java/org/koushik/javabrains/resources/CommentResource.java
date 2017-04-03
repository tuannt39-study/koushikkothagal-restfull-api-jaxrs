package org.koushik.javabrains.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
//http://localhost:8080/webapi/messages/100/comments
public class CommentResource {
    @GET
    public String test(){
        return "new sub resource";
    }

    @GET
    @Path("/{commentId}")
    //http://localhost:8080/webapi/messages/100/comments/200
    public String test2(@PathParam("messageId") long messageID,
                        @PathParam("commentId") long commentID){
        return "Method to return comment ID = " + commentID + " - for message = " + messageID;
    }
}
