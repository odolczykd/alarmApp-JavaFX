package com.example.projekt2_budzikjavafx;

import java.util.List;

/*** Klasa pomocnicza przechowująca informacje o alarmach ***/
public class Alarm {
    String name;
    int hr, min;
    String weekDays;
    boolean repeat;
    int volume;

    public Alarm(String name, int hr, int min, String weekDays, boolean repeat, int volume) {
        this.name = name;
        this.hr = hr;
        this.min = min;
        this.weekDays = weekDays;
        this.repeat = repeat;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String weekDays) {
        this.weekDays = weekDays;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String write(){
        return name + " (" + (hr<10 ? "0"+hr : hr) + ":" + (min<10 ? "0"+min : min) + ")" + '\n'
                    + weekDays + (repeat ? "; powtarzaj" : "") + "; głośność: " + volume + "%" + "\n\n";
    }
}
