package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author X♡Game
 * @create 2020/5/21 9:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public int id;

    private String name;

    private String Code;

    private String  Address;

}
