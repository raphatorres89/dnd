package com.raphaowl.dnd.enums;

import com.raphaowl.dnd.dtos.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GearEnum {

    // ---------- ADVENTURING GEAR ----------
    BONE_DICE("Bone Dice", 1.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    BLANKET("Blanket", 0.5, 3.0, GearTypeEnum.ADVENTURING_GEAR),
    CARD_DECK("Deck of Cards", 1.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    COMPONENT_POUCH("Component Pouch", 25.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    CROWBAR("Crowbar", 2.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    ENEMY_TROPHY("Enemy Trophy", 1.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    GRIMOIRE("Grimoire", 50.0, 1.5, GearTypeEnum.ADVENTURING_GEAR),
    GUILD_LETTER("Guild Letter", 1.0, 0.1, GearTypeEnum.ADVENTURING_GEAR),
    HOLY_SYMBOL_AMULET("Holy Symbol (Amulet)", 5.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    HOLY_SYMBOL_EMBLEM("Holy Symbol (Emblem)", 5.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    HOLY_SYMBOL_RELIQUARY("Holy Symbol (Reliquary)", 5.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    HUNTING_TRAP("Hunting Trap", 5.0, 25.0, GearTypeEnum.ADVENTURING_GEAR),
    INK_BOTTLE("Ink Bottle", 10.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    JEWELRY("Jewelry", 25.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    LETTER_FROM_DECEASED_COLLEAGUE("Letter from Deceased Colleague", 0.5, 0.1, GearTypeEnum.ADVENTURING_GEAR),
    LINEAGE_SCROLL("Lineage Scroll", 100.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    LOCK_OF_HAIR("Lock of Hair", 0.5, 0.1, GearTypeEnum.ADVENTURING_GEAR),
    LOVE_LETTER("Love Letter", 0.5, 0.1, GearTypeEnum.ADVENTURING_GEAR),
    MAP_CITY("Map, City", 5.0, 0.1, GearTypeEnum.ADVENTURING_GEAR),
    PARCHMENT("Parchment (one sheet)", 0.1, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    PET_MOUSE("Pet Mouse", 0.5, 0.2, GearTypeEnum.ADVENTURING_GEAR),
    POT_IRON("Iron Pot", 2.0, 10.0, GearTypeEnum.ADVENTURING_GEAR),
    QUIVER("Quiver", 1.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    QUILL("Quill", 0.02, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    SHOVEL("Shovel", 2.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    SIGNET_RING("Signet Ring", 5.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    SMALL_KNIFE("Small Knife", 1.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    SOLDIER_INSIGNIA("Soldier's Insignia", 1.0, 0.1, GearTypeEnum.ADVENTURING_GEAR),
    TOKEN_PARENTS("Token to Remember Parents By", 1.0, 0.1, GearTypeEnum.ADVENTURING_GEAR),
    ROPE_SILK("Rope, Silk (50 feet)", 10.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),

    // ---------- CONTAINERS ----------
    CASE_MAP_SCROLL("Case, Map or Scroll", 1.0, 1.0, GearTypeEnum.CONTAINER),
    POUCH("Pouch", 0.5, 1.0, GearTypeEnum.CONTAINER),

    // ---------- CLOTHING ----------
    CLOTHES_COMMON("Clothes, Common", 0.5, 3.0, GearTypeEnum.CLOTHING),
    CLOTHES_COSTUME("Clothes, Costume", 5.0, 4.0, GearTypeEnum.CLOTHING),
    CLOTHES_FINE("Clothes, Fine", 15.0, 6.0, GearTypeEnum.CLOTHING),
    CLOTHES_TRAVELER("Clothes, Traveler’s", 2.0, 4.0, GearTypeEnum.CLOTHING),

    // ---------- AMMUNITION ----------
    ARROWS("Arrows (20)", 1.0, 0.5, GearTypeEnum.AMMUNITION),
    CROSSBOW_BOLTS("Crossbow Bolts (20)", 1.0, 0.75, GearTypeEnum.AMMUNITION),

    // ---------- TRADE GOODS ----------
    GOLD("Gold (1 lb)", 1.0, 0.01, GearTypeEnum.TRADE_GOOD),

    // ---------- PACKS ----------
    DIPLOMAT_PACK("Diplomat's Pack", 40.0, 20.0, GearTypeEnum.PACK),
    ADVENTURER_PACK("Adventurer's Pack", 39.0, 27.8, GearTypeEnum.PACK),
    ENTERTAINER_PACK("Entertainer's Pack", 40.0, 17.0, GearTypeEnum.PACK),
    PRIEST_PACK("Priest's Pack", 19.0, 11.3, GearTypeEnum.PACK),
    SCHOLAR_PACK("Scholar's Pack", 40.0, 5.0, GearTypeEnum.PACK),
    EXPLORER_PACK("Explorer's Pack", 50.0, 26.7, GearTypeEnum.PACK),
    BURGLARS_PACK("Burglar's Pack", 16.0, 21.5, GearTypeEnum.PACK),

    // ---------- FOCUSES ----------
    DRUIDIC_FOCUS_SPRIG("Sprig of Mistletoe", 1.0, 0.0, GearTypeEnum.FOCUS),
    DRUIDIC_FOCUS_TOTEM("Totem", 1.0, 0.0, GearTypeEnum.FOCUS),
    DRUIDIC_FOCUS_WOODEN_STAFF("Wooden Staff", 5.0, 2.0, GearTypeEnum.FOCUS),
    DRUIDIC_FOCUS_YEW_WAND("Yew Wand", 10.0, 0.5, GearTypeEnum.FOCUS),

    ARCANE_FOCUS_CRYSTAL("Crystal", 10.0, 0.5, GearTypeEnum.FOCUS),
    ARCANE_FOCUS_ORB("Orb", 20.0, 1.5, GearTypeEnum.FOCUS),
    ARCANE_FOCUS_ROD("Rod", 10.0, 1.0, GearTypeEnum.FOCUS),
    ARCANE_FOCUS_STAFF("Staff", 5.0, 2.0, GearTypeEnum.FOCUS),
    ARCANE_FOCUS_WAND("Wand", 10.0, 1.0, GearTypeEnum.FOCUS);

    private final String name;
    private final Double price;
    private final Double weight;
    private final GearTypeEnum type;

    public Item toItem(Integer quantity) {
        return new Item(quantity, this.name(), price, weight, type.getIconClass());
    }
}
