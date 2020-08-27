package com.zz.controller;

import com.zz.commen.JsonResult;
import com.zz.pojo.SysCar;
import com.zz.service.SysCarService;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/car")
public class SysCarController {

    @Autowired
    private SysCarService carService;
    @RequestMapping("/priceOrder")
    public JsonResult priceOrder(){
        List<SysCar> list = carService.findPriceOrder();
        JsonResult jsonResult = null;
        if(list != null){
            jsonResult = new JsonResult(1,list);
        } else {
            jsonResult = new JsonResult(0,"未找到");
        }
        return jsonResult;


    }
    @RequestMapping("/numberOrder")
    public JsonResult numberOrder(){
        List<SysCar> list = carService.findNumberOrder();

        JsonResult jsonResult = null;
        if(list != null){
            jsonResult = new JsonResult(1,list);
        } else {
            jsonResult = new JsonResult(0,"未找到");
        }
        return jsonResult;
    }   @RequestMapping("/findCar")
    public JsonResult findCar(Integer cid){
         SysCar car = carService.findCar(cid);
        System.err.println(car +"++++++++++++++++++++++++++++++++++++++++++++");
        JsonResult jsonResult = null;
        if(car != null){
            jsonResult = new JsonResult(1,car);
        } else {
            jsonResult = new JsonResult(0,"未找到");
        }
        return jsonResult;
    }



}
