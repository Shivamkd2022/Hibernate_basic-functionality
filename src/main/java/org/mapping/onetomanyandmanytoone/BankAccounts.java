package org.mapping.onetomanyandmanytoone;

import javax.persistence.*;

@Entity
public class BankAccounts
{
    @Id
    @Column(name="account_no")
    private int accountNo;
    private String bankName;
    @ManyToOne
   // @JoinColumn(name="person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



    public BankAccounts() {
    }

    public BankAccounts(int accountNo, String bankName) {
        this.accountNo = accountNo;
        this.bankName = bankName;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
