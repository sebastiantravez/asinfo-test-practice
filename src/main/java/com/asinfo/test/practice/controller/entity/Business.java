package com.asinfo.test.practice.controller.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "business")
@Getter
@Setter
@Builder
public class Business {
}
