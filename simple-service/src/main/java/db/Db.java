package db;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import javax.ws.*;


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
    	String authtokenrequest = "https://accounts.google.com/o/oauth2/v2/auth?"
    			+"client_id="+clientId
    			+"&redirect_uri="+redirectUri
    			+"&response_type=token"
    			+"&state=state1"
    			+"&include_granted_scopes=true"
    			+"&scope=https://www.googleapis.com/auth/drive";
		System.out.println("auth");
    	System.out.println(authtokenrequest);
    	return authtokenrequest;//front-end will open a tab containing this string
    }
	
	@GET
	@Path("/validateAuth/access_token={token}")
	public String validateAuth(@PathParam("token") String token) {
		String pageToken = "";
		System.out.println("validateAuth");
		String uri = "https://www.googleapis.com/oauth2/v3/tokeninfo?access_token="+token;
		System.out.println(uri);
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
		} finally {
			return pageToken;
		}
	}
	
	
	@GET
	@Path("/uploadFile")
	public void uploadFile() {
		String uri = "https://www.googleapis.com/upload/drive/v3/files?uploadType=media";
	}


	@GET
	@Path("/uploadFile/access_token={token}/uploadType={uploadType}")
	public void uploadFile(@PathParam("token") String token,@PathParam("uploadType") String uploadType) {
		System.out.println("uploadFile");
		String uri = "https://www.googleapis.com/upload/drive/v3/files";
		System.out.println(uri);

		File file = new File("img.png");
		
		Client client = ClientBuilder.newClient();
		Response entity = client.target(uri)
				.queryParam("uploadType",uploadType)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.header("Authorization","Bearer "+token)
				.post(Entity.entity(file,MediaType.APPLICATION_OCTET_STREAM),Response.class);
		
		System.out.println(entity.readEntity(String.class));
	}
	
	@GET
	@Path("/copyFile/fileID={id}/access_token={token}")
	public void copyFile(@PathParam("id") String id,@PathParam("token") String token) {
		System.out.println("copyFile");
		String uri = "https://www.googleapis.com/drive/v3/files/"+id+"/copy";
		System.out.println(uri);

		Client client = ClientBuilder.newClient();
		Response entity = client.target(uri)
				.queryParam("supportsTeamDrives",false)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.header("Authorization","Bearer "+token)
				.header("Content-Length",0)
				.post(null,Response.class);
		
		System.out.println(entity.readEntity(String.class));
	}
	
	@GET
	@Path("/deleteFile/fileID={id}/access_token={token}")
	public void deleteFile(@PathParam("id") String id,@PathParam("token") String token) {
		System.out.println("deleteFile");
		String uri = "https://www.googleapis.com/drive/v3/files/"+id;
		System.out.println(uri);

		Client client = ClientBuilder.newClient();
		String entity = client.target(uri)
				.queryParam("supportsTeamDrives",false)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.header("Authorization","Bearer "+token)
				.delete(String.class);
		
		System.out.println(entity);
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
    
    /**
     * calling this func will return the URI where you can read the JSON containing all files of the user
     */
    @GET
    @Path("/allFiles/access_token={token}")
    @Produces(MediaType.APPLICATION_JSON)
    public String allFiles(@PathParam("token") String token) {
    	String allFiles = "";
    	String get = "https://www.googleapis.com/drive/v2/files?access_token="+token;
    	System.out.println(get);
    	URL url;
		try {
			url = new URL(get);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			allFiles = response.toString();
			System.out.println(allFiles);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return allFiles;
		}
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String foo(@PathParam("id") int id){
        return "{"+getFile(id)+"}";
    }
    
    public String getFile(int id) {
    	return "\n\t\"File"+id+"\":{\n"+this.get(id).toString()+"\n\t}\n";
    }

}