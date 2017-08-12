/**
 * 
 */
package com.satish;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class XUserAgentInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        HttpHeaders headers = request.getHeaders();
        headers.add("X-User-Agent", "My App v2.1");
        System.out.println("messg>>>>>>>>>>>>>>>>>>>>>>>>"+body.toString());
        System.out.println("headers added>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return execution.execute(request, body);
    }
}
