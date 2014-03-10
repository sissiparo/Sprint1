package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.Manufacturer;
import entityDAO.ManufacturerDAO;

@Path("/manufacturer")
@Stateless
@LocalBean
public class ManufacturerWS {

    @EJB
    private ManufacturerDAO manufacturersDao;

    @GET
    @Path("/{manufacturerID}")
    public Manufacturer getManufacturer(@PathParam("manufacturerID") int manufacturerID) {
        return manufacturersDao.getManufacturer(manufacturerID);
    }
    
    @GET
    @Path("/all")
    public List<Manufacturer> getAllManufacturer() {
        return manufacturersDao.getAllManufacturer();
    }
    
    @POST
    public void addManufacturers(List<Manufacturer> manufacturers) {
        manufacturersDao.addManufacturers(manufacturers);
    }
    
}