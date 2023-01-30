import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { HttpClientModule } from '@angular/common/http';
import { RegisterCalifComponent } from './register-calif/register-calif.component';
import { UpdateCalifComponent } from './update-calif/update-calif.component';
import { CalifListComponent } from './calif-list/calif-list.component';
import { CalifDetailsComponent } from './calif-details/calif-details.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      { path: '', component: CalifListComponent },
      { path: 'kardex/:alumnoId', component: CalifDetailsComponent },
      { path: 'registrar/:alumnoId', component: RegisterCalifComponent },
      { path: 'actualizar/:calificacionId', component: UpdateCalifComponent },
    ])
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    CalifListComponent,
    CalifDetailsComponent,
    RegisterCalifComponent,
    UpdateCalifComponent,
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }