package com.zz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz.commen.JsonResult;
import com.zz.pojo.SysOrder;
import com.zz.pojo.SysUser;
import com.zz.service.SysOrderService;
import com.zz.utils.StrUtils;
import com.zz.vo.VOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class SysOrderController {
    @Autowired
    private SysOrderService orderService;

    @ResponseBody
    @RequestMapping("/findAllOrder")
    public Map<String,Object> findAllOrder(Integer page, Integer limit, HttpServletRequest request, SysUser user){
        user  = (SysUser) request.getSession().getAttribute(StrUtils.LOGIN_USER);
        System.out.println(user+"这是order里面取到的user值");

        PageHelper.startPage(page,limit);
        List<VOrder> list = orderService.findAllOrder(user.getId());
        PageInfo<VOrder> pageInfo = new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;

    }
    @ResponseBody
    @RequestMapping("/deleteById")
    public int deleteById(Integer id){
        int i = orderService.deleteById(id);
        return i;
    }
    @ResponseBody
    @RequestMapping("/addOrder")
    public JsonResult addOrder(HttpServletRequest request,Integer cid,Integer getid, Integer backid, String oprice){
        SysUser user = (SysUser) request.getSession().getAttribute(StrUtils.LOGIN_USER);
       int i = orderService.addOrder(user.getId(),cid,getid,backid,oprice);
        JsonResult jsonResult =null;
        if (user == null){
            jsonResult = new JsonResult(0,"未登录");
        }else {
            if (i>0){
                jsonResult = new JsonResult(1,i);
            } else {
                jsonResult = new JsonResult(0,"添加失败");
            }
        }
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/deleteOrders")
    public String deleteOrders(Integer[] ids){
        int i = orderService.deleteOrders(ids);
        System.err.println(i+"+++++++++++++++++++++++++++++++++++++++++++++++++===============");
        return "ok";
    }



}
