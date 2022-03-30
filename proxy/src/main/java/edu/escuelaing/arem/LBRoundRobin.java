package edu.escuelaing.arem;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;


public class LBRoundRobin {
    //Srvicios
    String services1 = "http://localhost";
    String services2 = "http://localhost";

    private int currentServer = 0;
    private String[] ports = {":4567",":4567"};

    public Double getValueCos(Double number) throws UnirestException {
        String url = currentServer == 0 ? services1:services2 ;
        System.out.println("URL " + url+ports[currentServer]+"/cos/"+Double.toString(number));
        HttpResponse<String> apiResponse = Unirest.get(url+ports[currentServer]+"/cos/"+Double.toString(number)).asString();
        return Double.valueOf(apiResponse.getBody());
    }

    public Double getValueExp(Double number) throws UnirestException {
        String url = currentServer == 0 ? services1:services2 ;
        System.out.println("URL " + url+ports[currentServer]+"/exp/"+Double.toString(number));
        HttpResponse<String> apiResponse = Unirest.get(url+ports[currentServer]+"/exp/"+Double.toString(number)).asString();
        return Double.valueOf(apiResponse.getBody());
    }
    /**
     * Switches between servers.
     */
    public void changeServer(){
        currentServer=(currentServer + 1) % ports.length;
    }

}
