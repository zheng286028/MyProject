package com.zzl.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.reggie.mapper.UserMapper;
import com.zzl.reggie.pojo.User;
import com.zzl.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author 郑子浪
 * @date 2022/05/31  10:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {
}
