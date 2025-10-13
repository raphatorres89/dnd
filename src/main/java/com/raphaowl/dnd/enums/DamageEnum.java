package com.raphaowl.dnd.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DamageEnum {

    // Danos Elementais/Mágicos/Simples
    ACID("acid", "ra ra-acid text-success"),
    COLD("cold", "ra ra-snowflake .text-secondary"),
    LIGHTNING("lightning", "ra ra-lightning-bolt text-warning"),
    SLASHING("slashing", "ra ra-spinning-sword text-secondary"),
    FIRE("fire", "ra ra-fire text-danger"),
    POISON("poison", "ra ra-vial text-success"),
    PSYCHIC("psychic", "ra ra-brain-freeze text-warning"),
    THUNDER("thunder", "ra ra-focused-lightning text-warning"),
    BLUDGEONING("bludgeoning", "ra ra-broken-bone text-secondary"),
    PIERCING("piercing", "ra ra-spear-head text-secondary"),
    DAMAGE_FROM_SPELLS("damage from spells", "ra ra-blaster text-primary" ),
    RADIANT("radiant", "ra ra-sunbeams text-warning"),

    // Resistências Físicas Complexas (ex: Imunidade a armas não-mágicas)
    NONMAGICAL_WEAPONS_3P("bludgeoning, piercing, and slashing from nonmagical weapons", "ra ra-lightning-sword text-info"),
    NONMAGICAL_ADAMANTINE("bludgeoning, piercing, and slashing from nonmagical weapons that aren't adamantine", "ra ra-lightning-sword text-info"),
    NONMAGICAL_SILVER("bludgeoning, piercing, and slashing from nonmagical weapons that aren't silvered", "ra ra-lightning-sword text-info"),
    NONMAGICAL_STONESKIN("bludgeoning, piercing, and slashing from nonmagical attacks (from stoneskin)", "ra ra-lightning-sword text-info"),
    NONMAGICAL_ATTACKS("bludgeoning, piercing, and slashing from nonmagical attacks", "ra ra-lightning-sword text-info");

    private final String damageType;
    private final String iconClass;

    @JsonCreator
    public static DamageEnum fromString(String value) {
        if (value == null) {
            return null;
        }
        String normalized = value.trim().toLowerCase();

        return Stream.of(DamageEnum.values())
                .filter(g -> g.name().toLowerCase().equals(normalized) ||
                        g.getDamageType().toLowerCase().equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dano não reconhecido: " + value));
    }
}