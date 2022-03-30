package edu.escuelaing.arem;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;


public class LBRoundRobin {
    //Srvicios
    String services1 = "http://ec2-54-87-7-198.compute-1.amazonaws.com:4568";
    String services2 = "http://ec2-54-80-173-136.compute-1.amazonaws.com:4567";
    String url = services1;
    private int currentServer = 0;
    //private String[] ports = {":4567",":4568"};

    public Double getValueCos(Double number) throws UnirestException {
        String url = currentServer == 0 ? services1:services2 ;
        System.out.println("URL consultada" + url+"/cos/"+Double.toString(number));
        HttpResponse<String> apiResponse = Unirest.get(url+"/cos/"+Double.toString(number)).asString();
        return Double.valueOf(apiResponse.getBody());
    }

    public Double getValueExp(Double number) throws UnirestException {
        String url = currentServer == 0 ? services1:services2 ;
        System.out.println("URL " + url+"/exp/"+Double.toString(number));
        HttpResponse<String> apiResponse = Unirest.get(url+"/exp/"+Double.toString(number)).asString();
        return Double.valueOf(apiResponse.getBody());
    }
    /**
     * Switches between servers.
     */
    public void changeServer(){
        currentServer=(currentServer + 1) % 2;
    }

}
