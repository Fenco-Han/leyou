package com.leyou.item.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * tb_brand
 * @author 
 */
@ApiModel(value="com.leyou.item.pojo.Brand品牌表，一个品牌下有多个商品（spu），一对多关系")
@Data
public class Brand implements Serializable {
    /**
     * 品牌id
     */
    @ApiModelProperty(value="品牌id")
    private Long id;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value="品牌名称")
    private String name;

    /**
     * 品牌图片地址
     */
    @ApiModelProperty(value="品牌图片地址")
    private String image;

    /**
     * 品牌的首字母
     */
    @ApiModelProperty(value="品牌的首字母")
    private String letter;

    private static final long serialVersionUID = 1L;
}