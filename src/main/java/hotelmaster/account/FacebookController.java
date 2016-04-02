/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.oauth.OAuthService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.context.request.RequestAttributes.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Doug
 */
@Controller
public class FacebookController {
    
    String ATTR_OAUTH_ACCESS_TOKEN = "ATTR_OAUTH_ACCESS_TOKEN";
    String ATTR_OAUTH_REQUEST_TOKEN = "ATTR_OAUTH_REQUEST_TOKEN";
    
    String API_KEY = "1529483847357548";
    String API_SECRET = "e3cf5bcc041b001fac159ff8a7518108";
    String CALLBACK_URL = "http://localhost:8084/facebook-callback"; //this url may change depending on tomcat config (mainly port)
    

    private static final Token EMPTY_TOKEN = null;

    @RequestMapping(value={"/login-facebook"}, method = RequestMethod.GET)
    public String login(WebRequest request) {

        // getting request and access token from session
        OAuth2AccessToken  accessToken = (OAuth2AccessToken) null;//request.getAttribute(ATTR_OAUTH_ACCESS_TOKEN, SCOPE_SESSION);
        if(accessToken == null) {
            // generate new request token
            OAuth20Service service = new ServiceBuilder()
                    .apiKey(API_KEY)
                    .apiSecret(API_SECRET)
                    .callback(CALLBACK_URL)
                    .build(FacebookApi.instance());
            
            request.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, EMPTY_TOKEN, SCOPE_SESSION);

            // redirect to facebook auth page
            return "redirect:" + service.getAuthorizationUrl();
        }
        return "redirect:loginSuccess";
    }

    @RequestMapping(value={"/facebook-callback"}, method = RequestMethod.GET)
    public ModelAndView callback(@RequestParam(value="code", required=false) String oauthVerifier, WebRequest request) {

        // getting request token
        
        
        OAuth20Service service = new ServiceBuilder()
                    .apiKey(API_KEY)
                    .apiSecret(API_SECRET)
                    .callback(CALLBACK_URL)
                    .build(FacebookApi.instance());
        
        //OAuthRequest requestToken = (OAuthRequest) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);

        // getting access token
        OAuth2AccessToken accessToken = service.getAccessToken(oauthVerifier);

        // store access token as a session attribute
        request.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken, SCOPE_SESSION);

        // getting user profile
        OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "https://graph.facebook.com/me", service);
        service.signRequest(accessToken, oauthRequest);
        Response oauthResponse = oauthRequest.send();
        
        //this is where facebook will throw back a JSON object to form the user object, and update the DB.
        System.out.println("***************************************************");
        System.out.println(oauthResponse.getBody());
        System.out.println("***************************************************");

        return new ModelAndView("redirect:loginSuccess");
    }
}
