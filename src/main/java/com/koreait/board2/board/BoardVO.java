package com.koreait.board2.board;

public class BoardVO {
    private String title;
    private String ctnt;
    private int writer;
    private int iboard;
    private String rdt;
    private String mdt;
    private String writerNm;

    public String getWriterNm() {return writerNm;}
    public void setWriterNm(String writerNm) {this.writerNm = writerNm;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getCtnt() {return ctnt;}
    public void setCtnt(String ctnt) {this.ctnt = ctnt;}

    public int getWriter() {return writer;}
    public void setWriter(int writer) {this.writer = writer;}

    public int getIboard() {return iboard;}
    public void setIboard(int iboard) {this.iboard = iboard;}

    public String getRdt() {return rdt;}
    public void setRdt(String rdt) {this.rdt = rdt;}

    public String getMdt() {return mdt;}
    public void setMdt(String mdt) {this.mdt = mdt;}
}
