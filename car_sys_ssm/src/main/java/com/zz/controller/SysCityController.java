package com.zz.controller;

import com.zz.commen.JsonResult;
import com.zz.pojo.SysCity;
import com.zz.service.SysCityService;
import com.zz.vo.VCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/city")
public class SysCityController {
    @Autowired
    private SysCityService cityService;
    @RequestMapping("findAllCity")
    public JsonResult findALlCity(Integer pid){

        JsonResult jsonResult =null;

        List<SysCity> list = cityService.findAllCity(pid);
        System.err.println(list+"==========================");
        if (list != null){
            jsonResult = new JsonResult(1,list);
        } else {
            jsonResult = new JsonResult(0,"未找到");
        }
        return jsonResult;
    }
    @RequestMapping("/findCity")
    public JsonResult findCity(Integer getid,Integer backid){
        JsonResult jsonResult = null;
        VCity vCity = cityService.findCity(getid,backid);
        System.err.println(vCity + "==========================-------------------->>>>>>>>>>>>");
        if (vCity != null){
            jsonResult = new JsonResult(1,vCity);

        } else {
            jsonResult = new JsonResult(0,"未找到");
        }
        return jsonResult;
    }


}
