package com.autopulse.domain;

public enum SellerType {
    PROFESIONIST, PRIVAT, NECUNOSCUT;
    public static SellerType fromRawText(String raw){
        if (raw == null) 
            return NECUNOSCUT;
        String normalized= raw.trim().toLowerCase();
        switch (normalized) {
            case "profesionist":
                    return PROFESIONIST;
            case "privat":
                return PRIVAT;
            default:
                return NECUNOSCUT;
        }
    }
}
