package com.javahabit.organizationservice.service;

import com.javahabit.organizationservice.domain.Organization;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements IService {
    @Override
    public Organization getOrgDetail() {
        return new Organization(1, "XYZ Inc");
    }
}
