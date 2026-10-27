package com.ecoalis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ="/ddc")
public abstract class ParentController {

	@Autowired
    protected MessageSource message;
}
