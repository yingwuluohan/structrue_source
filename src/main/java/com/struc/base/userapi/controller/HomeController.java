package com.struc.base.userapi.controller;



import com.struc.base.framework.annotation.*;
import com.struc.base.framework.webmvc.FLModelAndView;
import com.struc.base.userapi.modle.Param;
import com.struc.base.userapi.services.IModifyService;
import com.struc.base.userapi.services.IQueryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@FLController
@FLRequestMapping("/web")
public class HomeController {

    @FLAutowired
    IQueryService queryService;

    @FLAutowired
    IModifyService modifyService;


    @FLRequestMapping("/q")
    public FLModelAndView query(HttpServletRequest request, HttpServletResponse response,
                                @FLRequestParam("name") String name){
        String result = queryService.query(name);
//		System.out.println(result);
        Map mapBody = new HashMap();
        mapBody.put("data","this is a data set from controller");
        mapBody.put("token","beautifull token set here");
        FLModelAndView mv = new FLModelAndView("first.html",mapBody);
        return mv;
//        return out(response,result);
    }
    @FLRequestMapping("/add")
    public FLModelAndView addParm(HttpServletRequest request, HttpServletResponse response,
                                  @ModelAttribute("param") Param param){

        FLModelAndView mv = new FLModelAndView("first.html", null );
        return mv;
//        return out(response,result);
    }



    private String out(HttpServletResponse resp, String str){
        try {
            resp.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
