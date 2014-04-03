package entityWS;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import loader.CountryConfig;
import loader.AccessCapabilityConfig;
import loader.FailureConfig;
import loader.MCCMNCConfig;
import loader.UserConfig;
import loader.EventCauseConfig;
import loader.ManufacturerConfig;
import loader.UEModelConfig;


@Path("/load")
@Stateless
@LocalBean
public class LoaderWS {
	
    @EJB
    private CountryConfig countryConfig;
    
    @EJB
    private FailureConfig failureConfig;
    
    @EJB
    private MCCMNCConfig mccmncConfig;
    
    @EJB
    private AccessCapabilityConfig accessCapabilityConfig;
    
    @EJB
    private UserConfig userConfig;
    
    @EJB
    private EventCauseConfig eventCauseConfig;
    
    @EJB
    private ManufacturerConfig manufacturerConfig;
    
    @EJB
    private UEModelConfig ueModelConfig;
    
    @POST
    @Path("/add")
    public void addAll() {
    	long startTime = System.nanoTime();
        countryConfig.addCountries(); //works
        mccmncConfig.addMCCMNCs(); //works
        failureConfig.addFailures(); //works
        eventCauseConfig.addEventCauses(); //works
        accessCapabilityConfig.addAccessCapabilities(); //works
        userConfig.addUsers(); //works
    	manufacturerConfig.addManufacturers(); //works
    	ueModelConfig.addUEModels(); //works
    	
        long endTime = System.nanoTime();
		
		System.out.println("Upload took " + (endTime-startTime)/1000000000 + " seconds");
    }

}
