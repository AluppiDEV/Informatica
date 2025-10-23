import os

# usa la cartella da cui viene avviato lo script
project_path = os.getcwd()

count = 0
for root, dirs, files in os.walk(project_path):
    for file in files:
        if file.endswith(".class" ) | file.endswith(".zip") | file.endswith(".rar"):
            file_path = os.path.join(root, file)
            try:
                os.remove(file_path)
                print(f"Eliminato: {file_path}")
                count += 1
            except Exception as e:
                print(f"Errore su {file_path}: {e}")

print(f"Pulizia completata. {count} file eliminati.")
