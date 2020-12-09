package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.RefData;
import io.pragra.learning.jpademo.repo.RefDataRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RefController {
    private RefDataRepo refDataRepo;

    public RefController(RefDataRepo refDataRepo) {
        this.refDataRepo = refDataRepo;
    }
//    @GetMapping("/api/ref")
//    public List<RefData> getRefdata(){
//        return this.refDataRepo.findAll();
//    }
    @GetMapping("/api/ref")
    public List<RefData> refData(){
        return this.refDataRepo.findAll();
    }
}

