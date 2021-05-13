package com.asinfo.test.practice.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "idDepartment")
@ToString(of = "idDepartment")
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentPresenter {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID idDepartment;

    private String nameDepartment;
}
