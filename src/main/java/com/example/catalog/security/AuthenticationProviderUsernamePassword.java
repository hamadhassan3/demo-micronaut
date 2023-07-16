package com.example.catalog.security;

import com.example.catalog.model.Role;
import com.example.catalog.model.User;
import com.example.catalog.service.UserService;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Singleton
public class AuthenticationProviderUsernamePassword implements AuthenticationProvider {

    private final UserService userService;

    public AuthenticationProviderUsernamePassword(UserService userService){
        this.userService = userService;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest,
            AuthenticationRequest<?, ?> authenticationRequest) {


        return Flux.create(emitter -> {

            try{
                User user = userService.readUserByUsername((String) authenticationRequest.getIdentity());
                if (user != null &&
                        authenticationRequest.getSecret().equals(user.getPassword())) {
                    emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity(),
                            user.getRoles().stream().map(Role::getName).collect(Collectors.toList())));
                    emitter.complete();
                } else {
                    emitter.error(AuthenticationResponse.exception());
                }
            }
            catch(NoSuchElementException ex){
                emitter.error(ex);
            }

        }, FluxSink.OverflowStrategy.ERROR);
    }

}
