import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-night-mode',
  templateUrl: './night-mode.component.html',
  styleUrls: ['./night-mode.component.css']
})
export class NightModeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  toggleDarkLight() {
    var body = document.getElementById("body");
    var btn = document.getElementById("btn");
    var currentClass = body.className;
    var currentBtn = btn.className;
    body.className = currentClass == "light-mode" ? "dark-mode" : "light-mode";
    btn.className = currentBtn == "btn btn-dark" ? "btn btn-light" : "btn btn-dark" 
  }

}
