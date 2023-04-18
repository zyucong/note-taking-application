package com.roomboss.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
    // should add a status param for better functionality,
    // but it can be added when it's needed
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String textNote;
    private Long createTime;
    private Long updateTime;

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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", textNote='" + textNote + '\'' +
                '}';
    }
}
