package com.asinfo.test.practice.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "business")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Business {

    @Id
    @Column(name = "id_business")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBusiness;

    private String businessName;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "business")
    private List<Employees> employees = new ArrayList<>();
}
