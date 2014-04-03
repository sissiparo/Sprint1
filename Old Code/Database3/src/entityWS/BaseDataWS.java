package entityWS;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.BaseData;
import entities.CellTable;
import entityDAO.BaseDataDAO;

@Path("/basedata")
@Stateless
@LocalBean
public class BaseDataWS {

    @EJB
    private BaseDataDAO baseDataDao;

    @GET
    @Path("/{baseDataID}")
    @Produces("application/json")
    public BaseData getBaseData(@PathParam("baseDataID") int baseDataID) {
        return baseDataDao.getBaseData(baseDataID);
    }
    
    @GET
    @Path("/userStory4/{imsi}")
    @Produces("application/json")
    public List<BaseData> userStory4(@PathParam("imsi") String imsi) {
        return baseDataDao.userStory4(imsi);
    }
    
    @GET
    @Path("/userStory5/{imsi}/{startDate}/{endDate}")
    @Produces("application/json")
    public List<BaseData> userStory5(@PathParam("imsi") String imsi, 
    		@PathParam("startDate") Date startDate, @PathParam("endDate") Date endDate) {
        return baseDataDao.userStory5(imsi, startDate, endDate);
    }
    
    @GET
    @Path("/userStory6/{imsi}")
    @Produces("application/json")
    public List<BaseData> userStory6(@PathParam("imsi") String imsi) {
        return baseDataDao.userStory6(imsi);
    }
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<BaseData> getAllBaseData() {
        return baseDataDao.getAllBaseData();
    }
    
    @GET
    @Path("/imsi/all")
    @Produces("application/json")
    public List<BaseData> getImsiBaseData() {
        return baseDataDao.getImsiBaseData();
    }
    
    @POST
    public void addBaseDatas(List<BaseData> baseDatas) {
        baseDataDao.addBaseDatas(baseDatas);
    }

}