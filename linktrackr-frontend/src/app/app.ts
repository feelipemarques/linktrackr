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
  copied: boolean = false;
  errorMessage: string = '';

  constructor(
    private shortLinkService: ShortLink,
    private cdr: ChangeDetectorRef
  ) {}

  shorten() {
    this.shortLinkService.shortenUrl(this.url).subscribe({
      next: (link) => {
      console.log('resultado: ', link);
      this.shortUrl = link;
      this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = err.error;
        this.cdr.detectChanges();
        setTimeout(() => {
          this.errorMessage = '';
          this.cdr.detectChanges();
        }, 2000);
      }
    });
  }

  copyLink(){
    navigator.clipboard.writeText(this.shortUrl);
    this.copied = true;
    setTimeout(() => {
      this.copied = false;
      this.cdr.detectChanges();
    }, 2000);
    
  }

}

