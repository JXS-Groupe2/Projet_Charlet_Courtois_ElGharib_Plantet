package db;

public class DbFile{

    String name;//title sur google drive 
    String URI;//downloadUrl sur google drive 
    long size;//fileSize sur google drive 

    public DbFile(String name, String URI, long size){
        this.name=name;
        this.URI=URI;
        this.size=size;
    }

    @Override
    public String toString(){
    	return "\t\t\"Name\":\""+name+"\",\n\t\t\"URI\":\""+URI+"\",\n\t\t\"size\":\""+size+"o\"";
    }
}