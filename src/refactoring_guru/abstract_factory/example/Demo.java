package refactoring_guru.abstract_factory.example;

import refactoring_guru.abstract_factory.example.app.Application;
import refactoring_guru.abstract_factory.example.factories.GUIFactory;
import refactoring_guru.abstract_factory.example.factories.MacOSFactory;
import refactoring_guru.abstract_factory.example.factories.WindowsFactory;

/**
 * EN: Demo class. Everything comes together here.
 *
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {

    /**
     * EN: Application picks the factory type and creates it in run time
     * (usually at initialization stage), depending on the configuration or
     * environment variables.
     *
     * RU: Приложение выбирает тип и создаёт конкретные фабрики динамически
     * исходя из конфигурации или окружения.
     */
    private static Application configureApplication() {
        return null;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
