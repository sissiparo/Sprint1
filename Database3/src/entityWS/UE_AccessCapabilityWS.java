package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.UE_AccessCapability;
import entityDAO.UE_AccessCapabilityDAO;

@Path("/ue_accesscapability")
@Stateless
@LocalBean
public class UE_AccessCapabilityWS {

    @EJB
    private UE_AccessCapabilityDAO ue_accessCapabilitysDao;

    @GET
    @Path("/{userEquipID}")
    public UE_AccessCapability getUE_AccessCapability(@PathParam("userEquipID") String userEquipID) {
        return ue_accessCapabilitysDao.getUE_AccessCapability(userEquipID);
    }
    
    @GET
    @Path("/all")
    public List<UE_AccessCapability> getAllUE_AccessCapability() {
        return ue_accessCapabilitysDao.getAllUE_AccessCapability();
    }
    
    @POST
    public void addUE_AccessCapabilitys(List<UE_AccessCapability> ue_accessCapabilities) {
        ue_accessCapabilitysDao.addUE_AccessCapabilitys(ue_accessCapabilities);
    }
    
}