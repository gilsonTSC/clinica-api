package com.gilsontsc.clinica.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Permission Endpoint", description = "Controler da entidade permission", tags = {"PermissionEndpoint"})
@RestController
@RequestMapping(value="/api/permission")
public class PermissionController {

}