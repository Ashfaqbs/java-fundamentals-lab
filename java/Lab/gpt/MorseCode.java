package ChatGpt;
import java.util.HashMap;
import java.util.Map;

public class MorseCode {

    private static final HashMap<Character, String> morseMap = new HashMap<>();

    static {
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");
        morseMap.put('0', "-----");
        morseMap.put('1', ".----");
        morseMap.put('2', "..---");
        morseMap.put('3', "...--");
        morseMap.put('4', "....-");
        morseMap.put('5', ".....");
        morseMap.put('6', "-....");
        morseMap.put('7', "--...");
        morseMap.put('8', "---..");
        morseMap.put('9', "----.");
        morseMap.put('.', ".-.-.-");
        morseMap.put(',', "--..--");
        morseMap.put('?', "..--..");
        morseMap.put('!', "-.-.--");
        morseMap.put('/', "-..-.");
        morseMap.put('(', "-.--.");
        morseMap.put(')', "-.--.-");
        morseMap.put('&', ".-...");
        morseMap.put(':', "---...");
        morseMap.put(';', "-.-.-.");
        morseMap.put('=', "-...-");
        morseMap.put('+', ".-.-.");
        morseMap.put('-', "-....-");
        morseMap.put('_', "..--.-");
        morseMap.put('"', ".-..-.");
        morseMap.put('$', "...-..-");
        morseMap.put('@', ".--.-.");
        morseMap.put(' ', "/");
    }
    private static final Map<String, String> MORSE_CODE_MAP = new HashMap<String, String>();
    
    static {
        MORSE_CODE_MAP.put(".-", "A");
        MORSE_CODE_MAP.put("-...", "B");
        MORSE_CODE_MAP.put("-.-.", "C");
        MORSE_CODE_MAP.put("-..", "D");
        MORSE_CODE_MAP.put(".", "E");
        MORSE_CODE_MAP.put("..-.", "F");
        MORSE_CODE_MAP.put("--.", "G");
        MORSE_CODE_MAP.put("....", "H");
        MORSE_CODE_MAP.put("..", "I");
        MORSE_CODE_MAP.put(".---", "J");
        MORSE_CODE_MAP.put("-.-", "K");
        MORSE_CODE_MAP.put(".-..", "L");
        MORSE_CODE_MAP.put("--", "M");
        MORSE_CODE_MAP.put("-.", "N");
        MORSE_CODE_MAP.put("---", "O");
        MORSE_CODE_MAP.put(".--.", "P");
        MORSE_CODE_MAP.put("--.-", "Q");
        MORSE_CODE_MAP.put(".-.", "R");
        MORSE_CODE_MAP.put("...", "S");
        MORSE_CODE_MAP.put("-", "T");
        MORSE_CODE_MAP.put("..-", "U");
        MORSE_CODE_MAP.put("...-", "V");
        MORSE_CODE_MAP.put(".--", "W");
        MORSE_CODE_MAP.put("-..-", "X");
        MORSE_CODE_MAP.put("-.--", "Y");
        MORSE_CODE_MAP.put("--..", "Z");
        MORSE_CODE_MAP.put(".----", "1");
        MORSE_CODE_MAP.put("..---", "2");
        MORSE_CODE_MAP.put("...--", "3");
        MORSE_CODE_MAP.put("....-", "4");
        MORSE_CODE_MAP.put(".....", "5");
        MORSE_CODE_MAP.put("-....", "6");
        MORSE_CODE_MAP.put("--...", "7");
        MORSE_CODE_MAP.put("---..", "8");
        MORSE_CODE_MAP.put("----.", "9");
        MORSE_CODE_MAP.put("-----", "0");
    }
    

    public static String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String code = morseMap.get(c);
            if (code != null) {
                encoded.append(code).append(" ");
            }
        }
        return encoded.toString();
    }
    
    public static String decodeMorseCode(String encodedMessage) {
        StringBuilder sb = new StringBuilder();
        String[] words = encodedMessage.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                String character = MORSE_CODE_MAP.get(letter);
                sb.append(character);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "HELLO world";
        String morseCode = encode(text);
        System.out.println(morseCode);
        
        
        /////////////////////
        String encodedMessage = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
        String decodedMessage = decodeMorseCode(encodedMessage);
        System.out.println(decodedMessage);
        
        
    }
}

