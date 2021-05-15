package com.asinfo.test.practice.view;

import lombok.*;

import java.util.UUID;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessPresenter {

    private UUID idBusiness;
    private String businessName;
}
