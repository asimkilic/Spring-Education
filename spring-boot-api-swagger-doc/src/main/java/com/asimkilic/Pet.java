package com.asimkilic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet nesnesi", description = "PET description")
public class Pet {
    @ApiModelProperty(value = "Pet nesnesinin tekil Ad alanı")
    private int id;
    @ApiModelProperty(value = "Pet nesnesinin tekil İsim alanı")
    private String name;
    @ApiModelProperty(value = "Pet nesnesinin tekil Tarih alanı")
    private Date date;
}
