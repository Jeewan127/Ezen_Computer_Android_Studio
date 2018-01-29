package com.example.administrator.retrofit2.data;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2018-01-29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArrayBook {
    private String name;
    private Integer price;
    private String publisher;
}
