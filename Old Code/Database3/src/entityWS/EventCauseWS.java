package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.EventCause;
import entityDAO.EventCauseDAO;

@Path("/eventcause")
@Stateless
@LocalBean
public class EventCauseWS {

    @EJB
    private EventCauseDAO eventCausesDao;

    @GET
    @Path("/{eventcauseCode}")
    public EventCause getEventCause(@PathParam("eventcauseCode") int eventcauseCode) {
        return eventCausesDao.getEventCause(eventcauseCode);
    }
    
    @GET
    @Path("/all")
    public List<EventCause> getAllEventCause() {
        return eventCausesDao.getAllEventCause();
    }
    
    @POST
    public void addEventCauses(List<EventCause> eventCauses) {
        eventCausesDao.addEventCauses(eventCauses);
    }
    
}