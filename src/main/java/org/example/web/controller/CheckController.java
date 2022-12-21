package org.example.web.controller;

import org.example.model.Check;
import org.example.service.CheckService;
import org.example.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/check")
public class CheckController {

    private final FileService fileService;
    private final CheckService checkService;

    @Autowired
    public CheckController(FileService fileService, CheckService checkService) {
        this.fileService = fileService;
        this.checkService = checkService;
    }

    @GetMapping()
    public ResponseEntity<Check> getCheck(@RequestParam(value = "itemId", required = true) final List<Long> itemId,
                                          @RequestParam(value = "check", required = false) final Long numberCard) {
        Check check = checkService.getCheck(itemId, numberCard);
        fileService.outputInFile(check);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
}
