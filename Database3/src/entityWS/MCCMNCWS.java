package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.MCCMNC;
import entityDAO.MCCMNCDAO;

@Path("/mccmnc")
@Stateless
@LocalBean
public class MCCMNCWS {

    @EJB
    private MCCMNCDAO mccmncsDao;

    @GET
    @Path("/{mccmncID}")
    public MCCMNC getMCCMNC(@PathParam("mccmncID") int mccmncID) {
        return mccmncsDao.getMCCMNC(mccmncID);
    }
    
    @GET
    @Path("/all")
    public List<MCCMNC> getAllMCCMNC() {
        return mccmncsDao.getAllMCCMNC();
    }
    
    @POST
    public void addMCCMNCs(List<MCCMNC> mccmncs) {
        mccmncsDao.addMCCMNCs(mccmncs);
    }
    
}