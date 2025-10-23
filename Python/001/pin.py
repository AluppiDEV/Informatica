
#! Si scriva un programma che simula lo sblocco di un cellulare. 
#! Il programma legge un pin di 4 cifre inserito dall'utente e lo imposta come pin.
#! Successivamente chiede di reinserire il pin, se viene inserito quello corretto scrive “telefono sbloccato”, 
#! altrimenti lo richiede; al terzo tentativo errato visualizza il messaggio “telefono bloccato”

def set():
		while True:
			pin = int(input("Inserisci il pin di 4 cifre: "))
			if pin >= 1000 and pin <= 9999:
				break
			else:
				print("Il pin inserito non è valido. Riprova.")
		return pin

def check(pin):
	pinInserito = int(input("Inserisci il pin per sbloccare il telefono: "))
	if pinInserito == pin:
		print("Telefono sbloccato")
		return True
	else:
		print("Pin errato, riprova.")
		return False

def main():
	pin = set()
	tentativi = 0

	while tentativi < 3:
		
		if check(pin):
			break
		tentativi += 1
	if tentativi == 3:
		print("Telefono bloccato")

main()