package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.BaseData;
import entityDAO.BaseDataDAO;

@Path("/basedata")
@Stateless
@LocalBean
public class BaseDataWS {

    @EJB
    private BaseDataDAO baseDataDao;

    @GET
    @Path("/{baseDataID}")
    public BaseData getBaseData(@PathParam("baseDataID") int baseDataID) {
        return baseDataDao.getBaseData(baseDataID);
    }
    
    @GET
    @Path("/all")
    public List<BaseData> getAllBaseData() {
        return baseDataDao.getAllBaseData();
    }
    
    @POST
    public void addBaseDatas(List<BaseData> baseDatas) {
        baseDataDao.addBaseDatas(baseDatas);
    }
    
}