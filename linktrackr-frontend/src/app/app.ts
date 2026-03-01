import { ChangeDetectorRef, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ShortLink } from './services/short-link';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  url: string = '';
  shortUrl: string = '';

  constructor(
    private shortLinkService: ShortLink,
    private cdr: ChangeDetectorRef
  ) {}

  shorten() {
    this.shortLinkService.shortenUrl(this.url).subscribe(link => {
      console.log('resultado: ', link);
      this.shortUrl = link;
      this.cdr.detectChanges();
    })
  }

}
