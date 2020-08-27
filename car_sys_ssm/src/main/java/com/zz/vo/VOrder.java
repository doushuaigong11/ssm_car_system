package com.zz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VOrder {
    private Integer oid;
    private Double oprice;
    private String cname;
    private String getcity;
    private String backcity;
    private String ostatus;
}
