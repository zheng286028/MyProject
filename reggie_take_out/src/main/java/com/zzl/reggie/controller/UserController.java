package com.zzl.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzl.reggie.Utils.SMSUtils;
import com.zzl.reggie.Utils.ValidateCodeUtils;
import com.zzl.reggie.common.CustomException;
import com.zzl.reggie.common.ReturnObject;
import com.zzl.reggie.pojo.User;
import com.zzl.reggie.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

/**
 * 功能描述
 *
 * @author 郑子浪
 * @date 2022/05/31  10:53
 */
@Controller
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户登录相关接口")
public class UserController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserService userService;

    /**
     * 根据手机发送验证码
     * @param user
     * @return
     */
    @ApiOperation(value = "发送验证码接口")
    @PostMapping("/sendMsg")
    public ReturnObject<String> userLogin(@RequestBody User user){
        log.info(user.toString());
        //获取手机号
        String phone = user.getPhone();
        if(StringUtils.isNotEmpty(phone)){
            //生成随机验证码
            Integer code = ValidateCodeUtils.generateValidateCode(4);
            log.info(code.toString());
            stringRedisTemplate.opsForValue().set(phone,code.toString(),60*2,TimeUnit.SECONDS);
        }
        return ReturnObject.success("验证码发送成功!");
    }

    /**
     * 登录验证
     * @param map
     * @return
     */
    @ApiOperation(value = "登录验证接口")
    @PostMapping("/login")
    public ReturnObject<User> login(@RequestBody Map<String,Object> map, HttpSession session){
        log.info(map.toString());
        String phone =(String) map.get("phone");
        String userCode =(String) map.get("code");
        //从redis中根据手机号的key加将value查询出来
        String code2 = stringRedisTemplate.opsForValue().get(phone);
        //比对
        if(userCode !=null && code2.equals(userCode)){
            //判断当前用户是否已经注册过
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user = userService.getOne(queryWrapper);
            if(user==null){
                //新用户，注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            //将当前用户存储到session中
            session.setAttribute("userPhone",user);
            return ReturnObject.success(user);
        }else{
            throw new CustomException("验证错误");
        }
    }
}
