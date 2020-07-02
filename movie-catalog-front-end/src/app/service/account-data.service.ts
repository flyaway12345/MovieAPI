import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from '../model/account';
import { API_URL } from '../app.constant';

@Injectable({
  providedIn: 'root'
})
export class AccountDataService {

  constructor(private http: HttpClient) { }

  getAllAccounts(username: string): Observable<Account[]> {
    return this.http.get<Account[]>(`${API_URL}/accounts/${username}`);
  }

  getAccountById(id: number): Observable<Account> {
    return this.http.get<Account>(`${API_URL}/accounts/${id}`);
  }

  addAccount(account: Account): Observable<any> {
    return this.http.post(`${API_URL}/accounts`, account);
  }

  updateAccount(account: Account, id: number): Observable<any> {
    return this.http.put(`${API_URL}/accounts/${id}`, account);
  }

  deleteAccount(id: number) {
    return this.http.delete(`${API_URL}/accounts/${id}`);
  }
  
}
