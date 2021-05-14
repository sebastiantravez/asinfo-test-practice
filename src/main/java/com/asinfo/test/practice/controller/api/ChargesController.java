package com.asinfo.test.practice.controller.api;

import com.asinfo.test.practice.service.ChargesService;
import com.asinfo.test.practice.view.ChargesPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ChargesController {

    @Autowired
    ChargesService chargesService;

    @GetMapping("/getAllCharges")
    public List<ChargesPresenter> getAllCharges() {
        return chargesService.getAllCharges();
    }
}
