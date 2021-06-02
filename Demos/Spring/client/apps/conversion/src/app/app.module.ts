import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ConversionModule} from "@groupdocs.examples.angular/conversion";

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule,ConversionModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
