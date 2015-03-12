package com.example.zhangshiyue.meber;

/**
 * Created by zhangshiyue on 15-3-11.
 */
public class NearByEvent {
    private String Id;
    private String description;
    private String location;

    public NearByEvent(){

    }

    public NearByEvent(String Id, String location, String description){
         this.Id = Id;
        this.location=location;
        this.description =description;
    }
    public String getId(){
        return this.Id;
    }
    public String getLocation(){
        return this.location;
    }
    public String getDescription(){
        return this.description;
    }
    public void setId(String id){
        this.Id = id;
    }
    public void setLocation(String location){
        this.location =location;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
