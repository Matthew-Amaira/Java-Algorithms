public class Convertor{
    static String binaryValue = "";
    static int decimalValue = 0;
    public static void main(String[] args){
        System.out.println();
    }

    public static String decimalToBinary(int x){
        //Base Case
        if(x == 1){
            return binaryValue+"1";
        }
        //General Case
        else{
            if(x%2 != 0){ 
                return decimalToBinary(x/2)+"1";
            }else{
                return decimalToBinary(x/2)+"0";
            }
        }
    }

    public static int binaryToDecimal(String bin){
        int length = bin.length();

        //Base Case
        if(length == 1){
            int c =  Integer.parseInt(bin); 
            return c; 
        }
        //General Case
        int c = Integer.parseInt(bin.substring(0,1));
        int add = c * (int) Math.pow(2, length-1);
        ;
        return decimalValue+add+binaryToDecimal(bin.substring(1));
    }

    public static int binaryToDecimalstudy(String bin){
        int conversionValue = 1;
        for(int i=1; i<=bin.length(); i++){
            if(bin.charAt(bin.length()-i) == '1')
                decimalValue += conversionValue;
            conversionValue *=2;
        }
        return decimalValue;
    }
}
