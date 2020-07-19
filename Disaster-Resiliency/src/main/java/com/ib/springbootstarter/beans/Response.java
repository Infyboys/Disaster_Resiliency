package com.ib.springbootstarter.beans;
import java.util.ArrayList;
import java.util.List;
public class Response
{
    private List<Docs> docs;

    private Meta meta;

    public void setDocs(List<Docs> docs){
        this.docs = docs;
    }
    public List<Docs> getDocs(){
        return this.docs;
    }
    public void setMeta(Meta meta){
        this.meta = meta;
    }
    public Meta getMeta(){
        return this.meta;
    }
	@Override
	public String toString() {
		return "Response [docs=" + docs + ", meta=" + meta + "]";
	}
}
