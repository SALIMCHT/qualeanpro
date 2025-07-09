package com.qualeanpro.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // Générer un hash bcrypt à partir du mot de passe clair
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    // Vérifier que le mot de passe clair correspond au hash
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        if (hashedPassword == null || !hashedPassword.startsWith("$2a$")) {
            throw new IllegalArgumentException("Invalid hash provided for comparison");
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
