package com.raphaowl.dnd.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.DamageEnum;
import com.raphaowl.dnd.enums.MonsterEnum;
import com.raphaowl.dnd.enums.MonsterNameEnum;
import com.raphaowl.dnd.enums.MonsterSubtypeEnum;
import com.raphaowl.dnd.enums.MonsterTypeEnum;

import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Monster(
        String index,
        MonsterNameEnum name,
        MonsterEnum size,
        MonsterTypeEnum type,
        String subtype,
        AlignmentEnum alignment,
        @JsonProperty("hit_points") Integer hitPoints,
        @JsonProperty("hit_dice") String hitDice,
        @JsonProperty("hit_points_roll") String hitPointsRoll,
        @JsonProperty("challenge_rating") Double challengeRating,
        Integer strength,
        Integer dexterity,
        Integer constitution,
        Integer intelligence,
        Integer wisdom,
        Integer charisma,
        @JsonProperty("xp") Integer experience,
        @JsonProperty("damage_vulnerabilities") List<DamageEnum> damageVulnerabilities,
        @JsonProperty("damage_resistances") List<DamageEnum> damageResistances,
        @JsonProperty("damage_immunities") List<DamageEnum> damageImmunities,
        @JsonProperty("condition_immunities") List<ConditionImmunities> conditionImmunities,
        String languages,
        String image
) {
    private static final String BASE_URL = "https://www.dnd5eapi.co";

    public String imageUrl() {
        return image != null ? BASE_URL + image : null;
    }

    public String ptSubtype() {
        if (subtype == null || subtype.isBlank()) {
            return null;
        }
        return MonsterSubtypeEnum.fromName(subtype).getPtName();
    }

    public String getChallengeRatingFormatted() {
        double cr = this.challengeRating.doubleValue();
        if (cr == 0.125) return "1/8";
        if (cr == 0.25) return "1/4";
        if (cr == 0.5) return "1/2";
        // Para CRs inteiros, retorne o inteiro
        if (cr == Math.floor(cr)) return String.valueOf((int)cr);
        return String.valueOf(cr);
    }

    public String getChallengeRatingStars() {
        double cr = this.challengeRating;

        if (cr <= 1.0) {
            return "★";
        } else if (cr < 5.0) {
            return "★★";
        } else if (cr < 10.0) {
            return "★★★";
        } else if (cr < 16.0) {
            return "★★★★";
        } else {
            return "★★★★★";
        }
    }
}
