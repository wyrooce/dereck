package chixa.ir;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by MORTEZA.UM on 9/8/2015.
 */
public class Parser {

    public static Account parseAccount(String providers, String partakers, String comment) throws ScriptException {
        String[] left = split(providers,";");
        String[] right = split(partakers, ";");

        ArrayList<Provider> outProvider = new ArrayList<Provider>();
        ArrayList<Partaker> outPartaker = new ArrayList<Partaker>();

        String[] temp;
        int finance = 0;
        float quota = 0;


        for (String part : left) {
            temp = split(part, "$");
            outProvider.add(new Provider(val(temp[0]), calc(temp[1])));
            finance += calc(temp[1]);
        }
//-------------------------------------------------------------------------------
        for (String part : right) {
            if(part.contains("*")){ //sahm dare
                temp = split(part, "*");
                outPartaker.add(new Partaker(val(temp[0]), 0, val(temp[1])));
                quota += val(temp[1]);
            }
            else if(part.contains("$")){  //pulesh malume
                temp = split(part, "$");
                outPartaker.add(new Partaker(val(temp[0]), calc(temp[1]), 0));
                finance -= calc(temp[1]);
            }
            else{  //sahme yek:mosavi
                outPartaker.add(new Partaker(val(part),0,1));
                quota += 1;
            }
        }


        for(int i = 0; i < outPartaker.size() ; i++){
            if (outPartaker.get(i).getAmount() != 0) continue;
            if (outPartaker.get(i).getQuota() != 0){
                outPartaker.get(i).setAmount(finance*(outPartaker.get(i).getQuota()/quota));
            }
        }

        //----------------------------------------------------------------
        Account acc = new Account(outProvider, outPartaker, comment);
        return  acc;
    }

    public static int calc(String expr) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return Integer.parseInt(engine.eval(expr)+"");
    }

    public static int val(String str){
        return Integer.parseInt(str);
    }

    public static int[][] toArrayAcc(ArrayList<Provider> prov, ArrayList<Partaker> prt){
        for (int i = 0; i < prov.size() ; i++) {
             if ()

        }
    }

    public static String[] split(String subject, String delimiters){
        StringTokenizer strTkn = new StringTokenizer(subject, delimiters);
        ArrayList<String> arrLis = new ArrayList<String>(subject.length());

        while(strTkn.hasMoreTokens())
            arrLis.add(strTkn.nextToken());

        return arrLis.toArray(new String[0]);
    }
}
