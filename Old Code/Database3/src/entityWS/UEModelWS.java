package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.UEModel;
import entityDAO.UEModelDAO;

@Path("/uemodel")
@Stateless
@LocalBean
public class UEModelWS {

    @EJB
    private UEModelDAO ueModelsDao;

    @GET
    @Path("/{modelId}")
    public UEModel getUEModel(@PathParam("modelId") int modelId) {
        return ueModelsDao.getUEModel(modelId);
    }
    
    @GET
    @Path("/all")
    public List<UEModel> getAllUEModel() {
        return ueModelsDao.getAllUEModel();
    }
    
    @POST
    public void addUEModels(List<UEModel> ueModels) {
        ueModelsDao.addUEModels(ueModels);
    }
    
}