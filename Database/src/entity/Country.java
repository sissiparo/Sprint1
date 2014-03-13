package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "Country.findByMCC", query = "select o from Country o where o.mcc=:mcc"),
		@NamedQuery(name = "Country.countOfMCC", query = "select count(mcc) from Country"), })
@Entity
public class Country {
	@Id
	private int mcc;
	private String countryName;

	public Country() {

	}

	public Country(int mcc, String countryName) {
		super();
		this.mcc = mcc;
		this.countryName = countryName;
	}

	public int getMcc() {
		return mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
