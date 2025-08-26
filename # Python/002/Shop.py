
#! Un negozio di vestiario possiede una listino prezzi con i seguenti dati: 
#! Jeans Panetton (50€)
#! Camicia Sara (35.50€)
#! Calze Calzedonna (10.65€)
#! Pantaloni Dolce & Salato (122€)
#! Scrivere un programma che permette di aggiungere o rimuovere elementi al listino. 
#! “Splittare” quindi il listino in due parti, 
#! la prima con le chiavi che vanno dalla A alla M  e la seconda con le chiavi da N alla Z.
#! Memorizzare i due listini su file.

def add_item(lista, name, price):
	#? Aggiunge un elemento al listino.
	lista.append({'name': name, 'price': price})

def remove_item(lista, name):
	#? Rimuove un elemento dal listino.
	lista[:] = [item for item in lista if item['name'] != name]

def split_list(lista):
	#? Divide il listino in due parti: A-M e N-Z.
	lista.sort(key=lambda x: x['name'])
	list_a_m = [item for item in lista if 'A' <= item['name'][0].upper() <= 'M']
	list_n_z = [item for item in lista if 'N' <= item['name'][0].upper() <= 'Z']
	return list_a_m, list_n_z

def save_to_file(filename, lista):
	#? Salva un listino su file.
	with open(filename, 'w', encoding='utf-8') as file:
		for item in lista:
			file.write(f"{item['name']}: {item['price']}€\n")

def main():
	#? Lista iniziale
	listino = [
		{'name': 'Jeans Panetton', 'price': 50.00},
		{'name': 'Camicia Sara', 'price': 35.50},
		{'name': 'Calze Calzedonna', 'price': 10.65},
		{'name': 'Pantaloni Dolce & Salato', 'price': 122.00}
	]

	while True:
		print("\nMenu:")
		print("1. Aggiungi un elemento")
		print("2. Rimuovi un elemento")
		print("3. Dividi il listino e salva su file")
		print("4. Esci")
		scelta = input("Scegli un'opzione: ")

		if scelta == '1':
			nome = input("Inserisci il nome dell'articolo: ")
			prezzo = float(input("Inserisci il prezzo dell'articolo: "))
			add_item(listino, nome, prezzo)
			print("Articolo aggiunto con successo!")
		elif scelta == '2':
			nome = input("Inserisci il nome dell'articolo da rimuovere: ")
			remove_item(listino, nome)
			print("Articolo rimosso con successo!")
		elif scelta == '3':
			list_a_m, list_n_z = split_list(listino)
			save_to_file("./002/listino_A_M.txt", list_a_m)
			save_to_file("./002/listino_N_Z.txt", list_n_z)
			print("Listini salvati su file!")
		elif scelta == '4':
			print("Uscita dal programma.")
			break
		else:
			print("Opzione non valida. Riprova.")


main()