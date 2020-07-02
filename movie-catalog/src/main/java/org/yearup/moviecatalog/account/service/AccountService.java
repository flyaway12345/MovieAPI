package org.yearup.moviecatalog.account.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yearup.moviecatalog.account.model.Accounts;
import org.yearup.moviecatalog.account.repo.AccountRepository;
import org.yearup.moviecatalog.movie.domain.Movie;
import org.yearup.moviecatalog.movie.exception.ResourceNotFoundException;
import org.yearup.moviecatalog.movie.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    private MovieRepository movieRepository;

    protected void verifyAccount(Long userId) throws ResourceNotFoundException {
        Optional<Accounts> accounts = accountRepository.findById(userId);
        if (accounts.isEmpty()){
            throw new ResourceNotFoundException("User with id " + userId + " not found");
        }
    }

    public Accounts createAccount(Accounts accounts){
       return accountRepository.save(accounts);
    }



    public List<Accounts> getAllAccounts(){
        List<Accounts> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts :: add);
        return accounts;
    }

    public Optional<Accounts> getAccountById(Long userId){
        return accountRepository.findById(userId);
    }

    public void updateAccount(Accounts account, Long userId){
        for (Accounts accounts1 : accountRepository.findAll()){
            if (accounts1.getUserId().equals(userId)){
                accountRepository.save(account);
            }
        }
    }

    public void deleteAccountById(Long userId){
        accountRepository.deleteById(userId);
    }

}

