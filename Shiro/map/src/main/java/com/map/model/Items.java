package com.map.model;

public class Items {
    private int id;
    private int MesCount;
    private int phoCount;
    private int audCount;
    private int vidCount;

    public Items() {
    }

    public Items(int mesCount, int phoCount, int audCount, int vidCount) {
        MesCount = mesCount;
        this.phoCount = phoCount;
        this.audCount = audCount;
        this.vidCount = vidCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesCount() {
        return MesCount;
    }

    public void setMesCount(int mesCount) {
        MesCount = mesCount;
    }

    public int getPhoCount() {
        return phoCount;
    }

    public void setPhoCount(int phoCount) {
        this.phoCount = phoCount;
    }

    public int getAudCount() {
        return audCount;
    }

    public void setAudCount(int audCount) {
        this.audCount = audCount;
    }

    public int getVidCount() {
        return vidCount;
    }

    public void setVidCount(int vidCount) {
        this.vidCount = vidCount;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", MesCount=" + MesCount +
                ", phoCount=" + phoCount +
                ", audCount=" + audCount +
                ", vidCount=" + vidCount +
                '}';
    }
}
