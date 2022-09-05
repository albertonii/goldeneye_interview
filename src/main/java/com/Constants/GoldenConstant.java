package com.Constants;
// final to prevent it from being extended
public final class GoldenConstant {

    public static final String GOLDEN_EYE_COM = "goldeneye.com";
    public static final String DOT = ".";
    public static final String AT = "@";

    public enum Offices {
        NONE,
        MILAN,
        SPAIN,
        NEW_YORK    
    }

    public enum Departments {
        NONE,
        DESIGN,
        BUSINESS,
        ADVERTISING,
        RESEARCH_AND_DEV
    }
    
    // Private constructor so it can not be instantiated
    private GoldenConstant() {
        
    }
}
