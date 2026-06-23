package com.autopulse.domain;

public enum FuelType {
    BENZINA, 
    DIESEL, 
    GPL, 
    GNC, 
    ELECTRIC, 
    MILD_HIBRID, 
    HIBRID, 
    HIBRID_PLUGIN, 
    HIDROGEN,
    BENZINA_GPL, 
    BENZINA_GNC,
    NECUNOSCUT;

    public static FuelType fromRawText(String raw) {
        if (raw == null) {
            return NECUNOSCUT;
        }
        
        String normalized = raw.trim().toLowerCase();
        
        switch (normalized) {
            case "benzina":
            case "benzină":
            case "gasoline":
            case "petrol":
                return BENZINA;
                
            case "diesel":
            case "motorina":
            case "motorină":
                return DIESEL;
                
            case "gpl":
            case "lpg":
                return GPL;
                
            case "gnc":
            case "cng":
                return GNC;
                
            case "electric":
            case "electro":
                return ELECTRIC;
                
            case "mild hibrid":
            case "mild hybrid":
            case "mhev":
                return MILD_HIBRID;
                
            case "hibrid":
            case "hybrid":
            case "hev":
            case "full hibrid":
                return HIBRID;
                
            case "hibrid plugin":
            case "hibrid plug-in":
            case "hybrid plugin":
            case "phev":
            case "plug-in hybrid":
                return HIBRID_PLUGIN;
                
            case "hidrogen":
            case "hydrogen":
            case "fcev":
                return HIDROGEN;
                
            case "benzina + gpl":
            case "benzina+gpl":
            case "benzina gpl":
            case "gpl + benzina":
            case "bi-fuel gpl":
                return BENZINA_GPL;
                
            case "benzina + gnc":
            case "benzina+gnc":
            case "benzina gnc":
                return BENZINA_GNC;
                
            default:
                return NECUNOSCUT;
        }
    }
}