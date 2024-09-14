package com.example.homerent.enums;

public enum Month {
    JANUARY("Jan",31),
    FEBRUARY("feb",28),
    MARCH("march",31);
    private final String shortName;
    private final int dayOfMonth;

    Month(String shortName,int dayOfMonth) {
        this.shortName = shortName;
        this.dayOfMonth = dayOfMonth;

    }
    public String getShortName(){
      return this.shortName;
    }
    public int getDayOfMonth(){
        return this.dayOfMonth;
    }
}