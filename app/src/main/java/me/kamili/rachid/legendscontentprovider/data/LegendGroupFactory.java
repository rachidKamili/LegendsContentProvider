package me.kamili.rachid.legendscontentprovider.data;

import java.util.ArrayList;
import java.util.List;

import me.kamili.rachid.legendscontentprovider.model.LegendGroup;

public class LegendGroupFactory {

    public static List<LegendGroup> createLegendGroups() {
        List<LegendGroup> legendGroups = new ArrayList<>();

        legendGroups.add(new LegendGroup("Tanks", "CAN TAKE IT",
                "Resilient bruisers, Tanks excel at shrugging off blows that would obliterate lesser allies.",
                "http://vignette.wikia.nocookie.net/leagueoflegends/images/5/5a/Tank_icon.png",
                "http://lolstatic-a.akamaihd.net/frontpage/apps/prod/playnow-global/en_US/7e291d303c042e243dbfb8a1479cb8c0b1438a4b/assets/img/champions_tanks.jpg"));
        legendGroups.add(new LegendGroup("Fighters", "LOVE TO DUEL",
                "A balance of power and defense, Fighters are born to brawl, preferring their bouts up close and personal.",
                "http://vignette.wikia.nocookie.net/leagueoflegends/images/8/8f/Fighter_icon.png",
                "http://lolstatic-a.akamaihd.net/frontpage/apps/prod/playnow-global/en_US/7e291d303c042e243dbfb8a1479cb8c0b1438a4b/assets/img/champions_fighter.jpg"));
        legendGroups.add(new LegendGroup("Mages", "SURGE WITH POWER",
                "Aggressive casters, Mages seek to destroy opponents through a range of mystical attacks, spells and abilities.",
                "http://vignette.wikia.nocookie.net/leagueoflegends/images/2/28/Mage_icon.png",
                "http://lolstatic-a.akamaihd.net/frontpage/apps/prod/playnow-global/en_US/7e291d303c042e243dbfb8a1479cb8c0b1438a4b/assets/img/champions_mages.jpg"));
        legendGroups.add(new LegendGroup("Assassins", "CRAVE THE HUNT",
                "Masters of precision, Assassins are agile hunters on the lookout for the perfect kill.",
                "http://vignette.wikia.nocookie.net/leagueoflegends/images/2/28/Slayer_icon.png",
                "http://lolstatic-a.akamaihd.net/frontpage/apps/prod/playnow-global/en_US/7e291d303c042e243dbfb8a1479cb8c0b1438a4b/assets/img/champions_assassins.jpg"));
        legendGroups.add(new LegendGroup("Marksmen", "BRING THE PAIN",
                "Ranged fighters, Marksmen are powerful but fragile. While they rely on their team to soak up damage, teams rely on them to deal it.",
                "http://vignette.wikia.nocookie.net/leagueoflegends/images/7/7f/Marksman_icon.png",
                "http://lolstatic-a.akamaihd.net/frontpage/apps/prod/playnow-global/en_US/7e291d303c042e243dbfb8a1479cb8c0b1438a4b/assets/img/champions_marksmen.jpg"));
        legendGroups.add(new LegendGroup("Supports", "HAVE YOUR BACK",
                "Stalwart defenders, Supports control the battlefield by augmenting allies and locking down enemies.",
                "http://vignette.wikia.nocookie.net/leagueoflegends/images/5/58/Controller_icon.png",
                "http://lolstatic-a.akamaihd.net/frontpage/apps/prod/playnow-global/en_US/7e291d303c042e243dbfb8a1479cb8c0b1438a4b/assets/img/champions_support.jpg"));

        return legendGroups;
    }
}
