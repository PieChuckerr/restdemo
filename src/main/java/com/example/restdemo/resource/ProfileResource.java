package com.example.restdemo.resource;

import com.example.restdemo.model.Profile;
import com.example.restdemo.web.ProfileController;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class ProfileResource extends ResourceSupport {
    private Profile profile;

    public ProfileResource() {

    }

    public ProfileResource(Profile profile) {
        this.profile = profile;
        add(ControllerLinkBuilder.linkTo(ProfileController.class).withRel("profiles"));
        add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProfileController.class).getProfileById(profile.getId())).withSelfRel());
    }
}
