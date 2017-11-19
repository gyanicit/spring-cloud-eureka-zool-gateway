package com.netflixeZool.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter {
	  //private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
	  @Override
	  public String filterType() {
	    return "pre";
	  }
	  @Override
	  public int filterOrder() {
	    return 1;
	  }
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	  @Override
	  public Object run() {
	    RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    HttpServletResponse response = ctx.getResponse();
	    //log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    System.out.println(request.getMethod()+""+request.getRequestURL().toString());
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    return null;
	  }
	}
