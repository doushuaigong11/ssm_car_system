package com.zz.vo;

import com.zz.pojo.SysCity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VCity {
    private SysCity getCity;
    private SysCity backCity;
}
