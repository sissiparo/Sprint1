package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import loader.CountryConfig;
import entities.Country;
import entityDAO.CountryDAO;

@Path("/country")
@Stateless
@LocalBean
public class CountryWS {

    @EJB
    private CountryDAO countriesDao;
    
    @EJB
    private CountryConfig config;

    @GET
    @Path("/{mcc}")
    public Country getCountry(@PathParam("mcc") int mcc) {
        return countriesDao.getCountry(mcc);
    }
    
    @GET
    @Path("/all")
    public List<Country> getAllCountry() {
        return countriesDao.getAllCountry();
    }
    
//    @POST
//    public void addCountry(Country country) {
//        countriesDao.addCountry(country);
//    }
    
    @GET
    @Path("/add/countries")
    public void addCountries() {
        config.addCountries();
    }
    
}