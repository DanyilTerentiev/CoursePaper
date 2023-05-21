package com.coursepaper.CoursePaper.jwt;
public class JwtResponse {
    private String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public JwtResponse() {
    }

    public String getToken() {
        return this.jwttoken;
    }
}
