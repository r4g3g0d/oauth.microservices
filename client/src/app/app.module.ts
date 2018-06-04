import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { OktaService} from './services/okta.service';
import { BeerListComponent } from './components/beer-list/beer-list.component';
import { BeerService } from './services/beer-list.service';
import { GiphyService } from './services/giphy.service';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatListModule, MatToolbarModule } from '@angular/material';


@NgModule({
  declarations: [
    AppComponent,
    BeerListComponent
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    HttpClientModule,
    MatListModule,
    MatToolbarModule
  ],
  providers: [OktaService,BeerService,GiphyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
