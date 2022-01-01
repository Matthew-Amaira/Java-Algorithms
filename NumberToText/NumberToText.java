import java.util.Scanner;
class NumberToText{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number");
        int n = input.nextInt();
        if(n<10 && n >= 0 ){
            System.out.println(small(n));
        }else if(n>=10 && n<20){
            System.out.println(medium(n));
        }else if(n>=20 && n<100){
            System.out.println(functionTens(n));
        }else if(n>=100 && n<1000){
             System.out.println(functionsHundreds(n));
        }else if(n>= 1000 && n<10000){
            int m = n/1000;
            int o = n%1000;
            String answer = small(m) + "thousand";
            if(o != 0){
                answer += " and "+ functionsHundreds(o);
            }
            System.out.println(answer);
        }
    }

    public static String small(int n){
        switch(n){
            case 0:
            return "zero";
            case 1:
            return "one ";
            case 2:
            return "two ";
            case 3:
            return "three ";
            case 4:
            return "four ";
            case 5:
            return "five ";
            case 6:
            return "six ";
            case 7:
            return "seven ";
            case 8:
            return "eight ";
            case 9:
            return "nine ";
            default:
            return "";
        }
    }

    public static String medium(int n) {
        switch(n){
            case 10:
            return "ten";
            case 11:
            return "eleven";
            case 12:
            return "twelve";
            case 13:
            return "thirteen";
            case 14:
            return "fourteen";
            case 15:
            return "fifteen";
            case 16:
            return "sixteen";
            case 17:
            return "seventeen";
            case 18:
            return "eighteen";
            case 19:
            return "nineteen";
            default:
            return "";
        }
    }

    public static String tens(int n) {
        switch(n){
            case 2:
            return "twenty ";
            case 3:
            return "thirty ";
            case 4:
            return "fourty ";
            case 5:
            return "fifty ";
            case 6:
            return "sixty ";
            case 7:
            return "seventy ";
            case 8:
            return "eighty ";
            case 9:
            return "ninety ";
            default:
            return "";
        }
    }

    public static String functionTens(int n){
        int m = n/10;
        int o = n%10;
        String answer = tens(m);
        if(o != 0){
            answer += small(o);
        }
        return answer;
    }

    public static String functionsHundreds(int n){
        int m = n/100;
            int o = n%100;
            String answer = small(m) + "hundred";
            if(o != 0){
                answer += " and "+ functionTens(o);
            } 
            return answer;
    }
}