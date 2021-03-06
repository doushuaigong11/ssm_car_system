package com.zz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysOrder {
    private Integer id;

    private Integer cid;

    private Integer uid;

    private Integer getid;

    private Integer backid;

    private Double oprice;

    private String status;

}