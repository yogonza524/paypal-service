package com.microservice.rest;

import com.microservice.beans.Credentials;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
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

        StringWriter writer = new StringWriter();
        IOUtils.copy(isr, writer);
        String output = writer.toString();

        Map<String,Object> result = new HashMap<>();
        result.put("data", output);

        return ResponseEntity.ok(result);
    }
}
