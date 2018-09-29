package at.sadra.apps.season5.objects;

import java.io.Serializable;

public class E04Music  implements Serializable{

    private String singerName;
    private String songName;
    private int view;
    private int like;
    private int comment;
    private String date;
    private int picId;

    public E04Music() {
    }

    public E04Music(String singerName, String songName, int view, int like, int comment, String date, int picId) {
        this.singerName = singerName;
        this.songName = songName;
        this.view = view;
        this.like = like;
        this.comment = comment;
        this.date = date;
        this.picId = picId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    @Override
    public String toString() {
        return "E04Music{" +
                "singerName='" + singerName + '\'' +
                ", songName='" + songName + '\'' +
                ", view=" + view +
                ", like=" + like +
                ", comment=" + comment +
                ", date='" + date + '\'' +
                ", picId=" + picId +
                '}';
    }
}
