package Week2;

public class FlippingBits {
    public static void main(String[] args) {
        System.out.println(flippingBits(1));

    }
    public static long flippingBits(long n) {
        // Get the binary representation without leading zeros
        String binaryString = Long.toBinaryString(n);

        // Calculate the number of leading zeros needed
        int leadingZeros = Integer.SIZE - binaryString.length();

        // Create the binary string with leading zeros
        String result = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < leadingZeros; i++) {
            sb.append("0");
        }
        sb.append(binaryString);
        result = sb.toString();
        sb.setLength(0);

        for (char c : result.toCharArray()) {
            if (c == '0'){
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return Long.parseUnsignedLong(sb.toString(),2);
    }
}
