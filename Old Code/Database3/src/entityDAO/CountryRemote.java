package entityDAO;

import javax.ejb.Remote;

import entities.Country;

@Remote
public interface CountryRemote {
	public Country addCountry();

}
