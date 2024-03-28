package ucb.buildingcare.buildingcare.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class BuildingcareHash {
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
    
}
