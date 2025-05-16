package com.ifsc.listplanetas;

import java.util.ArrayList;
import java.util.List;

public class PlanetaDAO {

    List<Planeta> planetas;

    public PlanetaDAO() {
        planetas = new ArrayList<>(List.of(
                new Planeta("Sol", R.drawable.sun),
                new Planeta("Mercúrio", R.drawable.mercury),
                new Planeta("Vênus", R.drawable.venus),
                new Planeta("Terra", R.drawable.earth),
                new Planeta("Marte", R.drawable.mars),
                new Planeta("Júpiter", R.drawable.jupter),
                new Planeta("Saturno", R.drawable.saturn),
                new Planeta("Urano", R.drawable.uranus),
                new Planeta("Netuno", R.drawable.neptune)
        ));
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }
}
