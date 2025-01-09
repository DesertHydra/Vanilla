/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package deserthydra.vanilla;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class VanillaMod implements ModInitializer {
	@Override
	public void onInitialize() {
		LootTableEvents.REPLACE.register((key, original, source, registries) -> {
			if (key.equals(BuiltInLootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY) && source == LootTableSource.VANILLA) {
				return LootTable.lootTable()
					.withPool(
						LootPool.lootPool()
							.setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(Items.ANGLER_POTTERY_SHERD))
							.add(LootItem.lootTableItem(Items.SHELTER_POTTERY_SHERD))
							.add(LootItem.lootTableItem(Items.SNORT_POTTERY_SHERD))
							.add(LootItem.lootTableItem(Items.IRON_AXE))
							.add(LootItem.lootTableItem(Items.EMERALD).setWeight(2))
							.add(LootItem.lootTableItem(Items.WHEAT).setWeight(2))
							.add(LootItem.lootTableItem(Items.WOODEN_HOE).setWeight(2))
							.add(LootItem.lootTableItem(Items.COAL).setWeight(2))
							.add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(2))
					)
					.build();
			}

			return original;
		});
	}
}
