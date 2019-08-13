import { Component } from '@angular/core';
import { compileBaseDefFromMetadata } from '@angular/compiler';

@Component({
    selector: 'my-comp',
    template: `<h1 style='{{color}}'>{{message}}</h1>
                    <h2>Id : {{emp.id}}</h2>,
                    <h2>Name : {{emp.name}}</h2>,
                    <h2>Salary : {{emp.salary}}</h2>
                    <p>{{3+9}}</p>
                    <p>{{'today is'+12}}</p>`,
                    
    styles: ['h1{color:blue}']

})

export class TestComponent {
    message:string = "Emp Details";
    color="red";

    public emp = { id: 100, name: 'Shantanu', salary: 34000 };
    constructor() { }

}