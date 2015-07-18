package br.com.kproj.salesman.infrastructure.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


@Entity
@Table(name = "clients")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)

public abstract class Client extends Identifiable {

    @NotNull
    @Size(min = 2, max = 30, message = "company.name")
    private String name;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "client")
    protected List<Contact> contacts;


    public Client() {
        super();
    }

    public Client(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(getId());
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
