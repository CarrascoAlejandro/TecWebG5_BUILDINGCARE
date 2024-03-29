package ucb.buildingcare.buildingcare.util;

public class ValidatePassword {
    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("La contraseña debe tener al menos una letra minúscula");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("La contraseña debe tener al menos una letra mayúscula");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("La contraseña debe tener al menos un número");
        }
        if (!password.matches(".*[!@#$%^&*,.].*")) {
            throw new IllegalArgumentException("La contraseña debe tener al menos un caracter especial");
        }
        return true;
    }
}
