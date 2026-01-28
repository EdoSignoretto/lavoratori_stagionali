import { Routes } from '@angular/router';
import { Dashboard } from './components/dashboard/dashboard';
import { LavoratoriList } from './components/lavoratori-list/lavoratori-list';

export const routes: Routes = [
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    { path: 'dashboard', component: Dashboard },
    { path: 'lavoratori', component: LavoratoriList }
];
