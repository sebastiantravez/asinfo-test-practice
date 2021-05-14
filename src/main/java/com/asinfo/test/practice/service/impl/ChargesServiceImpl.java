package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.controller.repository.ChargesRepository;
import com.asinfo.test.practice.service.ChargesService;
import com.asinfo.test.practice.view.ChargesPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChargesServiceImpl implements ChargesService {

    @Autowired
    ChargesRepository chargesRepository;

    @Override
    public List<ChargesPresenter> getAllCharges() {
        return chargesRepository.getAllCharges().stream().map(
                item -> ChargesPresenter.builder()
                        .idCharge(item.getIdCharge())
                        .name(item.getName())
                        .build()
        ).collect(Collectors.toList());
    }
}
