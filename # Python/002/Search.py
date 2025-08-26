
#! Scrivi una funzione Python chiamata trova_parole_con_prefisso che prenda come input una lista di parole (stringhe) 
#! e un prefisso (un'altra stringa). 
#! La funzione deve restituire una nuova lista contenente solo le parole della lista originale che iniziano con il prefisso specificato.
#! Ad esempio, se la lista di parole è ["mela", "banana", "mandarino", "kiwi", "melone"] e il prefisso è "me", 
#! la funzione dovrebbe restituire ["mela", "melone"].

import os

def trova_parole_con_prefisso(parole, prefisso):
	lista = ""
	for i in range(len(parole)):
		if parole[i].startswith(prefisso):
			lista += parole[i]
			lista += " "
	
	return lista


def main():
	parole = "mela", "banana", "mandarino", "kiwi", "melone"
	prefisso = input("Inserisci il prefisso: ")
	lista = trova_parole_con_prefisso(parole, prefisso)
	print(f"Parole con il prefisso {prefisso}: {lista}")

main()