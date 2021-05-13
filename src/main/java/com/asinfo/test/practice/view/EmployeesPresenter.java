package com.asinfo.test.practice.view;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class EmployeesPresenter {

    private UUID id;
}
