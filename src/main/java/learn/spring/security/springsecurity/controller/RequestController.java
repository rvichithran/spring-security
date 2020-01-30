package learn.spring.security.springsecurity.controller;

import learn.spring.security.springsecurity.security.AuthenticationRequest;
import learn.spring.security.springsecurity.security.AuthenticationResponse;
import learn.spring.security.springsecurity.util.JWTUtil;
import learn.spring.security.springsecurity.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @GetMapping("/")
    public String home() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>Welcome User</h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>Welcome Admin</h1>";
    }

    @GetMapping("/alternate")
    public String alternate() {
        return "<h1>Alternate way</h1>";
    }

    @GetMapping("/error")
    public String error() {
        return "<h1>Error page</h1>";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authReq) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(),
                    authReq.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwtTokenUtil.generateToken(userDetails)));
    }
}
