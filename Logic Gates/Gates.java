public class Gates {

    public static boolean NOT(boolean b1){
        return !b1;
    }

    public static boolean AND(boolean b1,boolean b2) {
        return b1 & b2;
    }
    
    public static boolean OR(boolean b1,boolean b2){
        return b1 | b2;
    }

    public static boolean XOR(boolean b1, boolean b2){
        if(NAND(b1,b2)){
            return OR(b1,b2);
        }else{
            return false;
        }
    }

    public static boolean XNOR(boolean b1, boolean b2){
        return NOT(XOR(b1,b2));
    }

    public static boolean NAND(boolean b1,boolean b2) {
        return NOT(AND(b1,b2));
    }

    public static boolean NOR(boolean b1,boolean b2){
        return NOT(OR(b1,b2));
    }
}
