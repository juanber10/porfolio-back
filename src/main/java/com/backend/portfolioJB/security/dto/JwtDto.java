package com.backend.portfolioJB.security.dto;

public class JwtDto {
    private String token;
//    private String bearer = "Bearer";
//    private String nombreUsuario;
//    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token) {
        this.token = token;
        
//        this.nombreUsuario = nombreUsuario;
//        this.authorities = authorities;
    }

    public JwtDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

   
}
