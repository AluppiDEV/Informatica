
#! Scrivi una funzione Python chiamata calcola_media_e_massimo che prenda come input una lista di numeri interi. 
#! La funzione deve restituire una riga contenente due elementi: 
#! la media di tutti i numeri nella lista e il valore massimo presente nella lista.
#! Popolare la lista utilizzando la funzione random.
#! Ad esempio, se la lista di input è [10, 20, 5, 30, 15], la funzione dovrebbe restituire (16.0, 30).
#! Memorizzare la lista su file.

import random as r
import os

DIM: int = 10

def fill_list():
	lista = r.sample(range(1, 100), DIM)
	return lista

def calcola_media_e_massimo(lista): 
	media = sum(lista) / len(lista)
	massimo = max(lista)
	return (media, massimo)

def saveOnFile(lista):
	with open('./002/lista.txt', 'w') as file:
		for elem in lista:
			file.write(f"{elem} ")

def main():
	lista = fill_list()
	print(f"Lista: {lista}")
	media, massimo = calcola_media_e_massimo(lista)
	print(f"Media: {media}, Massimo: {massimo}")
	saveOnFile(lista)

main()