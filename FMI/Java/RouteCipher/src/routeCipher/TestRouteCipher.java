package routeCipher;

//We assume that the user will not enter String longer than 100 symbols
public class TestRouteCipher
{
    public static void main(String[] args)
    {
        RouteCipher cipher1 = new RouteCipher(-5),
                    cipher2 = new RouteCipher(5),
                    cipher3 = new RouteCipher(4);

        String encrypted1 = cipher1.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED"),
               encrypted2 = cipher2.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED"),
               decrypted3 = cipher3.decrypt("TIEIXTXXEAHSIHSPNTLT");

        //XTEANITROBATSYVNTEDXOEHOMEHSOESPBUI
        System.out.printf("Text: ABORT THE MISSION, YOU HAVE BEEN SPOTTED\nKey: -5\nEncrypted: %s\n\n", encrypted1);
        //ATSYVNTEDXXTEANITROBHSOESPOEHOMEIUB
        System.out.printf("Text: ABORT THE MISSION, YOU HAVE BEEN SPOTTED\nKey: 5\nEncrypted: %s\n\n", encrypted2);
        //THISISTHEPLAINTEXT
        System.out.printf("Text: TIEIXTXXEAHSIHSPNTLT\nKey: 4\nDecrypted: %s\n\n", decrypted3);
    }
}
