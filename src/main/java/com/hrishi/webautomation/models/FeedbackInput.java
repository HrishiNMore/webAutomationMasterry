package com.hrishi.webautomation.models;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackInput {
    private String name;
    private String emailID;
    private String phoneNo;
    private String comment;

    public FeedbackInput validDetails(){
        Faker faker=new Faker();
        return FeedbackInput.builder()
                .name(faker.name().fullName())
                .emailID(faker.internet().emailAddress())
                .phoneNo("9370031293")
                .comment(faker.lorem().paragraph())
                .build();
    }
    public FeedbackInput inValidDetails(){
        Faker faker=new Faker();
        return FeedbackInput.builder()
                .name(faker.name().fullName())
                .emailID("")
                .phoneNo("9370031293")
                .comment(faker.lorem().paragraph())
                .build();
    }
}
