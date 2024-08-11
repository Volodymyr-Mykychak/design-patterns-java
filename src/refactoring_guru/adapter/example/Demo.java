package refactoring_guru.adapter.example;

import refactoring_guru.adapter.example.adapters.SquarePegAdapter;
import refactoring_guru.adapter.example.round.RoundHole;
import refactoring_guru.adapter.example.round.RoundPeg;
import refactoring_guru.adapter.example.square.SquarePeg;

/**
 * EN: Somewhere in client code...
 *
 * RU: Где-то в клиентском коде...
 */
public class Demo {
    public static void main(String[] args) {
        // EN: Round fits round, no surprise.
        //
        // RU: Круглое к круглому — всё работает.

        // EN: hole.fits(smallSqPeg); // Won't compile.
        //
        // RU: hole.fits(smallSqPeg); // Не скомпилируется.

        // EN: Adapter solves the problem.
        //
        // RU: Адаптер решит проблему.
    }
}
