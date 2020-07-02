package org.yearup.moviecatalog.account.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.yearup.moviecatalog.account.model.Accounts;
import org.yearup.moviecatalog.account.service.AccountService;
import org.yearup.moviecatalog.movie.dto.SuccessfulResponseDetail;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public ResponseEntity<List<Accounts>> getAllAccounts(){
        List<Accounts> accounts = accountService.getAllAccounts();
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", accounts);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{userId}")
    public ResponseEntity<?> getAccountById(@PathVariable Long userId){
        Optional<Accounts> accounts = accountService.getAccountById(userId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", accounts);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts")
    public ResponseEntity<?> createAccount(@Valid @RequestBody Accounts accounts){
        Accounts a = accountService.createAccount(accounts);
        HttpHeaders headers = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/accounts")
                .buildAndExpand(accounts.getUserId())
                .toUri();
        headers.setLocation(newAccountUri);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.CREATED.value(), "Created Account", accounts);
        return new ResponseEntity<>(successfulResponseDetail, headers, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{userId}")
    public ResponseEntity<?> updateAccount(@RequestBody Accounts account, @PathVariable Long userId){
        accountService.updateAccount(account, userId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.ACCEPTED.value(), "Updated Account", account);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{userId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long userId){
        accountService.deleteAccountById(userId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.NO_CONTENT.value(), "Deleted Account", null);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.NO_CONTENT);
    }
}
