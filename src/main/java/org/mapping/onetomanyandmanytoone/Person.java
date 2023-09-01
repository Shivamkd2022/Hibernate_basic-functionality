package org.mapping.onetomanyandmanytoone;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person
{
    @Id
    @Column(name="person_id")
    private int personId;
    private String name;
    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
   // @JoinColumn(name="account_id")
    private List<BankAccounts> bankAccountsList;

    public Person() {
    }

    public Person(int personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public List<BankAccounts> getBankAccountsList() {
        return bankAccountsList;
    }

    public void setBankAccountsList(List<BankAccounts> bankAccountsList) {
        this.bankAccountsList = bankAccountsList;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
