package com.raphaowl.dnd.enums;

import java.util.List;
import java.util.stream.Stream;

import com.raphaowl.dnd.dtos.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ToolEnum {
    // ---------- ARTISAN'S TOOLS ----------
    ALCHEMIST_SUPPLIES("Alchemist’s Supplies", ToolTypeEnum.ARTISAN, 50.0, 8.0),
    BREWER_SUPPLIES("Brewer’s Supplies", ToolTypeEnum.ARTISAN, 20.0, 9.0),
    CALLIGRAPHER_SUPPLIES("Calligrapher’s Supplies", ToolTypeEnum.ARTISAN, 10.0, 5.0),
    CARPENTER_TOOLS("Carpenter’s Tools", ToolTypeEnum.ARTISAN, 8.0, 6.0),
    CARTOGRAPHER_TOOLS("Cartographer’s Tools", ToolTypeEnum.ARTISAN, 15.0, 6.0),
    COBBLER_TOOLS("Cobbler’s Tools", ToolTypeEnum.ARTISAN, 5.0, 5.0),
    COOK_UTENSILS("Cook’s Utensils", ToolTypeEnum.ARTISAN, 1.0, 8.0),
    GLASSBLOWER_TOOLS("Glassblower’s Tools", ToolTypeEnum.ARTISAN, 30.0, 5.0),
    JEWELER_TOOLS("Jeweler’s Tools", ToolTypeEnum.ARTISAN, 25.0, 2.0),
    LEATHERWORKER_TOOLS("Leatherworker’s Tools", ToolTypeEnum.ARTISAN, 5.0, 5.0),
    MASON_TOOLS("Mason’s Tools", ToolTypeEnum.ARTISAN, 10.0, 8.0),
    PAINTER_SUPPLIES("Painter’s Supplies", ToolTypeEnum.ARTISAN, 10.0, 5.0),
    POTTER_TOOLS("Potter’s Tools", ToolTypeEnum.ARTISAN, 10.0, 3.0),
    SMITH_TOOLS("Smith’s Tools", ToolTypeEnum.ARTISAN, 20.0, 8.0),
    TINKER_TOOLS("Tinker’s Tools", ToolTypeEnum.ARTISAN, 50.0, 10.0),
    WEAVER_TOOLS("Weaver’s Tools", ToolTypeEnum.ARTISAN, 1.0, 5.0),
    WOODCARVER_TOOLS("Woodcarver’s Tools", ToolTypeEnum.ARTISAN, 1.0, 5.0),

    // ---------- MUSICAL INSTRUMENTS ----------
    BAGPIPES("Bagpipes", ToolTypeEnum.MUSICAL, 30.0, 6.0),
    DRUM("Drum", ToolTypeEnum.MUSICAL, 6.0, 3.0),
    DULCIMER("Dulcimer", ToolTypeEnum.MUSICAL, 25.0, 10.0),
    FLUTE("Flute", ToolTypeEnum.MUSICAL, 2.0, 1.0),
    LUTE("Lute", ToolTypeEnum.MUSICAL, 35.0, 2.0),
    LYRE("Lyre", ToolTypeEnum.MUSICAL, 30.0, 2.0),
    HORN("Horn", ToolTypeEnum.MUSICAL, 3.0, 2.0),
    PAN_FLUTE("Pan Flute", ToolTypeEnum.MUSICAL, 12.0, 2.0),
    SHAWM("Shawm", ToolTypeEnum.MUSICAL, 2.0, 1.0),
    VIOL("Viol", ToolTypeEnum.MUSICAL, 30.0, 1.0),

    // ---------- GENERAL TOOLS ----------
    DISGUISE_KIT("Disguise Kit", ToolTypeEnum.GENERAL, 25.0, 3.0),
    HERBALISM_KIT("Herbalism Kit", ToolTypeEnum.GENERAL, 5.0, 3.0),
    THIEVES_TOOLS("Thieves’ Tools", ToolTypeEnum.GENERAL, 25.0, 1.0),

    // ----- FIELDS -----
    BOTTLE_FILLED_COLORED_LIQUIDS("Bottle Filled with Colored Liquids", ToolTypeEnum.CHEATING, 10.0, 0.5),
    RIGGED_DICE("Rigged Dice", ToolTypeEnum.CHEATING, 1.0, 0.0),
    MARKED_CARDS("Marked Deck of Cards", ToolTypeEnum.CHEATING, 5.0, 0.0),
    SIGNET_RING_OF_FICTITIOUS_DUKE("Signet Ring of Fictitious Duke", ToolTypeEnum.CHEATING, 100.0, 0.1);

    private final String name;
    private final ToolTypeEnum type;
    private final Double price;
    private final Double weight;

    public Item toItem(Integer quantity) {
        return new Item(quantity, this.name(), price, weight, type.getIconClass());
    }

    public static List<ToolEnum> getByType(ToolTypeEnum type) {
        return Stream.of(values())
                .filter(tool -> tool.getType() == type)
                .toList();
    }
}
