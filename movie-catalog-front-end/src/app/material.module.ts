import { NgModule } from "@angular/core";
import { MatSliderModule } from '@angular/material/slider';
import { MatCheckboxModule } from '@angular/material/checkbox';

@NgModule({
    imports: [
        MatSliderModule,
        MatCheckboxModule
    ],
    exports: [
        MatSliderModule,
        MatCheckboxModule
    ]
})

export class MaterialModule { }