package chixa.ir;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MORTEZA.UM on 9/8/2015.
 */
public class Account {
    private ArrayList<Provider> provider;
    private ArrayList<Partaker> partaker;
    private String comment;
    private Date date;
    private int[][] briefAcc;

    public Account(ArrayList<Provider> prv, ArrayList<Partaker> prt, String comment){
        date = new Date();
        provider = prv;
        partaker = prt;
        this.comment = comment;
    }

    public String toString(){
        String out = "";

        for (Provider provider1 : provider) {
            out += provider1.id;
            out += "$";
            out += provider1.amount;
            out += "\n";
        }
        out += "#\n";

        for (Partaker partaker1 : partaker) {
            out += partaker1.getId();
            out += "$";
            out += partaker1.getAmount();
            out += "\n";
        }
        out += "-------------------" + comment +"---";
        return out;
    }


}
