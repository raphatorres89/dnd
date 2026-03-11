package com.raphaowl.dnd.clients.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SpellData(
        String slug,
        String name,
        String desc,
        @JsonProperty("higher_level")
        String higherLevel,
        String page,
        String range,
        @JsonProperty("target_range_sort")
        Integer targetRangeSort,
        String components,
        @JsonProperty("requires_verbal_components")
        Boolean requiresVerbalComponents,
        @JsonProperty("requires_somatic_components")
        Boolean requiresSomaticComponents,
        @JsonProperty("requires_material_components")
        Boolean requiresMaterialComponents,
        String material,
        @JsonProperty("can_be_cast_as_ritual")
        Boolean canBeCastAsRitual,
        String ritual,
        String duration,
        String concentration,
        @JsonProperty("requires_concentration")
        Boolean requiresConcentration,
        @JsonProperty("casting_time")
        String castingTime,
        String level,
        @JsonProperty("level_int")
        Integer levelInt,
        @JsonProperty("spell_level")
        Integer spellLevel,
        String school,
        @JsonProperty("dnd_class")
        String dndClass,
        @JsonProperty("spell_lists")
        List<String> spellLists,
        String archetype,
        String circles,
        @JsonProperty("document__slug")
        String documentSlug,
        @JsonProperty("document__title")
        String documentTitle,
        @JsonProperty("document__license_url")
        String documentLicenseUrl,
        @JsonProperty("document__url")
        String documentUrl
) {}