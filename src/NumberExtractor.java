import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// created related folder before execute . ex->
// 71,72
public class NumberExtractor {
    private static Scanner scanner = new Scanner(System.in);
    private static FileWriter fileWriter;
    public static void main(String[] args) {
        System.out.print("1. 070 Mobitel\t\t");
        System.out.print("2. 071 Mobitel\t\t");
        System.out.println("3. 077 Dialog");
        System.out.print("4. 076 Dialog\t\t");
        System.out.print("5. 074 Dialog\t\t");
        System.out.println("6. 078 Hutch");
        System.out.print("7. 072 Etisalat\t\t");
        System.out.print("8. 075 Airtel\t\t");
        System.out.print(">");
        int in = scanner.nextInt();
        if(in==1) temp("70");
        else if(in==2) temp("71");
        else if(in==3) temp("77");
        else if(in==4) temp("76");
        else if(in==5) temp("74");
        else if(in==6) temp("78");
        else if(in==7) temp("72");
        else if(in==8) temp("75");
        else System.out.println("Invalid Input!");
    }

    private static void temp(String code){// code = 71  path = Mobitel
        int i = 1000000;
        while(i!=10000000) {
            try {
                fileWriter = new FileWriter(code+"\\0"+code+i+ "-" + "0"+code+(i+10000)+".vcf");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(int j=i;j<i+10000;j++){
                writer(code,j);
            }
            i += 10000;
            try{
                fileWriter.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writer(String code,int number){//code = 70
        String a = "BEGIN:VCARD\nN:;0"+code+number+";;;\nFN:"+number+"\nTEL;CELL:+94"+code+number+"\nEND:VCARD\n";
        try {
            fileWriter.write(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
