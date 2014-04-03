package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.UserEquipment;
import entityDAO.UserEquipmentDAO;

@Path("/userequipment")
@Stateless
@LocalBean
public class UserEquipmentWS {

    @EJB
    private UserEquipmentDAO userEquipmentsDao;

    @GET
    @Path("/{tac}")
    public UserEquipment getUserEquipment(@PathParam("tac") String tac) {
        return userEquipmentsDao.getUserEquipment(tac);
    }
    
    @GET
    @Path("/all")
    public List<UserEquipment> getAllUserEquipment() {
        return userEquipmentsDao.getAllUserEquipment();
    }
    
    @POST
    public void addUserEquipments(List<UserEquipment> userEquipment) {
        userEquipmentsDao.addUserEquipments(userEquipment);
    }
    
}