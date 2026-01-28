import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

export interface Lavoratore {
  id: string;
  nome: string;
  cognome: string;
  email: string;
  telefono: string;
}

const ELEMENT_DATA: Lavoratore[] = [
  {id: '1', nome: 'Mario', cognome: 'Rossi', email: 'mario.rossi@example.com', telefono: '3331234567'},
  {id: '2', nome: 'Luca', cognome: 'Verdi', email: 'luca.verdi@example.com', telefono: '3339876543'},
  {id: '3', nome: 'Giulia', cognome: 'Bianchi', email: 'giulia.bianchi@example.com', telefono: '3334567890'},
];

@Component({
  selector: 'app-lavoratori-list',
  imports: [MatTableModule, MatButtonModule, MatIconModule],
  templateUrl: './lavoratori-list.html',
  styleUrl: './lavoratori-list.css',
})
export class LavoratoriList {
  displayedColumns: string[] = ['nome', 'cognome', 'email', 'telefono', 'actions'];
  dataSource = ELEMENT_DATA;
}
