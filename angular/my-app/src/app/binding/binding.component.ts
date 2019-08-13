import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-binding',
  template: `
    <h2 [class]='style'>This is a text</h2>
    <button (click)='onClick()'>Change</button>
    <hr>
    <input type='text' [disabled]='isDisabled'>
    <button (click)='toggle()'>Toggle</button>

  `,
  styles: [
    `.error{
      color:red
      }
    .normal{
      color:green
      }
        `
  ]
})
export class BindingComponent implements OnInit {

  public style: string = 'error';
  public isDisabled:boolean = true;
  constructor() { }

  ngOnInit() {
  }

  onClick() {
    if (this.style == 'error') {
      this.style = 'normal';
    } else {
      this.style = 'error';
    }
  }

  toggle() {
    if (this.isDisabled) {
      this.isDisabled = false;
    }else{
      this.isDisabled = true;
    }
  }
}
