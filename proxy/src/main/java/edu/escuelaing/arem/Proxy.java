package edu.escuelaing.arem;

import com.google.gson.Gson;
import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
//import com.github.cliftonlabs.json_simple.JsonObject;
public class Proxy {

	 String services1 = null;
	 String services2 = null;
	static LBRoundRobin LBRR = new LBRoundRobin();

	public static void main(String[] args) {
		System.out.println("Initiating server... READY");
		port(getPort());
		get("/cos/:value", (req, res) -> {
			res.status(200);
			System.out.println("Entre en cos en get");
			res.status(200);
			res.type("application/json");
			String resp = String.valueOf(LBRR.getValueCos(Double.valueOf((req.params(":value")))));
			String out = "{ operation: cos, "+ "input: " +  req.params(":value") + ", output: " +resp + "}";
			LBRR.changeServer();
			return new Gson().toJson(out);
		});
		get("/exp/:value", (req, res) -> {
			res.status(200);
			System.out.println("Entre en exp en get");
			res.status(200);
			res.type("application/json");
			String resp = String.valueOf(LBRR.getValueExp(Double.valueOf((req.params(":value")))));
			String out = "{ operation: exp, "+ "input: " +  req.params(":value") + ", output: " +resp + "}";
			LBRR.changeServer();
			return new Gson().toJson(out);
		});
	}
	 static int getPort() {
		 if (System.getenv("PORT") != null) {
		 return Integer.parseInt(System.getenv("PORT"));
		 }
		 return 8080; //returns default port if heroku-port isn't set (i.e. on localhost)
	}
}