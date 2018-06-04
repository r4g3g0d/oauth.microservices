import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { BeerService } from './../../services/beer-list.service';
import { GiphyService } from './../../services/giphy.service';

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css'],
  providers: [BeerService, GiphyService]
})

export class BeerListComponent implements OnInit {
  beers: Array<any>;

  constructor(private beerService: BeerService, private giphyService: GiphyService,
              private changeDetectorRef: ChangeDetectorRef) { }

  ngOnInit() {


    this.beerService.getAll().subscribe(
      data => {
        console.log(data);
        this.beers = data;
        for (const beer of this.beers) {
          this.giphyService.get(beer.name).subscribe(url => {
            beer.giphyUrl = url;
            //Need investigation

            this.changeDetectorRef.detectChanges();

          });
        }
      },
      error => console.log(error)
    )


  }
}

