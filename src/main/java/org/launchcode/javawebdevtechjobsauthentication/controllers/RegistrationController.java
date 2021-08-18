package org.launchcode.javawebdevtechjobsauthentication.controllers;

import lombok.AllArgsConstructor;
import org.launchcode.javawebdevtechjobsauthentication.registration.RegistrationRequest;
import org.launchcode.javawebdevtechjobsauthentication.registration.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping()
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
