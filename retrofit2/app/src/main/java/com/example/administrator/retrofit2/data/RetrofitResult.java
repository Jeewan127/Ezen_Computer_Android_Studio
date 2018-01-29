package com.example.administrator.retrofit2.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2018-01-29.
 */

// 자동으로 getter, setter, 생성자 생성
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RetrofitResult {
    private String id;
    private String name;
}
