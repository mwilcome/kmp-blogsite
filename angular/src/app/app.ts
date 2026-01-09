import { Component, computed, signal } from '@angular/core';

import { com } from 'shared-logic';

const SharedApi = com.mikewilcome.kmp.SharedApi;

type Screen = 'welcome' | 'home';

type ContentBlock = {
  type: 'heading' | 'paragraph' | 'numbered_list';
  text?: string | null;
  level?: number | null;
  items?: string[] | null;
};

type ContentDocument = {
  schemaVersion: number;
  id: string;
  title: string;
  meta?: string | null;
  blocks: ContentBlock[];
};

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App {
  protected readonly screen = signal<Screen>('welcome');
  protected readonly welcomeDoc = signal<ContentDocument | null>(null);
  protected readonly isWelcome = computed(() => this.screen() === 'welcome');

  constructor() {
    const doc = SharedApi.getDocument('welcome') as ContentDocument | null;
    this.welcomeDoc.set(doc);
  }

  protected continue(): void {
    this.screen.set('home');
  }
}
