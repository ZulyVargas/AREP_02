package edu.escuelaing.arem;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
//import com.github.cliftonlabs.json_simple.JsonObject;
public class SparkWebApp {

	 public static void main(String[] args) {
		 System.out.println("Initiating server... READY");
		 port(getPort());
		 get("/cos/:value", (req, res) -> {
			 res.status(200);
			 res.header("Access-Control-Allow-Origin", "*");
			 res.type("application/json");
			 //String out = "{ operation: cos, "+ "input: " +  req.params(":value") + ", output: " +Calculator.getCos((Double.valueOf(req.params(":value"))))+ "}";
			 return new Gson().toJson(Calculator.getCos((Double.valueOf(req.params(":value")))));
		 });

		 get("/exp/:value", (req, res) -> {
			 res.status(200);
			 res.header("Access-Control-Allow-Origin", "*");
			 res.type("application/json");
			 //String out = "{ operation: exp, "+ "input: " +  req.params(":value") + ", output: " +Calculator.getExp((Double.valueOf(req.params(":value"))))+ "}";
			 return new Gson().toJson(Calculator.getExp((Double.valueOf(req.params(":value")))));
		 });

	 }
	 
	 static int getPort() {
		 if (System.getenv("PORT") != null) {
		 return Integer.parseInt(System.getenv("PORT"));
		 }
		 return 4568; //returns default port if heroku-port isn't set (i.e. on localhost)
	}
}