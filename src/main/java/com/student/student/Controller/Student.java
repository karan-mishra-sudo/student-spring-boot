package com.student.student.Controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Document(collection = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public class Student {
    
    @Id
    private String id;
    private String title;
    private String content;
    private String studentName; 
}
