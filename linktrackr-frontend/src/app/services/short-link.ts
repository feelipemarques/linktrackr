import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ShortLink {
  private apiUrl = "http://localhost:8080";

  constructor(private http: HttpClient) {}

  shortenUrl(url: string): Observable<string>{
    return this.http.post(`${this.apiUrl}/api/links`, url, {responseType: 'text'});
  }
}
