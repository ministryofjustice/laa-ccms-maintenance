package com.legalservices.laa.ccms.maintenance;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CCMSBetaMaintenanceController extends BaseController {

	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/* static private Logger logger = LogManager.getLogger(); */

	@Value("${title.beta}")
	private String pageTitle;

	@Autowired
	private HttpServletRequest request;

	public CCMSBetaMaintenanceController() {
		super();
	}

	/* , headers = "content-type=text/*" */
	@RequestMapping( value="/beta-unavailable" , method = RequestMethod.GET )
    public ModelAndView index() {
    	    	
    	/* output mustache parameters */   	
/*      System.out.println("params " + params());  */
        
/*    	return new ModelAndView("index", params());  */
    		Map<String,String> params = params();
    	    params.put("pageTitle", pageTitle);
        ModelAndView modelandView = new ModelAndView("index", params);
        
        String OssoUser = request.getHeader("Osso-User-Guid"); 
        logger.info("url[/beta-unavailable] "+"Osso_User = " + OssoUser);
/*        logger.trace( "Osso_User = " + OssoUser ) ; */
        
        return modelandView;
        
        
    }

}
