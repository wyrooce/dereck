package chixa.ir;

/**
 * Created by MORTEZA.UM on 9/8/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        //System.out.println(Parser.parseAccount(args[0],args[1],args[2]));
        System.out.println(Parser.parseAccount("3$1000;10$500;0$10000","5$1000;1;11;2","salaam"));
    }

}
