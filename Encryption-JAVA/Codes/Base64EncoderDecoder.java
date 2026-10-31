public class Base64EncoderDecoder {

	// Base64 alphabet
    private static final char[] BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    // Encode a string to Base64
    public static String encode(String input) {
        byte[] bytes = input.getBytes();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i += 3) {
            int b = (bytes[i] & 0xFF) << 16;
            if (i + 1 < bytes.length) {
                b |= (bytes[i + 1] & 0xFF) << 8;
            }
            if (i + 2 < bytes.length) {
                b |= bytes[i + 2] & 0xFF;
            }
            sb.append(BASE64_ALPHABET[(b >> 18) & 0x3F]);
            sb.append(BASE64_ALPHABET[(b >> 12) & 0x3F]);
            sb.append(i + 1 < bytes.length ? BASE64_ALPHABET[(b >> 6) & 0x3F] : '=');
            sb.append(i + 2 < bytes.length ? BASE64_ALPHABET[b & 0x3F] : '=');
        }

        return sb.toString();
    }

    // Decode a Base64 string to a string
    public static String decode(String input) {
        byte[] bytes = new byte[input.length() * 3 / 4];
        int index = 0;

        for (int i = 0; i < input.length(); i += 4) {
            int b = 0;
            for (int j = 0; j < 4; j++) {
                b <<= 6;
                if (i + j < input.length()) {
                    int pos = getBase64AlphabetIndex(input.charAt(i + j));
                    if (pos >= 0) {
                        b |= pos;
                    }
                }
            }
            bytes[index++] = (byte) ((b >> 16) & 0xFF);
            if (i + 2 < input.length() && input.charAt(i + 2) != '=') {
                bytes[index++] = (byte) ((b >> 8) & 0xFF);
            }
            if (i + 3 < input.length() && input.charAt(i + 3) != '=') {
                bytes[index++] = (byte) (b & 0xFF);
            }
        }

        return new String(bytes, 0, index);
    }

    // Get the index of a character in the Base64 alphabet
    private static int getBase64AlphabetIndex(char c) {
        for (int i = 0; i < BASE64_ALPHABET.length; i++) {
            if (BASE64_ALPHABET[i] == c) {
                return i;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		String input = "Ashfaq";

		System.out.println("Input string: " + input);

		// Encode the input string
		String encodedString = encode(input);
		System.out.println("Encoded string: " + encodedString);

		// Decode the encoded string
		String decodedString = decode(encodedString);
		System.out.println("Decoded string: " + decodedString);
		
	}
}




o/p

Input string: Ashfaq
Encoded string: QXNoZmFx
Decoded string: Ashfaq

