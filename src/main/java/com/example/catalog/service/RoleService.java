package com.example.catalog.service;

import com.example.catalog.model.Role;
import com.example.catalog.model.dto.request.RoleRequest;
import com.example.catalog.model.dto.response.RoleResponse;
import com.example.catalog.repository.RoleRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public long countRoles(){
        return roleRepository.count();
    }

    public List<RoleResponse> readAllRoles(){
        return roleRepository.find();
    }

    public RoleResponse readRole(Long id){

        Optional<RoleResponse> optionalRoleResponse = roleRepository.find(id);

        if(optionalRoleResponse.isEmpty()){
            throw new NoSuchElementException("A Role with this id does not exist!");
        }

        return optionalRoleResponse.get();
    }

    @Transactional
    public RoleResponse createRole(RoleRequest roleRequest){

        Role role = new Role();
        role.setName(roleRequest.name());
        role = roleRepository.save(role);
        return new RoleResponse(role);
    }

    @Transactional
    public RoleResponse updateRole(Long id, RoleRequest roleRequest){
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isEmpty()){
            throw new NoSuchElementException("A Role with this id does not exist!");
        }
        else {
            Role role = optionalRole.get();
            role.setName(roleRequest.name());
            role = roleRepository.update(role);
            return new RoleResponse(role);
        }
    }

    @Transactional
    public String deleteRole(Long id){
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isEmpty()){
            throw new NoSuchElementException("A Role with this id does not exist!");
        }
        else {
            roleRepository.delete(optionalRole.get());
            return "success";
        }
    }
}
