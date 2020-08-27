package com.zz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz.commen.JsonResult;
import com.zz.pojo.SysUser;
import com.zz.service.SysUserService;
import com.zz.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping("/login")
    public JsonResult login(SysUser sysUser, HttpServletRequest request) {
        SysUser login = sysUserService.login(sysUser);
        System.out.println(login+ "这是登陆页面存的login值");
        JsonResult jsonResult = null;
        if (login != null) {
            request.getSession().setAttribute(StrUtils.LOGIN_USER, login);
            jsonResult = new JsonResult(1, login);
        } else {
            jsonResult = new JsonResult(0, "用户名或密码错误");
        }

        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/checkLogin")
    public JsonResult checkLogin(SysUser sysUser, HttpServletRequest request) {
        sysUser = (SysUser) request.getSession().getAttribute(StrUtils.LOGIN_USER);
        SysUser loginUser = sysUserService.login(sysUser);
        JsonResult jsonResult = null;
        if (loginUser != null) {
            jsonResult = new JsonResult(1, loginUser);
        } else {
            jsonResult = new JsonResult(0, "未登录");
        }
        return jsonResult;

    }

    @ResponseBody
    @RequestMapping("/register")
    public JsonResult register(SysUser sysUser) {

        int i = sysUserService.register(sysUser);
        JsonResult jsonResule = null;
        if (i > 0) {
            jsonResule = new JsonResult(1, i);
        } else {
            jsonResule = new JsonResult(0, "注册失败");
        }
        return jsonResule;

    }
    @ResponseBody
    @RequestMapping("/findOne")
    public Map<String,Object> findAllOrder(Integer page, Integer limit, HttpServletRequest request, SysUser user){
        user  = (SysUser) request.getSession().getAttribute(StrUtils.LOGIN_USER);
        PageHelper.startPage(page,limit);
        List<SysUser> list = sysUserService.findOne(user.getId());
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
    @ResponseBody
    @RequestMapping("/updatePassword")
    public JsonResult updatePassword(SysUser user,HttpServletRequest request){
        SysUser user1 = (SysUser) request.getSession().getAttribute(StrUtils.LOGIN_USER);
        user1.setPassword(user.getPassword());
        sysUserService.updatePassword(user1);
        JsonResult jsonResult = new JsonResult(1, user);
        return jsonResult;
    }
}
