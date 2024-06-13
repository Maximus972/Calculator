import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Calc());
    }

    public static String Calc() throws Exception {
        Pattern patternRome = Pattern.compile("([IVXCLMD]*)\\s*([-+*/])\\s*([IVXCLMD]*)");
        Pattern patternNum = Pattern.compile("([1234567890]*)\\s*([-+*/])\\s*([1234567890])");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Matcher matcherRome = patternRome.matcher(input);
        Matcher matcherNum = patternNum.matcher(input);
        boolean verifycated = VerifyingandCalcType(input, matcherRome, matcherNum);
        return verifycated ? calcRome(input, matcherRome, matcherNum) : calcInt(input, matcherRome, matcherNum);
    }

    public static boolean VerifyingandCalcType(String input, Matcher matcherRome, Matcher matcherNum) throws Exception {
        if (!matcherRome.matches() && !matcherNum.matches()) {
            throw new Exception("Неверное выражение");
        } else {
            return matcherRome.matches();
        }
    }

    public static String calcInt(String input, Matcher matcherRome, Matcher matcherNum) throws Exception {
        int Operand1 = Integer.parseInt(matcherNum.group(1));
        String Operation = matcherNum.group(2);
        int Operand2 = Integer.parseInt(matcherNum.group(3));
        switch (Operation) {
            case "+":
                return String.valueOf(Operand1 + Operand2);
            case "-":
                return String.valueOf(Operand1 - Operand2);
            case "*":
                return String.valueOf(Operand1 * Operand2);
            case "/":
                return String.valueOf(Operand1 / Operand2);
            default:
                throw new Exception("Неверное выражение");
        }
    }

    public static String calcRome(String input, Matcher matcherRome, Matcher matcherNum) throws Exception {
        int Operand1 = ConvertRometoInt(matcherRome.group(1));
        String Operation = matcherRome.group(2);
        int Operand2 = ConvertRometoInt(matcherRome.group(3));
        switch (Operation) {
            case "+":
                return ConvertInttoRome(Operand1 + Operand2);
            case "-":
                return ConvertInttoRome(Operand1 - Operand2);
            case "*":
                return ConvertInttoRome(Operand1 * Operand2);
            case "/":
                return ConvertInttoRome(Operand1 / Operand2);
            default:
                throw new Exception("Неверное выражение.");
        }
    }

    public static int ConvertRometoInt(String input) throws Exception {
        switch (input) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: throw new Exception("Неверное выражение");
        }
    }

    public static String ConvertInttoRome(int input) throws Exception {
        int thousands = input / 1000;
        int hundreds = (input - thousands * 1000) / 100;
        int tens = (input - thousands * 1000 - hundreds * 100) / 10;
        int units = input % 10;
        String stringthousands = Thousands(thousands);
        String stringhundreds = Hundreds(hundreds);
        String stringtens = Tens(tens);
        String stringunits = Units(units);
        return stringthousands + stringhundreds + stringtens + stringunits;
    }

    public static String Units(int input) throws Exception {
        switch (input) {
            case 0: return "";
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            default: throw new Exception("Неверное выражение");
        }
    }

    public static String Tens(int input) throws Exception {
        switch (input) {
            case 0: return "";
            case 1: return "X";
            case 2: return "XX";
            case 3: return "XXX";
            case 4: return "XL";
            case 5: return "L";
            case 6: return "LX";
            case 7: return "LXX";
            case 8: return "LXXX";
            case 9: return "XC";
            default: throw new Exception("Неверное выражение");
        }
    }

    public static String Hundreds(int input) throws Exception {
        switch (input) {
            case 0: return "";
            case 1: return "C";
            case 2: return "CC";
            case 3: return "CCC";
            case 4: return "CD";
            case 5: return "D";
            case 6: return "DC";
            case 7: return "DCC";
            case 8: return "DCCC";
            case 9: return "CM";
            default: throw new Exception("Неверное выражение");
        }
    }

    public static String Thousands(int input) throws Exception {
        switch (input) {
            case 0: return "";
            case 1: return "M";
            case 2: return "MM";
            case 3: return "MMM";
            default: throw new Exception("Неверное выражение");
        }
    }
}