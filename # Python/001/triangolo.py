
#! Legge tre lunghezze dei lati di un triangolo, controllando che siano maggiore di zero e dice se il triangolo è scaleno, 
#! isoscele o equilatero; il programma deve indicare solo la tipologia più particolare, ovvero se è equilatero, 
#! dice solo che è equilatero e non anche che è isoscele. 
#! Il programma deve inoltre emettere un messaggio di errore e fermarsi se i dati inseriti non possono formare un triangolo. 


def triangolo(a, b, c):
	if a <= 0 or b <= 0 or c <= 0:
		print("Errore: i lati non possono comporre un triangolo.")
		return
	if a + b <= c or a + c <= b or b + c <= a:
		print("Errore: i lati non possono comporre un triangolo.")
		return
	if a == b == c:
		print("il triangolo è equilatero")
	elif a == b or a == c or b ==c:
		print("il triangolo è isoscele")
	else:
		print("il triangolo è scaleno")

def main():
	lato1 = float(input("inserisci il primo lato: "))
	lato2 = float(input("inserisci il secondo lato: "))
	lato3 = float(input("inserisci il terzo lato: "))

	triangolo(lato1, lato2, lato3)

main()