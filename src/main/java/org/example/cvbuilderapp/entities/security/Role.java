package org.example.cvbuilderapp.entities.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.example.cvbuilderapp.entities.security.Permission.*;
@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN(Set.of(ADMIN_READ, ADMIN_WRITE)),
    USER(Collections.emptySet());

    
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = new java.util.ArrayList<>(getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList());

        // Spring security kerkon qe rolet te fillojne me ROLE_
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
