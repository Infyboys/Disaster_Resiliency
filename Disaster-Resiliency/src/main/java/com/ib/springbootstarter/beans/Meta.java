package com.ib.springbootstarter.beans;
public class Meta
{
    private int hits;

    private int offset;

    private int time;

    public void setHits(int hits){
        this.hits = hits;
    }
    public int getHits(){
        return this.hits;
    }
    public void setOffset(int offset){
        this.offset = offset;
    }
    public int getOffset(){
        return this.offset;
    }
    public void setTime(int time){
        this.time = time;
    }
    public int getTime(){
        return this.time;
    }
	@Override
	public String toString() {
		return "Meta [hits=" + hits + ", offset=" + offset + ", time=" + time + "]";
	}
}
