package com.example.Theacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    //  id  主键
    private int id;
    //    教师名字
    private String name;

    public Teacher(String name) {
        this.name = name;
    }
}
