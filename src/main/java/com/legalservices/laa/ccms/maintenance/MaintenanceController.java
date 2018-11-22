package com.legalservices.laa.ccms.maintenance;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MaintenanceController extends BaseController {

	final static Logger logger = LoggerFactory.getLogger(MaintenanceController.class);

	@Value("${title.planned}")
	private String plannedPageTitle;
	
	@Value("${title.unplanned}")
	private String unplannedPageTitle;
	
	@Value("${heading.planned}")
	private String plannedHeading;
	
	@Value("${heading.unplanned}")
	private String unplannedHeading;
	
	@Value("${service.status.url}")
	private String serviceStatusUrl;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = {"/planned","/planned/**"}, method = RequestMethod.GET)
	public String planned(Model model) {
		addParams(model);
		model.addAttribute("pageTitle", plannedPageTitle);
		model.addAttribute("heading",plannedHeading);
		model.addAttribute("serviceStatusUrl",serviceStatusUrl);
		model.addAttribute("maintenance-type", "planned");
		String ossoUser = request.getHeader("Osso-User-Guid");
		String proxyRemoteUser = request.getHeader("Proxy-Remote-User");
		logger.info("url[/planned] "+"Osso_User = " + ossoUser+ "Proxy-Remote-User = "+proxyRemoteUser );
		/* logger.trace( "Osso_User = " + OssoUser ) ; */

		return "planned";
	}

	@RequestMapping(value = {"/unplanned","/unplanned/**"}, method = RequestMethod.GET)
	public String unplanned(Model model) {
		addParams(model);
		model.addAttribute("pageTitle", unplannedPageTitle);
		model.addAttribute("heading",unplannedHeading);
		model.addAttribute("serviceStatusUrl",serviceStatusUrl);
		model.addAttribute("maintenance-type", "unplanned");
		String ossoUser = request.getHeader("Osso-User-Guid");
		String proxyRemoteUser = request.getHeader("Proxy-Remote-User");
		logger.info("url[/unplanned] "+"Osso_User = " + ossoUser + "Proxy-Remote-User = "+proxyRemoteUser );
		/* logger.trace( "Osso_User = " + OssoUser ) ; */

		return "unplanned";
	}
}
