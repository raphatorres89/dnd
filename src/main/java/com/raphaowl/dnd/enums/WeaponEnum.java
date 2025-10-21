package com.raphaowl.dnd.enums;

import java.util.List;
import java.util.stream.Stream;

import com.raphaowl.dnd.dtos.Attack;
import com.raphaowl.dnd.dtos.Weapon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WeaponEnum {
    // ---------- SIMPLE MELEE ----------
    DAGGER("Dagger", WeaponType.SIMPLE_MELEE, "1d4", DamageEnum.PIERCING, true, false, false, 0.5, 2.0),
    JAVELIN("Javelin", WeaponType.SIMPLE_MELEE, "1d6", DamageEnum.PIERCING, false, false, false, 1.0, 0.5),
    SICKLE("Sickle", WeaponType.SIMPLE_MELEE, "1d4", DamageEnum.SLASHING, false, false, false, 1.0, 1.0),
    QUARTERSTAFF("Quarterstaff", WeaponType.SIMPLE_MELEE, "1d6", DamageEnum.BLUDGEONING, false, false, true, 2.0, 2.0),
    GREATCLUB("Greatclub", WeaponType.SIMPLE_MELEE, "1d8", DamageEnum.BLUDGEONING, false, true, false, 5.0, 2.0),
    SPEAR("Spear", WeaponType.SIMPLE_MELEE, "1d6", DamageEnum.PIERCING, false, false, true, 1.5, 1.0),
    MACE("Mace", WeaponType.SIMPLE_MELEE, "1d6", DamageEnum.BLUDGEONING, false, false, false, 2.0, 5.0),
    HANDAXE("Handaxe", WeaponType.SIMPLE_MELEE, "1d6", DamageEnum.SLASHING, false, false, true, 1.0, 5.0),
    LIGHT_HAMMER("Light Hammer", WeaponType.SIMPLE_MELEE, "1d4", DamageEnum.BLUDGEONING, false, false, false, 1.0, 2.0),
    CLUB("Club", WeaponType.SIMPLE_MELEE, "1d4", DamageEnum.BLUDGEONING, false, false, false, 1.0, 0.2),

    // ---------- SIMPLE RANGED ----------
    SHORTBOW("Shortbow", WeaponType.SIMPLE_RANGED, "1d6", DamageEnum.PIERCING, false, false, false, 1.0, 25.0),
    LIGHT_CROSSBOW("Light Crossbow", WeaponType.SIMPLE_RANGED, "1d8", DamageEnum.PIERCING, false, false, false, 2.5, 25.0),
    DART("Dart", WeaponType.SIMPLE_RANGED, "1d4", DamageEnum.PIERCING, true, false, false, 0.1, 0.05),
    SLING("Sling", WeaponType.SIMPLE_RANGED, "1d4", DamageEnum.BLUDGEONING, false, false, false, 0.0, 0.01),

    // ---------- MARTIAL MELEE ----------
    HALBERD("Halberd", WeaponType.MARTIAL_MELEE, "1d10", DamageEnum.SLASHING, false, true, false, 3.0, 20.0),
    SCIMITAR("Scimitar", WeaponType.MARTIAL_MELEE, "1d6", DamageEnum.SLASHING, true, false, false, 1.5, 25.0),
    WHIP("Whip", WeaponType.MARTIAL_MELEE, "1d4", DamageEnum.SLASHING, true, false, false, 1.5, 2.0),
    SHORTSWORD("Shortsword", WeaponType.MARTIAL_MELEE, "1d6", DamageEnum.PIERCING, true, false, false, 1.0, 10.0),
    GREATSWORD("Greatsword", WeaponType.MARTIAL_MELEE, "2d6", DamageEnum.SLASHING, false, true, false, 3.0, 50.0),
    LONGSWORD("Longsword", WeaponType.MARTIAL_MELEE, "1d8", DamageEnum.SLASHING, false, false, true, 1.5, 15.0),
    GLAIVE("Glaive", WeaponType.MARTIAL_MELEE, "1d10", DamageEnum.SLASHING, false, true, false, 3.0, 20.0),
    LANCE("Lance", WeaponType.MARTIAL_MELEE, "1d12", DamageEnum.PIERCING, false, false, false, 3.0, 10.0),
    PIKE("Pike", WeaponType.MARTIAL_MELEE, "1d10", DamageEnum.PIERCING, false, true, false, 4.0, 5.0),
    MORNINGSTAR("Morningstar", WeaponType.MARTIAL_MELEE, "1d8", DamageEnum.PIERCING, false, false, false, 2.0, 15.0),
    GREATAXE("Greataxe", WeaponType.MARTIAL_MELEE, "1d12", DamageEnum.SLASHING, false, true, false, 3.5, 30.0),
    BATTLEAXE("Battleaxe", WeaponType.MARTIAL_MELEE, "1d8", DamageEnum.SLASHING, false, false, true, 2.0, 10.0),
    MAUL("Maul", WeaponType.MARTIAL_MELEE, "2d6", DamageEnum.BLUDGEONING, false, true, false, 5.0, 10.0),
    FLAIL("Flail", WeaponType.MARTIAL_MELEE, "1d8", DamageEnum.BLUDGEONING, false, false, false, 1.0, 10.0),
    WARHAMMER("Warhammer", WeaponType.MARTIAL_MELEE, "1d8", DamageEnum.BLUDGEONING, false, false, true, 1.0, 15.0),
    WAR_PICK("War Pick", WeaponType.MARTIAL_MELEE, "1d8", DamageEnum.PIERCING, false, false, false, 1.0, 5.0),
    RAPIER("Rapier", WeaponType.MARTIAL_MELEE, "1d8", DamageEnum.PIERCING, true, false, false, 1.0, 25.0),
    TRIDENT("Trident", WeaponType.MARTIAL_MELEE, "1d6", DamageEnum.PIERCING, false, false, true, 2.0, 5.0),

    // ---------- MARTIAL RANGED ----------
    LONGBOW("Longbow", WeaponType.MARTIAL_RANGED, "1d8", DamageEnum.PIERCING, false, true, false, 1.0, 50.0),
    HAND_CROSSBOW("Hand Crossbow", WeaponType.MARTIAL_RANGED, "1d6", DamageEnum.PIERCING, false, false, false, 1.5, 75.0),
    HEAVY_CROSSBOW("Heavy Crossbow", WeaponType.MARTIAL_RANGED, "1d10", DamageEnum.PIERCING, false, true, false, 4.5, 50.0),
    NET("Net", WeaponType.MARTIAL_RANGED, "—", DamageEnum.EMPTY, false, false, false, 1.5, 1.0),
    BLOWGUN("Blowgun", WeaponType.MARTIAL_RANGED, "1", DamageEnum.PIERCING, false, false, false, 0.5, 10.0);

    private final String displayName;
    private final WeaponType type;
    private final String damageDice;
    private final DamageEnum damageType;
    private final boolean finesse;
    private final boolean twoHanded;
    private final boolean versatile;
    private final Double weight;
    private final Double price;

    public Weapon toWeapon(Integer quantity) {
        return new Weapon(quantity, this.name(), price, weight, new Attack(damageDice, damageType, finesse, twoHanded, versatile), type);
    }

    public static List<WeaponEnum> getByType(WeaponType weaponType) {
        return Stream.of(values())
                .filter(weapon -> weapon.getType() == weaponType)
                .toList();
    }
}
