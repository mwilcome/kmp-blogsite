import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { com } from 'shared-logic';

const SharedApi = com.mikewilcome.kmp.SharedApi;


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('angular');

  constructor() {
    console.log('KMP add:', SharedApi.add(5, 3));
    console.log('KMP subtract:', SharedApi.subtract(5, 2));
  }
}
