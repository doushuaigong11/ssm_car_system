package com.zz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysCar {
    private Integer id;

    private String name;

    private String type;

    private Integer sitnum;

    private Integer cid;

    private Double price;

    private Integer number;

    private String picture;


}