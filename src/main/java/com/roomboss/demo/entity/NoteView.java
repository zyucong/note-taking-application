package com.roomboss.demo.entity;

public class NoteView {
    private int id;
    private String textNote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    @Override
    public String toString() {
        return "NoteView{" +
                "id=" + id +
                ", textNote='" + textNote + '\'' +
                '}';
    }

    public NoteView() {}

    private NoteView(NoteViewBuilder builder) {
        this.id = builder.id;
        this.textNote = builder.textNote;
    }

    public static class NoteViewBuilder {
        private int id;
        private String textNote;

        public NoteViewBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public NoteViewBuilder setTextNote(String textNote) {
            this.textNote = textNote;
            return this;
        }

        public NoteView build() {
            return new NoteView(this);
        }
    }
}
