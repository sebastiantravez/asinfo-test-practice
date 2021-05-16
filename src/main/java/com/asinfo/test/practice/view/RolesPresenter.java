package com.asinfo.test.practice.view;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolesPresenter {

    private UUID idRol;
    private String name;
}
