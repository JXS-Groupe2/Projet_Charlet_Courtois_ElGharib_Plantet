package db;

import java.util.ArrayList;

class User{

    private String login, pwd, oauthToken, secretToken,pageToken;
    private boolean isLogged;

    public User(String plogin, String ppwd,String poauthToken, String psecretToken){
        login = plogin;
        pwd = ppwd;
        oauthToken=poauthToken;
        secretToken=psecretToken;
        pageToken="";
        isLogged = false;
    }

    public User(String plogin, String ppwd){
        login = plogin;
        pwd = ppwd;
        oauthToken="";
        secretToken="";
        pageToken="";
        isLogged = false;
    }

    public boolean login(String poauthToken, String psecretToken){    
        oauthToken=poauthToken;
        secretToken=psecretToken;
        isLogged=true;
        return isLogged;
    }

    public boolean logout(){    
        oauthToken="";
        secretToken="";
        isLogged=false;
        return !isLogged;
    }

    public String getLogin(){
        return login;
    }

    public String getPwd(){
        return pwd;
    }

    public String getToken(){
        return oauthToken;
    }
    public String getSecretToken(){
        return secretToken;
    }

    public String getPageToken(){
        return pageToken;
    }

    public void setPageToken(String t){
        pageToken = t;
    }
}

class Users{
    private ArrayList<User> users;//a mettre dans une db : fichier texte, ou sql

    public Users(){
        users = new ArrayList<User>();
    }

    /**
     * Return a User by name
     */
    public User getUser(String name){
        for(User e : users){
            if(e.getLogin()==name){
                return e;
            }
        }
        return new User("NOT_A_USER", "");
    }
}