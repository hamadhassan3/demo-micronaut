package com.example.catalog.controller;

import com.example.catalog.model.dto.request.RoleRequest;
import com.example.catalog.model.dto.response.RoleResponse;
import com.example.catalog.service.RoleService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.List;

@Controller("/catalog/api/roles")
@Secured(SecurityRule.IS_ANONYMOUS)
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    public List<RoleResponse> getAllRoles(){
        return roleService.readAllRoles();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}/")
    public RoleResponse getRoleById(Long id){
        return roleService.readRole(id);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/")
    public RoleResponse createRole(@Body RoleRequest roleRequest){
        return roleService.createRole(roleRequest);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{id}/")
    public RoleResponse updateRole(Long id, @Body RoleRequest roleRequest){
        return roleService.updateRole(id, roleRequest);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Delete("/{id}/")
    public String deleteRole(Long id){
        return roleService.deleteRole(id);
    }
}
