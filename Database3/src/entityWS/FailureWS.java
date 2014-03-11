package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.Failure;
import entityDAO.FailureDAO;

@Path("/failure")
@Stateless
@LocalBean
public class FailureWS {

    @EJB
    private FailureDAO failuresDao;

    @GET
    @Path("/{failureID}")
    public Failure getFailure(@PathParam("failureID") int failureID) {
        return failuresDao.getFailure(failureID);
    }
    
    @GET
    @Path("/all")
    public List<Failure> getAllFailure() {
        return failuresDao.getAllFailure();
    }
    
    @POST
    public void addFailures(List<Failure> failures) {
        failuresDao.addFailures(failures);
    }
    
}