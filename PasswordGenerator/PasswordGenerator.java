public class PasswordGenerator{
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(generate());
            //System.out.println(generateVersion2());
        }
    }

    public static String generate(){
        String password="";
        for(int i=0;i<8;i++){
            int c = (int) Math.round(Math.random()*61);
            if(c < 10){
                c += 48;
            }
            else if(c >= 10 && c < 36){
                c += 55;
            }
            else if(c >= 36 && c <62){
                c += 61;
            }
            password += (char) c;
        }
        return password;
    }

    public static String generateVersion2(){
        String password="";
        for(int i=0;i<8;i++){
            int temp = (int) Math.round(Math.random()*2);
            switch(temp){
                case 0:
                password += (char) Math.round(Math.random()*(122-97)+97);//a-z
                break;

                case 1:
                password += (char) Math.round(Math.random()*(90-65)+65);//A-Z
                break;

                case 2:
                password += (char) Math.round(Math.random()*(57-48)+48);//0-9
                break;
            }
        }
        return password;
    }
}