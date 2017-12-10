package com.yasin.controller;


import com.yasin.POJO.SCoin;
import com.yasin.service.SCoinServiceView;
import com.yasin.service.impl.SCoinServiceViewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class SCoinRestController {

    @Autowired
    SCoinServiceView sCoinServiceView;  //Service which will do all data retrieval/manipulation work

    @RequestMapping(value = "/ticker/", method = RequestMethod.GET)
    public ResponseEntity<SCoin> getCurrent() throws Exception{
        SCoin sCoin = sCoinServiceView.getCurrent();
        if(sCoinServiceView == null){
            return new ResponseEntity<SCoin>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<SCoin>(sCoin, HttpStatus.OK);
    }
    @RequestMapping(value = "/ticker/{sCoin}/{type}/{value}", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> convertTo(@PathVariable("sCoin") double sCoin, @PathVariable("type") String type, @PathVariable("value") double value) {

        double val = sCoinServiceView.converter(true, type, sCoin);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
    @RequestMapping(value = "/ticker/{value}/{type}/{sCoin}", method = RequestMethod.PUT, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> convertFrom(@PathVariable("value") double value, @PathVariable("type") String type, @PathVariable("sCoin") double sCoin) {

        double val = sCoinServiceView.converter(false, type, sCoin);


        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
    @RequestMapping(value = "/history/", method = RequestMethod.GET)
    public ResponseEntity<List<SCoin>> getAll() throws Exception{
        List<SCoin> sCoins = sCoinServiceView.getAll();
        if(sCoins.isEmpty()){
            return new ResponseEntity<List<SCoin>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SCoin>>(sCoins, HttpStatus.OK);
    }

}