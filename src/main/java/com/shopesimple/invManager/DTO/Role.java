package com.shopesimple.invManager.DTO;

import com.shopesimple.invManager.Models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role extends BaseModel {
    private String roleName;
}
