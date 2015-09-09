package chixa.ir;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MORTEZA.UM on 9/8/2015.
 */
public class Event {

    private String comment;
    private Date date;
    private float[][] arrayAccount;

    public Event(ArrayList<Provider> prv, ArrayList<Partaker> prt, String comment){
        date = new Date();
        getByList(prv, prt);
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

    public float[][] getBrief(){
        return null;
    }

    public void getByList(ArrayList<Provider> prov, ArrayList<Partaker> prt){
        arrayAccount = new int[prov.size()+prt.size()][2];
        int size = prov.size();
        for (int i = 0; i < size ; i++) {
            arrayAccount[i][0] = prov.get(i).id;
            arrayAccount[i][1] = prov.get(i).amount;
        }
        for (int i = 0; i < prt.size() ; i++){
            arrayAccount[i+size][0] = prt.get(i).getId();
            arrayAccount[i+size][1] = -1*prt.get(i).getAmount();
        }

    }
}
