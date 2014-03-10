package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.AccessCapability;
import entityDAO.AccessCapabilityDAO;

@Path("/accesscapability")
@Stateless
@LocalBean
public class AccessCapabilityWS {

    @EJB
    private AccessCapabilityDAO accessCapabilitysDao;

    @GET
    @Path("/{accessID}")
    public AccessCapability getAccessCapability(@PathParam("accessID") int accessID) {
        return accessCapabilitysDao.getAccessCapability(accessID);
    }
    
    @GET
    @Path("/all")
    public List<AccessCapability> getAllAccessCapability() {
        return accessCapabilitysDao.getAllAccessCapability();
    }
    
    @POST
    public void addAccessCapabilitys(List<AccessCapability> accessCapabilities) {
        accessCapabilitysDao.addAccessCapabilitys(accessCapabilities);
    }
    
}