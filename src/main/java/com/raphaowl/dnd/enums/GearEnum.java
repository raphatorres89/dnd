package com.raphaowl.dnd.enums;

import com.raphaowl.dnd.dtos.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GearEnum {

    // ---------- ADVENTURING GEAR ----------
    BACKPACK("Backpack", 2.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    BEDROLL("Bedroll", 1.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    BLANKET("Blanket", 0.5, 3.0, GearTypeEnum.ADVENTURING_GEAR),
    BLOCK_AND_TACKLE("Block and Tackle", 1.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    CANDLE("Candle", 0.01, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    CHAIN("Chain (10 feet)", 5.0, 10.0, GearTypeEnum.ADVENTURING_GEAR),
    CHALK("Chalk (1 piece)", 0.01, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    CLIMBER_KIT("Climber’s Kit", 25.0, 12.0, GearTypeEnum.ADVENTURING_GEAR),
    COMPONENT_POUCH("Component Pouch", 25.0, 2.0, GearTypeEnum.ADVENTURING_GEAR),
    CROWBAR("Crowbar", 2.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    GRAPPLING_HOOK("Grappling Hook", 2.0, 4.0, GearTypeEnum.ADVENTURING_GEAR),
    HAMMER("Hammer", 1.0, 3.0, GearTypeEnum.ADVENTURING_GEAR),
    HEALER_KIT("Healer’s Kit", 5.0, 3.0, GearTypeEnum.ADVENTURING_GEAR),
    HOLY_SYMBOL("Holy Symbol", 5.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    HOLY_WATER("Holy Water (flask)", 25.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    HOURGLASS("Hourglass", 25.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    HUNTING_TRAP("Hunting Trap", 5.0, 25.0, GearTypeEnum.ADVENTURING_GEAR),
    INK("Ink (1 ounce bottle)", 10.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    INK_PEN("Ink Pen", 0.02, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    LADDER("Ladder (10-foot)", 0.1, 25.0, GearTypeEnum.ADVENTURING_GEAR),
    LAMP("Lamp", 0.5, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    LANTERN_BULLSEYE("Bullseye Lantern", 10.0, 2.0, GearTypeEnum.ADVENTURING_GEAR),
    LANTERN_HOODED("Hooded Lantern", 5.0, 2.0, GearTypeEnum.ADVENTURING_GEAR),
    LOCK("Lock", 10.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    MAGNIFYING_GLASS("Magnifying Glass", 100.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    MANACLES("Manacles", 2.0, 6.0, GearTypeEnum.ADVENTURING_GEAR),
    MESS_KIT("Mess Kit", 0.2, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    MIRROR("Steel Mirror", 5.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    OIL("Oil (flask)", 0.1, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    PAPER("Paper (one sheet)", 0.2, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    PARCHMENT("Parchment (one sheet)", 0.1, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    PERFUME("Perfume (vial)", 5.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    PICK_MINER("Miner’s Pick", 2.0, 10.0, GearTypeEnum.ADVENTURING_GEAR),
    PITON("Piton", 0.05, 0.25, GearTypeEnum.ADVENTURING_GEAR),
    POLE("Pole (10-foot)", 0.05, 7.0, GearTypeEnum.ADVENTURING_GEAR),
    POT_IRON("Iron Pot", 2.0, 10.0, GearTypeEnum.ADVENTURING_GEAR),
    POTION_HEALING("Potion of Healing", 50.0, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    ROPE_HEMPEN("Rope, Hempen (50 feet)", 1.0, 10.0, GearTypeEnum.ADVENTURING_GEAR),
    ROPE_SILK("Rope, Silk (50 feet)", 10.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    SACK("Sack", 0.01, 0.5, GearTypeEnum.ADVENTURING_GEAR),
    SHOVEL("Shovel", 2.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    SIGNAL_WHISTLE("Signal Whistle", 0.05, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    SIGNET_RING("Signet Ring", 5.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    SOAP("Soap", 0.02, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    SPELLBOOK("Spellbook", 50.0, 3.0, GearTypeEnum.ADVENTURING_GEAR),
    SPIKES_IRON("Iron Spikes (10)", 1.0, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    SPYGLASS("Spyglass", 1000.0, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    TENT("Tent, Two-person", 2.0, 20.0, GearTypeEnum.ADVENTURING_GEAR),
    TINDERBOX("Tinderbox", 0.5, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    TORCH("Torch", 0.01, 1.0, GearTypeEnum.ADVENTURING_GEAR),
    VIAL("Vial", 1.0, 0.0, GearTypeEnum.ADVENTURING_GEAR),
    WATERSKIN("Waterskin", 0.2, 5.0, GearTypeEnum.ADVENTURING_GEAR),
    WHETSTONE("Whetstone", 0.01, 1.0, GearTypeEnum.ADVENTURING_GEAR),

    // ---------- CONTAINERS ----------
    CHEST("Chest", 5.0, 25.0, GearTypeEnum.CONTAINER),
    CASE_MAP_SCROLL("Case, Map or Scroll", 1.0, 1.0, GearTypeEnum.CONTAINER),
    FLASK("Flask or Tankard", 0.02, 1.0, GearTypeEnum.CONTAINER),
    JUG("Jug or Pitcher", 0.02, 4.0, GearTypeEnum.CONTAINER),
    POUCH("Pouch", 0.5, 1.0, GearTypeEnum.CONTAINER),
    WATERSKIN_CONTAINER("Waterskin", 0.2, 5.0, GearTypeEnum.CONTAINER),

    // ---------- CLOTHING ----------
    CLOTHES_COMMON("Clothes, Common", 0.5, 3.0, GearTypeEnum.CLOTHING),
    CLOTHES_COSTUME("Clothes, Costume", 5.0, 4.0, GearTypeEnum.CLOTHING),
    CLOTHES_FINE("Clothes, Fine", 15.0, 6.0, GearTypeEnum.CLOTHING),
    CLOTHES_TRAVELER("Clothes, Traveler’s", 2.0, 4.0, GearTypeEnum.CLOTHING),

    // ---------- AMMUNITION ----------
    ARROWS("Arrows (20)", 1.0, 1.0, GearTypeEnum.AMMUNITION),
    BLOWGUN_NEEDLES("Blowgun Needles (50)", 1.0, 1.0, GearTypeEnum.AMMUNITION),
    CROSSBOW_BOLTS("Crossbow Bolts (20)", 1.0, 1.5, GearTypeEnum.AMMUNITION),
    SLING_BULLETS("Sling Bullets (20)", 0.04, 1.5, GearTypeEnum.AMMUNITION),

    // ---------- TRADE GOODS ----------
    WHEAT("Wheat (1 lb)", 0.01, 1.0, GearTypeEnum.TRADE_GOOD),
    SALT("Salt (1 lb)", 0.05, 1.0, GearTypeEnum.TRADE_GOOD),
    IRON("Iron (1 lb)", 0.1, 1.0, GearTypeEnum.TRADE_GOOD),
    WOOD("Wood (1 lb)", 0.01, 1.0, GearTypeEnum.TRADE_GOOD),
    SILK("Silk (1 sq yard)", 10.0, 0.5, GearTypeEnum.TRADE_GOOD),
    SPICES("Spices (1 lb)", 1.0, 1.0, GearTypeEnum.TRADE_GOOD),
    GOLD("Gold (1 lb)", 50.0, 1.0, GearTypeEnum.TRADE_GOOD),

    // ---------- MOUNTS ----------
    HORSE_DRAFT("Horse, Draft", 50.0, 540.0, GearTypeEnum.MOUNT),
    HORSE_RIDING("Horse, Riding", 75.0, 480.0, GearTypeEnum.MOUNT),
    CAMEL("Camel", 50.0, 480.0, GearTypeEnum.MOUNT),
    PONY("Pony", 30.0, 225.0, GearTypeEnum.MOUNT),
    WARHORSE("Warhorse", 400.0, 540.0, GearTypeEnum.MOUNT),

    // ---------- VEHICLES ----------
    CART("Cart", 15.0, 200.0, GearTypeEnum.VEHICLE),
    WAGON("Wagon", 35.0, 400.0, GearTypeEnum.VEHICLE),
    SHIP_GALLEY("Galley", 30000.0, 0.0, GearTypeEnum.VEHICLE),
    SHIP_SAILING("Sailing Ship", 10000.0, 0.0, GearTypeEnum.VEHICLE),
    SHIP_ROWBOAT("Rowboat", 50.0, 100.0, GearTypeEnum.VEHICLE),

    // ---------- PACKS ----------
    DIPLOMAT_PACK("Diplomat's Pack", 40.0, 12.0, GearTypeEnum.ADVENTURING_GEAR),
    ADVENTURER_PACK("Adventurer's Pack", 39.0, 12.0, GearTypeEnum.ADVENTURING_GEAR),
    ENTERTAINER_PACK("Entertainer's Pack", 40.0, 11.0, GearTypeEnum.ADVENTURING_GEAR),
    PRIEST_PACK("Priest's Pack", 19.0, 11.0, GearTypeEnum.ADVENTURING_GEAR),
    SCHOLAR_PACK("Scholar's Pack", 40.0, 11.0, GearTypeEnum.ADVENTURING_GEAR),
    EXPLORER_PACK("Explorer's Pack", 50.0, 13.0, GearTypeEnum.ADVENTURING_GEAR);

    private final String name;
    private final Double price;
    private final Double weight;
    private final GearTypeEnum type;

    public Item toItem(Integer quantity) {
        return new Item(quantity, this.name(), price, weight);
    }
}
