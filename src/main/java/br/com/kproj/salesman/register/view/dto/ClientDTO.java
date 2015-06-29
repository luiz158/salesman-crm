package br.com.kproj.salesman.register.view.dto;


import br.com.kproj.salesman.infrastructure.entity.Client;
import br.com.kproj.salesman.infrastructure.entity.Company;
import br.com.kproj.salesman.infrastructure.entity.Individual;
import br.com.kproj.salesman.infrastructure.helpers.ReflectionsHelper;

public class ClientDTO extends Client {

    private static final String COMPANY = "company";
    private static final String INDIVIDUAL = "individual";

    private String type;

    private Individual individual = new Individual();

    private Company company = new Company();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Client getClient() {
        if (COMPANY.equals(this.getType())) {
            ReflectionsHelper.copyProperties(this.company, this);
            return this.company;
        } else if (INDIVIDUAL.equals(this.getType())) {
            ReflectionsHelper.copyProperties(this.individual, this);
            return this.individual;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClientDTO{");
        sb.append(", type='").append(type).append('\'');
        sb.append(", individual=").append(individual);
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }

}
