import java.io.*;
import java.net.*;
import java.util.*;
import nl.bsn.validator.BsnValidator;

public class BsnWebService {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        BsnValidator validator = new BsnValidator();
        System.out.println("BSN Validator Service Starting...");
        System.out.println("Service is running on port 8080");
        
        while (true) {
            Socket client = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            
            String request = in.readLine();
            if (request != null && request.contains("/validate/")) {
                String bsn = request.substring(request.indexOf("/validate/") + 10).split(" ")[0];
                boolean isValid = validator.isValid(bsn);
                out.println("HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\n\r\n" + isValid);
            } else {
                out.println("HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\n\r\nBSN Validator Service - Use /validate/{bsn}");
            }
            client.close();
        }
    }
}
