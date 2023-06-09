package server;

import sample.SignUp;

import java.io.Serializable;

public class CurrentAccount extends Account implements Serializable {

    public CurrentAccount(int balance, String AccountPassword) {
        super(balance, AccountPassword);
        DataBase.printnewAccount(this);

    }

    public CurrentAccount(String AccountPassword) {
        this(0, AccountPassword);
    }

    @Override
    public int getBalance (){
        return balance;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "alias='" + alias + '\'' +
                ", balance=" + balance +
                ", AccountDateCreated=" + AccountDateCreated +
                ", AccountPassword='" + AccountPassword + '\'' +
                ", moneyTransfersList=" + moneyTransfersList +
                ", AccountNum=" + AccountNum +
                '}';
    }


}
