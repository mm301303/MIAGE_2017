import java.util.ArrayList;
import java.util.HashMap;

public class Code11Word {

    private static HashMap<Character, String> symbolsMap;
    private ArrayList<Code11Part> letters;
    static {
        symbolsMap = new HashMap<>();

        symbolsMap.put('0', "EEEEL");
        symbolsMap.put('1', "LEEEL");
        symbolsMap.put('2', "ELEEL");
        symbolsMap.put('3', "LLEEE");
        symbolsMap.put('4', "EELEL");
        symbolsMap.put('5', "LELEE");
        symbolsMap.put('6', "ELLEE");
        symbolsMap.put('7', "EEELL");
        symbolsMap.put('8', "LEELE");
        symbolsMap.put('9', "LEEEE");
        symbolsMap.put('-', "EELEE");
        symbolsMap.put('S', "EELLE");//start, stop

    }

    public Code11Word(String code11Word) {

        String checkDigit = computeCheckDigit(code11Word);
        code11Word = code11Word+checkDigit;

        code11Word = code11Word+checkDigit;
        letters =new ArrayList<>();

        code11Word = 'S'+code11Word+'S'+"";

        for(Character c : code11Word.toCharArray()){
               String valCode11 = symbolsMap.get(c);
                System.out.println(valCode11);
               char val ='/';//cas d'erreur identifiable
               for(int i=0; i<5;i++) {
                   val = valCode11.charAt(i);
                   //System.out.println(" val:"+val);
                   Code11Part cp = new Code11Part(val, i);
                   letters.add(cp);
               }
        }
    }
    //return the appropriate check digit
    private String computeCheckDigit(String code11Word) {
        String check = "null";
        if(code11Word.length()<12){
            check = computeC(code11Word);//it is a char

        }else{
            check = computeK(code11Word);

        }
        System.out.println("check = " + check);
        return check;

    }

    private String computeK(String code11Word) {
        String firstCheckDigit = computeC(code11Word);
        String secondCheckDigit = computeC(code11Word+firstCheckDigit);
        return firstCheckDigit+secondCheckDigit+"";
    }

    private String computeC(String code11Word) {
        int checkC = 0;
        int charvalue = 0;
        int realJ = 0;//Si le mot est de longueur supérieure a 10 on doit reset les poids
        for(int j=code11Word.length()-1; j>0;j--){
            char val = code11Word.charAt(j);
            if(val!='-'){
                    charvalue = Integer.parseInt(code11Word.charAt(j)+"");
                }else{
                    charvalue = 10;
                }
                realJ = (j>10)?j%10:j;

                checkC += ((realJ)*charvalue);
        }
        return ""+(checkC%11);
    }

    public ArrayList<Code11Part> getParts() {
        return letters;
    }


}
