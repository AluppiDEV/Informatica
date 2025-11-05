#include <iostream>
#include <filesystem>
#include <string>

namespace fs = std::filesystem;

int main() {
    try {
        fs::path project_path = fs::current_path();
        int count = 0;

        std::cout << "Pulizia in corso nella cartella: " << project_path << "\n\n";

        for (const auto& entry : fs::recursive_directory_iterator(project_path)) {
            if (!fs::is_regular_file(entry.path()))
                continue;

            std::string ext = entry.path().extension().string();
            if (ext == ".class" || ext == ".zip" || ext == ".rar" || ext == ".puml") {
                try {
                    fs::remove(entry.path());
                    std::cout << "Eliminato: " << entry.path() << "\n";
                    count++;
                } catch (const std::exception& e) {
                    std::cout << "Errore su " << entry.path() << ": " << e.what() << "\n";
                }
            }
        }

        std::cout << "\nPulizia completata.\n" << count << " file eliminati.\n";

        std::cout << "\nPremi INVIO per uscire...";
        std::cin.get();
    } catch (const std::exception& e) {
        std::cerr << "Errore generale: " << e.what() << "\n";
        return 1;
    }
    return 0;
}
