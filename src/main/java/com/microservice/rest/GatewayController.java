package com.microservice.rest;

import com.microservice.beans.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GatewayController {

    @Autowired
    private Credentials credentials;

    @RequestMapping(value = "setExpressCheckout", method= RequestMethod.GET)
    public ResponseEntity<Map> setExpressCheckout() throws IOException {

        System.out.println("Running script");

        ProcessBuilder pb = new ProcessBuilder("bash", "./scripts/setExpressCheckout.sh");

        Map<String, String> env = pb.environment();
        env.put("PAYPAL_VERSION", "56");
        env.put("PAYPAL_USERNAME", credentials.getUsername());
        env.put("PAYPAL_PASSWORD", credentials.getPassword());

        Process p = pb.start();
        InputStreamReader isr = new InputStreamReader(p.getInputStream());
        char[] buf = new char[1024];
        while (isr.read(buf) != -1) {
            System.out.println(buf);
        }

        return ResponseEntity.ok(new HashMap());
    }
}
