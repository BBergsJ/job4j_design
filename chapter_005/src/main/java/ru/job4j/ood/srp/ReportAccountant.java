package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportAccountant implements Report {

    private Store store;

    public ReportAccountant(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
