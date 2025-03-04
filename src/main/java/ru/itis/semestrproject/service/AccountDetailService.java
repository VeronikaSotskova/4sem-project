package ru.itis.semestrproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.semestrproject.models.Account;
import ru.itis.semestrproject.models.AccountDetails;
import ru.itis.semestrproject.repository.AccountRepository;

import java.util.Optional;

@Service(value = "customUserDetailsService")
public class AccountDetailService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> accountOptional = accountRepository.findAccountByEmail(email);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            return new AccountDetails(account);
        } else throw new UsernameNotFoundException("User not found");
    }
}