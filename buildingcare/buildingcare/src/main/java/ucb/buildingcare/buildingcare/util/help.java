package ucb.buildingcare.buildingcare.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class help {

    public byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    public String HashWithSalt(String password, byte[] salt){
        try{
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            sha.update(salt);
            byte [] digest =sha.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();

            for(byte b : digest){
                hexString.append(String.format("%02x",b));
            }

            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);

        }
    }
    public static void main(String[] args) {
        help h = new help();
        byte[] salt1 = h.getSalt();
        byte[] salt2 = h.getSalt();

        String hashedPassword1 = h.HashWithSalt("1234", salt1);
        String hashedPassword2 = h.HashWithSalt("1234", salt2);
        System.out.println(hashedPassword1);
        System.out.println(hashedPassword2);

        System.out.println(hashedPassword1.equals(hashedPassword2)); // Debería imprimir true

    }
    
}