import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/shared/services/config.service';
import jwtDecode from "jwt-decode";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  constructor(
    private activatedRoute: ActivatedRoute,
    private http: HttpClient ) { }

    ngOnInit(): void {
    }
}
