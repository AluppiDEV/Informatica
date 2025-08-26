
#! Leggere in input un numero  naturale n e disegnare triangolo rettangolo formato da “*”. 
#! Per esempio, inserendo 4 l’output dovrà risultare: 

#! una variante più complessa consiste nel creare una “piramide” di altezza 4, formata da strati di stelle dispari. 
#! In questo caso l’output risulterebbe:

def main():
	n = int(input("Inserisci un numero naturale:"))
	while n <= 0:
		print("Il numero deve essere maggiore di zero.")
		n = int(input("Inserisci un numero naturale:"))
	print("Triangolo:")
	triangolo(n)
	print("Piramide:")
	piramide(n)
	
def triangolo(n):
	for i in range(1, n + 1):
		spazi = " " * (n - i)
		stelle = "*" * i
		print(spazi + stelle)

def piramide(n):
	for i in range(1, n + 1):
		spazi = " " * (n - i)
		stelle = "*" * (2 * i - 1)
		print(spazi + stelle)


main()