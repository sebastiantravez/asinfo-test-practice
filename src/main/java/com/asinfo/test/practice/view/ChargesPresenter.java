package com.asinfo.test.practice.view;

import com.asinfo.test.practice.controller.entity.Employees;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChargesPresenter {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID idCharge;

    private String name;

}
