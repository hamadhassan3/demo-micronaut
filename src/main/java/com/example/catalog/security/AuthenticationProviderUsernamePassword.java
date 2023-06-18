package com.example.catalog.security;

import com.example.catalog.model.User;
import com.example.catalog.model.dto.response.RoleResponse;
import com.example.catalog.model.dto.response.UserResponse;
import com.example.catalog.repository.UserRepository;
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

            UserResponse user = null;

            try{
                user = userService.readUserByUsername((String) authenticationRequest.getIdentity());
            }
            catch(NoSuchElementException ex){
            }

            if (user != null &&
                    authenticationRequest.getSecret().equals(user.password())) {
                emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity(),
                        user.roles().stream().map(RoleResponse::name).collect(Collectors.toList())));
                emitter.complete();
            } else {
                emitter.error(AuthenticationResponse.exception());
            }
        }, FluxSink.OverflowStrategy.ERROR);
    }

}
