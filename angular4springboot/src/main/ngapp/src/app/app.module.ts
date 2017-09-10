import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { HttpModule  } from '@angular/http';
import { GeoNameService } from './home/geoname.service';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './nav/nav.component';

@NgModule({
  imports: [ BrowserModule,HttpModule,
                   FormsModule,
                   AppRoutingModule
                   ],
  declarations: [ AppComponent,
                          HomeComponent,
                          NavbarComponent
                          ],
  providers: [GeoNameService     ],
  bootstrap:    [ AppComponent ]
})

export class AppModule { }