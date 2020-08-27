package com.zz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    private Integer id;

    private String tel;

    private String password;

    private String email;

    private String invitation;

}