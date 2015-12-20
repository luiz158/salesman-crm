package br.com.kproj.salesman.infrastructure.entity.location;

import br.com.kproj.salesman.infrastructure.entity.Identifiable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="countries")
@Audited
public class Country extends Identifiable {

    public static final Long BRASIL = 31l;
	/**
	 * 
	 */
	private static final long serialVersionUID = 932439980875323084L;

    @Id    
    private Long id;

	private String name;
	
	@Column(name= "bacen_code")
	private String bacenCode;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBacenCode() {
		return bacenCode;
	}
	public void setBacenCode(String bacenCode) {
		this.bacenCode = bacenCode;
	}

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
