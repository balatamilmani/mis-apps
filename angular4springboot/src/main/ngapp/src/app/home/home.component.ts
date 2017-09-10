import { Component, OnInit } from '@angular/core';
import { GeoNameService } from './geoname.service';
import { ICountry } from './country';

@Component({
    moduleId: module.id,
    selector: 'ng-home',
    templateUrl: 'home.template.html'
})

export class HomeComponent {
    constructor(private geoNameService:GeoNameService){    }
countries: ICountry[];
copyCountries: ICountry[]=[];
errorMessage:string;


//https://www.youtube.com/watch?v=N6H1DfXjMn0
loadCountries(){
this.geoNameService.getCountries()
.subscribe(
    countries=>this.countries=countries,
    error=>this.errorMessage=<any>error,
   ()=>this.copyCountries=this.countries);
}

sortType(sort:string){
    if(sort==='name'){
        this.countries=this.copyCountries.sort(this.sortByCountryname);
        console.log(this.countries);
    }
    if(sort==='pop'){
        this.countries=this.copyCountries.sort(this.sortByPopulation);
        console.log(this.countries);
    }
}

filterBy(filter:string){
  switch(filter){
      case 'all':      
      this.countries=this.copyCountries;
      console.log('all acountries clicked');
      break;
  
      case 'europe' :
      this.countries=this.countries.filter(country=>{
        return country.continentName.toLowerCase().includes('europe');

      });
                console.log('show only european contries');
                break;
        case 'pop':
        this.countries=this.countries.filter(country=>{
            return parseInt(country.population)> 1000000;
        });
        console.log('show population > 1M');
        break;

  }
}
sortByCountryname(c1:ICountry,c2:ICountry){
if(c1.countryName>c2.countryName) return 1
    else if (c1.countryName===c2.countryName) return 0
        else return -1

}
sortByPopulation(c1:ICountry,c2:ICountry){
return parseInt(c1.population)-parseInt(c2.population);

}
}
