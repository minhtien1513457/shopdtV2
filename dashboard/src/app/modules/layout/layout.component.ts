import { Component, OnInit } from '@angular/core';
import * as CryptoJS from 'crypto-js';
import { ConfigService } from 'src/app/shared/services/config.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  constructor() {}

  ngOnInit() {
  }

}
