package entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the country database table.
 * 
 */

@NamedQuery(name = "Country.findByMCC", query = "select o from Country o where o.mcc=:mcc")

//@NamedQueries({
//		@NamedQuery(name = "Country.findByMCC", query = "select o from Country o where o.mcc=:mcc"),
//		@NamedQuery(name = "Country.countOfMCC", query = "select count(mcc) from Country"), })
@Entity
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int mcc;

	private String countryName;

	//bi-directional many-to-one association to Mccmnc
	@OneToMany(mappedBy="country")
	private Set<MCCMNC> mccmncs;

    public Country() {
    }

    public Country(int mcc, String countryName) {
		super();
		this.mcc = mcc;
		this.countryName = countryName;
	}
    
	public int getMcc() {
		return this.mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Set<MCCMNC> getMccmncs() {
		return this.mccmncs;
	}

	public void setMccmncs(Set<MCCMNC> mccmncs) {
		this.mccmncs = mccmncs;
	}
	
}