package com.tcs.security.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@Data
public class User implements UserDetails {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private String details;
    
    private String confirmPassword;

    @Column(name = "group_permission")
    private String groupPermission;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] userPermissions = groupPermission.split(",");
        List<GrantedAuthority> list = new ArrayList<>();
        for (String s : userPermissions) {
            list.add(new SimpleGrantedAuthority(s.trim()));
        }
        return list;
    }


}
