package db;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/** Stocke les éléments récupérés par GET dans les différents drive
 *
 * Liste de Doublets ID-URI (lien symbolique)
 * @param <DbFile>
 *
 *
 */
@Path("db")
public class Db extends HashMap<Integer,DbFile>{

    static final long serialVersionUID = 1L;
	String clientId = "198375218107-ovb4dln31onm3st8qsdsrldr211t3tbl.apps.googleusercontent.com";
	String clientSecret = "YBEjnVdZJuip1YEQmZcAk_VY";
	String redirectUri = "http://localhost:8080/myapp/db/auth2-redirect";
	
    public Db(){
    	this.put(0, new DbFile("File A", "addraupif0", 1024));
    	this.put(1, new DbFile("Img A", "addraupif1", 65535));

    }
    
	/**
	 * Returns the URI where client should be redirected to to login for the 1st time
	 */
//	@SuppressWarnings("finally")
	@GET
    @Path("/auth")
    @Produces(MediaType.APPLICATION_JSON)
    public String auth() {
//    	String str = "";
    	String authtokenrequest = "https://accounts.google.com/o/oauth2/v2/auth?"
    			+"client_id="+clientId
    			+"&redirect_uri="+redirectUri
    			+"&response_type=token"
    			+"&state=state1"
    			+"&include_granted_scopes=true"
    			+"&scope=https://www.googleapis.com/auth/drive";
//    	URL url;
//		try {
//			url = new URL(authtokenrequest);
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//			
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			in.close();
//
//			//print result
//			str = response.toString();
//			System.out.println(str);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			return str;
//		}
    	return authtokenrequest;
    }
	
	@SuppressWarnings("finally")
	@GET
	@Path("/validateAuth?access_token={token}")
	public String validateAuth(@PathParam("token") String token) {
		String pageToken = "";
		String uri = "https://www.googleapis.com/oauth2/v3/tokeninfo?access_token="+token;
    	URL url;
		try {
			url = new URL(uri);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			pageToken = response.toString();
			System.out.println(pageToken);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			return pageToken;
		}
	}
	
    @GET
    @Path("/unsorted")
    @Produces(MediaType.APPLICATION_JSON)
    public String unsorted(){
    	int count = this.size();
        String r="{\n";
        for (int e : this.keySet()) {
        	--count;
        	r+=this.getFile(e).toString();
        	if(count!=0)r+=",";
        	r+="\n";
         }

        return r+"}";
    }

    @GET
    @Path("/sortedID")
    @Produces(MediaType.APPLICATION_JSON)
    public String sortedID(){
    	int count = this.size();
        String r="{\n";
        for(int i = 0;i<this.size();++i){
        	--count;
        	r+="\t\"File"+i+"\":{\n"+this.get(i).toString()+"}";
        	if(count!=0)r+=",";
        	r+="\n";
        }
        return r+"}";
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String foo(@PathParam("id") int id){
        return "{"+getFile(id)+"}";
    }
    
    public String getFile(int id) {
    	return "\n\t\"File"+id+"\":{\n"+this.get(id).toString()+"\n\t}\n";
    }

}