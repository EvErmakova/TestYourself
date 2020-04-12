package com.test.yourself.model;

import com.test.yourself.model.enums.QuestionMode;
import lombok.Builder;
import lombok.Data;


import java.util.Set;

@Data
@Builder
public class Question {
    private Long id;
    private Subject subject;
    private String name;
    private String description;
    private Set<Answer> answers;
    private QuestionMode mode;

}
