package ru.kpfu.itis.khayrullin.util.transformers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.khayrullin.model.User;
import ru.kpfu.itis.khayrullin.util.forms.SignUpForm;

import java.util.function.Function;

public class SignUpFormToUserTransformer implements Function<SignUpForm, User> {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User apply(SignUpForm signUpForm) {
        User user = new User();
        user.setEmail(signUpForm.getEmail());
        user.setName(signUpForm.getName());
        user.setPassword(encoder.encode(signUpForm.getPassword()));
        return user;
    }
}
