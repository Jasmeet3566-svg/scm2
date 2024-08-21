package com.scm.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {

    public static void removeMesage(){
        //object of session
    try{HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    session.removeAttribute("message");}
    catch(Exception e){
        System.out.println("error in session remove "+e);
        e.printStackTrace();
    }


    }
}
