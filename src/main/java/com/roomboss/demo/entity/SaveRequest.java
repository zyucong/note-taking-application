package com.roomboss.demo.entity;

public class SaveRequest {
    private String textNote;

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    public SaveRequest() {
    }

    public SaveRequest(String textNote) {
        this.textNote = textNote;
    }



    @Override
    public String toString() {
        return "SaveRequest{" +
                "textNote='" + textNote + '\'' +
                '}';
    }
}
